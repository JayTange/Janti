CREATE DATABASE IF NOT EXISTS `janti`
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;

USE janti;

DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id`           BIGINT(20) NOT NULL AUTO_INCREMENT
  COMMENT '商品ID',
  `goods_name`   VARCHAR(16)         DEFAULT NULL
  COMMENT '商品名称',
  `goods_title`  VARCHAR(64)         DEFAULT NULL
  COMMENT '商品标题',
  `goods_img`    VARCHAR(64)         DEFAULT NULL
  COMMENT '商品的图片',
  `goods_detail` LONGTEXT            DEFAULT NULL
  COMMENT '商品的详情介绍',
  `goods_price`  DECIMAL(10, 2)      DEFAULT 0.00
  COMMENT '商品单价',
  `goods_stock`  INT(11)             DEFAULT 0
  COMMENT '商品库存，-1表示没有限制',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDb
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id`               BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id`          BIGINT(20)          DEFAULT NULL
  COMMENT '用户ID',
  `goods_id`         BIGINT(20)          DEFAULT NULL
  COMMENT '商品ID',
  `delivery_addr_id` BIGINT(20)          DEFAULT NULL
  COMMENT '收货地址ID',
  `goods_name`       VARCHAR(16)         DEFAULT NULL
  COMMENT '冗余过来的商品名称',
  `goods_count`      INT(11)             DEFAULT NULL
  COMMENT '商品数量',
  `goods_price`      DECIMAL(10, 2)      DEFAULT 0.00
  COMMENT '商品单价',
  `order_channel`    TINYINT(4)          DEFAULT 0
  COMMENT '1pc, 2android, 3ios',
  `status`           TINYINT(4)          DEFAULT 0
  COMMENT '订单状态，0新建未支付，1已支付，2已发货，3已收货，4已退款，5已完成',
  `pay_time`         DATETIME            DEFAULT NULL
  COMMENT '支付时间',
  `create_time`      DATETIME            DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 185
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `seckill_goods`;
CREATE TABLE `seckill_goods` (
  `id`            BIGINT(20) NOT NULL AUTO_INCREMENT
  COMMENT '秒杀的商品',
  `goods_id`      BIGINT(20)          DEFAULT NULL
  COMMENT '商品ID',
  `seckill_price` DECIMAL(10, 2)      DEFAULT 0.00
  COMMENT '秒杀价',
  `stock_count`   INT(11)             DEFAULT NULL
  COMMENT '库存数量',
  `start_time`    DATETIME            DEFAULT NULL
  COMMENT '秒杀开始时间',
  `end_time`      DATETIME            DEFAULT NULL
  COMMENT '秒杀结束时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS `seckill_order`;
CREATE TABLE `seckill_order` (
  `id`       BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id`  BIGINT(20)          DEFAULT NULL
  COMMENT '用户ID',
  `goods_id` BIGINT(20)          DEFAULT NULL
  COMMENT '商品ID',
  `order_id` BIGINT(20)          DEFAULT NULL
  COMMENT '商品ID',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 6391
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `seckill_user`;
CREATE TABLE `seckill_user` (
  `id`              BIGINT(20)   NOT NULL
  COMMENT '用户ID，手机号码',
  `nickname`        VARCHAR(255) NOT NULL
  COMMENT '昵称',
  `password`        VARCHAR(32),
  `salt`            VARCHAR(10)  DEFAULT '1a2b3c4d',
  `head`            VARCHAR(128) DEFAULT NULL
  COMMENT '头像，云存储的ID',
  `register_date`   DATETIME     DEFAULT NULL
  COMMENT '注册时间',
  `last_login_date` DATETIME     DEFAULT NULL
  COMMENT '上次登录时间',
  `login_count`     INT(11)      DEFAULT 0
  COMMENT '登录次数',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id`   INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(10)      DEFAULT '',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8;

INSERT INTO `seckill_goods` VALUES ('1', '1', '0.01', '-14', '2017-11-05 15:18:00', '2018-02-13 14:00:18');
INSERT INTO `seckill_goods` VALUES ('2', '2', '0.01', '9', '2018-02-05 14:00:00', '2018-02-13 14:00:18');

INSERT INTO `goods` VALUES ('1', 'iPhone X', 'Apple iPhone X (A1865) 64GB 深空灰色 移动联通电信4G手机', '/img/iphonex.png', 'Apple iPhone X (A1865) 64GB 深空灰色 移动联通电信4G手机', '8388.00', '8888');
INSERT INTO `goods` VALUES ('2', 'MacBook Pro', 'Apple MacBook Pro 15.4英寸笔记本电脑 银色', '/img/macbookpro.png', 'i7处理器，大容量固态硬盘，外设接口丰富，配备绚丽的retina显示屏，强大而专业！选购AppleCare Protection Plan，获得长达3年来自Apple的额外硬件服务选项。购买勾选：保障服务、原厂保3年。', '13599.00', '6666');
