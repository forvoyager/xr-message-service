import com.xr.base.common.util.HttpUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-16 16:25:00 <br>
 * <b>description</b>: 消息操作 测试<br>
 */
public class MessageTest {

  private Map<String, Object> params = new HashMap<>();

  @Test
  public void send() throws Exception{
    // /message/send?topic=test_topic&tag=test_tag&type=0&data=sdfadfsd
    params.put("topic", "test_topic");
    params.put("tag", "test_tag");
    params.put("type", "0");
    for(int i = 0; i<3; i++){
      params.put("data", "TEST:"+System.currentTimeMillis());
      get("/message/send", params);
    }
  }

  @Test
  public void confirm() throws Exception{
    // /message/confirm?messageIdList%5B0%5D=1
    List<Long> messageIdList = new ArrayList<>();
    messageIdList.add(666L);
    params.put("messageIdList", messageIdList);
    post("/message/confirm", params);
  }

  @Test
  public void cancel() throws Exception{
    // /message/cancel?messageIdList%5B0%5D=1
    List<Long> messageIdList = new ArrayList<>();
    messageIdList.add(666L);
    params.put("messageIdList", messageIdList);
    post("/message/cancel", params);
  }

  private String get(String uri, Map params) throws Exception{
    return HttpUtils.get(getUrl(uri), params);
  }

  private String post(String uri, Map params) throws Exception{
    return HttpUtils.post(getUrl(uri), params);
  }

  private String getUrl(String uri){
    return "http://localhost:9999"+uri;
  }
}
