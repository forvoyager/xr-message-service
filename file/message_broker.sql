CREATE SCHEMA `xr_message_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

USE `xr_message_db`;

CREATE TABLE `xr_message_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息id',
  `type_id` smallint(6) NOT NULL DEFAULT '0' COMMENT '类型id',
  `producer_id` smallint(6) NOT NULL DEFAULT '0' COMMENT '生产者id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态 0待发送 1成功 2失败',
  `retries` tinyint(4) NOT NULL DEFAULT '0' COMMENT '重试次数',
  `version` tinyint(4) NOT NULL DEFAULT '0' COMMENT '版本号',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_type` (`type_id`),
  KEY `idx_producer` (`producer_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息记录表';

CREATE TABLE `xr_message_content` (
  `msg_id` BIGINT NOT NULL DEFAULT 0 COMMENT '消息id',
  `content` MEDIUMTEXT NOT NULL DEFAULT '' COMMENT '消息内容',
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '消息内容表';

CREATE TABLE `xr_message_producer` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT COMMENT '生产者id',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '生产者名字',
  `verify_url` varchar(45) NOT NULL DEFAULT '' COMMENT '消息订单验证地址',
  `description` varchar(45) NOT NULL DEFAULT '' COMMENT '生产者描述',
  `version` tinyint(4) NOT NULL DEFAULT '0' COMMENT '版本号',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息生产者';

CREATE TABLE `xr_message_consumer` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT COMMENT '消费者id',
  `name` varchar(45) NOT NULL COMMENT '消费者名字',
  `consumer_url` varchar(100) NOT NULL COMMENT '消息者地址',
  `description` varchar(100) NOT NULL COMMENT '消息者描述',
  `version` tinyint(4) NOT NULL DEFAULT '0' COMMENT '版本号',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息消费者';

CREATE TABLE `xr_message_type` (
  `id` smallint(6) NOT NULL DEFAULT '0' COMMENT '类型id',
  `name` varchar(45) NOT NULL,
  `code` varchar(45) NOT NULL,
  `producer_id` smallint(6) NOT NULL,
  `description` varchar(100) NOT NULL DEFAULT '' COMMENT '描述',
  `version` tinyint(4) NOT NULL DEFAULT '0' COMMENT '版本号',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息类型';

CREATE TABLE `xr_message_consumer_ref_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `consumer_id` SMALLINT NOT NULL DEFAULT 0 COMMENT '消费者id',
  `type_id` SMALLINT NOT NULL DEFAULT 0 COMMENT '消息类型id',
  `version` tinyint(4) NOT NULL DEFAULT '0' COMMENT '版本号',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '消费者与消息类型关联关系';