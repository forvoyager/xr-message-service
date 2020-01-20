package com.xr.message.consumer.processor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.xr.base.common.EnvUtils;
import com.xr.base.common.dto.ResultDto;
import com.xr.base.common.util.AssertUtils;
import com.xr.base.common.util.HttpUtils;
import com.xr.base.common.util.JsonUtils;
import com.xr.base.common.util.Utils;
import com.xr.message.common.dto.PullMessageDto;
import com.xr.message.consumer.ConsumerProperties;
import com.xr.message.consumer.annotation.Consumer;
import com.xr.message.consumer.service.IMessageConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-19 16:06:00 <br>
 * <b>description</b>: 消费处理（推送模式）<br>
 */
@Component
public class PushConsumerProcessor implements DisposableBean {

  private Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * 调度线程
   */
  private final ScheduledExecutorService scheduledExecutorService;
  /**
   * 消息处理线程
   */
  private final ExecutorService processExecutorService;
  /**
   * 消费者实例{IP}@{JVM PID}
   */
  private String instance;
  /**
   * 消费者是否准备就绪，可以拉取消息了，默认false，
   * 所有消费者都注册成功后更新为true
   */
  private boolean available;
  /**
   * 当前jvm中所有的消费者
   */
  private List<IMessageConsumerService> consumerList;
  /**
   * 消费者及ID map关系
   * Map<consumer_id, 消费者>
   */
  private final Map<Long, IMessageConsumerService> consumerMap;

  @Autowired
  private ConsumerProperties consumerProperties;

  public PushConsumerProcessor(){
    this.available = false;
    this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new XrThreadFactory("XrMessageScheduledThread_"));
    // max(当前CPU数, n) 最少n个线程
    int corePoolSize = Math.max(Runtime.getRuntime().availableProcessors(), 3);
    this.processExecutorService = new ThreadPoolExecutor(corePoolSize, 10, 15, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(), new XrThreadFactory("XrMessageProcessThread_"));
    this.consumerList = new ArrayList<>();
    this.consumerMap = new HashMap<Long, IMessageConsumerService>();
  }

  /**
   * 初始化消费者
   * @throws Exception
   */
  public void init() throws Exception{

    logger.info("init consumer, start...");

    if(consumerList == null){ return; }

    ResultDto<Long> resultDto = null;
    Class callbackClazz = null;
    Consumer consumerAnn = null;
    String consumerName = null;
    for(IMessageConsumerService consumer : consumerList){
      callbackClazz = consumer.getClass();
      consumerName = callbackClazz.getName();
      consumerAnn = (Consumer) callbackClazz.getAnnotation(Consumer.class);
      AssertUtils.notNull(consumerAnn, "消费者："+consumerName+"，需要用@Consumer注解标注。");

      resultDto = this.sendRequest("/consumer/signup", Utils.newHashMap(
              "topic", consumerAnn.topic(),
              "tag", consumerAnn.tag(),
              "group", consumerAnn.group(),
              "instance", this.instance,
              "name", consumerName
      ), new TypeReference<ResultDto<Long>>(){});
      resultDto.assertSuccess();

      // 消费者ID与消费者 map
      consumerMap.put(resultDto.getData(), consumer);

      logger.info("consumer:{}, signup success...");
    }

    // 消费者初始化完成，可以拉取消息了
    this.available = true;

    logger.info("init consumer, success...");
  }

  /**
   * 启动消费者，开始拉取消息
   * @throws Exception
   */
  public void start() throws Exception{
    // 从此刻开始，以每5s一次的频率拉取消息
    this.scheduledExecutorService.scheduleAtFixedRate( ()->{pullMessage();}, 0, 5, TimeUnit.SECONDS);
  }

  /**
   * 拉取消息
   */
  private void pullMessage(){
    if(!this.available){
      logger.warn("消费者未就绪...");
      return;
    }

    if(consumerMap.size() == 0){
      logger.warn("there is no any available consumer, skip pull message!");
      return;
    }

    for(Map.Entry<Long, IMessageConsumerService> entry : consumerMap.entrySet()){
      IMessageConsumerService consumer = entry.getValue();
      try {
        ResultDto<List<PullMessageDto>> result = this.sendRequest("/consumer/pull", Utils.newHashMap(
                "consumer_id", entry.getKey(),
                "offset_type", 0,
                "offset", 0,
                "size", consumerProperties.getPullRows()
        ), new TypeReference<ResultDto<List<PullMessageDto>>>(){});
        result.assertSuccess();

        // 处理消息
        this.processExecutorService.submit(()->{processMessage(consumer, result.getData());});

      }catch (Exception e){
        logger.warn("消费者：{}，拉取消息失败，原因：{}。", consumer.getClass().getName(), e.getMessage());
      }
    }
  }

  /**
   * 处理消息
   * @param consumer 消费者
   * @param messages 需要处理的消息
   */
  private void processMessage(IMessageConsumerService consumer, List<PullMessageDto> messages){
    for(PullMessageDto message : messages){
      try {
//        consumer.onMessage()
        // todo ((ParameterizedType)(consumer.getClass().getGenericSuperclass())).getActualTypeArguments()[0]
        logger.info("consumer:{}, process message:{}, success.", consumer.getClass().getName(), message.getMessage_id());
      }catch (Exception e){

      }
    }
  }

  private <T> ResultDto<T> sendRequest(String uri, Map params, TypeReference responseType) throws Exception{
    String response = HttpUtils.get(consumerProperties.getNameServerAddress()+uri, params);
    ResultDto resultDto = JsonUtils.parseObject(response, responseType);
    AssertUtils.notNull(resultDto, "请求服务器失败");
    return resultDto;
  }

  @Autowired(required = false)
  public PushConsumerProcessor setConsumerList(List<IMessageConsumerService> consumerList) {
    this.consumerList = consumerList;
    return this;
  }

  @PostConstruct
  public void setInstance() throws Exception{
    this.instance = EnvUtils.getIP()+"@"+EnvUtils.getPid();
  }

  @Override
  public void destroy() throws Exception {
    this.scheduledExecutorService.shutdown();
  }
}
