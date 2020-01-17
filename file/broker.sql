CREATE SCHEMA `xr_message_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

USE `xr_message_db`;

create user xr_message identified by '123456';
-- 分配权限
grant all privileges on xr_message_db.* to 'xr_message'@'%'identified by '123456' with grant option;
grant all privileges on xr_message_db.* to 'xr_message'@'localhost'identified by '123456' with grant option;
-- 刷新mysql用户权限
flush privileges ;

-- 点对点模式
CREATE TABLE `xr_message_info` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '消息id',
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
  `content` MEDIUMTEXT NOT NULL COMMENT '消息内容',
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



-- 发布订阅模式
CREATE TABLE `xr_topic` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'topic id',
  `name` varchar(45) NOT NULL COMMENT 'topic 名字',
  `description` varchar(100) NOT NULL COMMENT 'topic 描述',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息主题';

CREATE TABLE `xr_tag` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'tag id',
  `name` varchar(45) NOT NULL COMMENT 'tag 名字',
  `description` varchar(100) NOT NULL COMMENT 'tag 描述',
  `topic_id` BIGINT NOT NULL DEFAULT '0' COMMENT 'topic id',
  `offset_message_id` BIGINT NOT NULL DEFAULT 0 COMMENT '最新被消费的消息id',
  `version` BIGINT NOT NULL DEFAULT '0' COMMENT '版本号',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息tag';

CREATE TABLE `xr_message` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '消息id',
  `topic_id` BIGINT NOT NULL DEFAULT '0' COMMENT 'topic id',
  `tag_id` BIGINT NOT NULL DEFAULT '0' COMMENT 'tag id',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '类型 see MessageType',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态 0待确认 1待发送 2成功 3失败 4无效',
  `version` tinyint(4) NOT NULL DEFAULT '0' COMMENT '版本号',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_topic_tag` (`topic_id`,`tag_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息记录';

CREATE TABLE `xr_message_content` (
  `message_id` BIGINT NOT NULL DEFAULT 0 COMMENT '消息id',
  `content` MEDIUMTEXT NOT NULL COMMENT '消息内容',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '消息内容';

-- CREATE TABLE `xr_message_consume` (
--   `tag_id` BIGINT NOT NULL DEFAULT 0 COMMENT 'tag id',
--   `offset_message_id` BIGINT NOT NULL DEFAULT 0 COMMENT 'message id',
--   `version` tinyint(4) NOT NULL DEFAULT '0' COMMENT '版本号',
--   `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
--   `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '最后更新时间',
--   PRIMARY KEY (`tag_id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '消息消费记录';
--
-- CREATE TABLE `xr_message_subscribe` (
--   `id` BIGINT NOT NULL DEFAULT '0' COMMENT '主键id',
--   `instance_id` varchar(120) NOT NULL DEFAULT '' COMMENT '实例id，建议：{IP}_{APPLICATION_NAME}',
--   `topic_id` BIGINT NOT NULL DEFAULT '0' COMMENT 'topic id',
--   `offset_message_id` BIGINT NOT NULL DEFAULT '0',
--   `version` tinyint(4) NOT NULL DEFAULT '0' COMMENT '版本号',
--   `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
--   `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '最后更新时间',
--   PRIMARY KEY (`id`),
--   UNIQUE KEY `unq_instance_id` (`instance_id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息订阅记录';
--
