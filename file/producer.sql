
CREATE TABLE `xr_message_producer_order` (
  `id` BIGINT(20) NOT NULL COMMENT 'ID',
  `order_id` BIGINT(20) NULL DEFAULT 0 COMMENT '订单id',
  `version` tinyint(4) NOT NULL DEFAULT '0' COMMENT '版本号',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `unq_order_id` (`order_id` ASC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '消息生产者订单';

