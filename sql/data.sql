CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `goods_name` varchar(16) DEFAULT NULL COMMENT '商品名称',
  `goods_title` varchar(64) DEFAULT NULL COMMENT '商品标题',
  `goods_img` varchar(64) DEFAULT NULL COMMENT '商品的图片',
  `goods_detail` longtext COMMENT '商品的详情介绍',
  `goods_price` decimal(10,2) DEFAULT '0.00' COMMENT '商品单价',
  `goods_stock` int(11) DEFAULT '0' COMMENT '商品库存, -1表示没有限制',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='商品表';

CREATE TABLE `miaosha_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '秒杀的商品表',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品ld',
  `miaosha_price` decimal(10,2) DEFAULT '0.00' COMMENT '秒杀价',
  `stock_count` int(11) DEFAULT NULL COMMENT '库存数量',
  `start_date` datetime DEFAULT NULL COMMENT '秒杀开始时间',
  `end_date` datetime DEFAULT NULL COMMENT '秒杀结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='秒杀商品表';


CREATE TABLE `miaosha_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '秒杀的商品表',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品ld',
  `miaosha_price` decimal(10,2) DEFAULT '0.00' COMMENT '秒杀价',
  `stock_count` int(11) DEFAULT NULL COMMENT '库存数量',
  `start_date` datetime DEFAULT NULL COMMENT '秒杀开始时间',
  `end_date` datetime DEFAULT NULL COMMENT '秒杀结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='秒杀商品表';

CREATE TABLE `miaosha_user` (
  `id` bigint(20) NOT NULL COMMENT '用户ID,手机号码',
  `nickname` varchar(255) NOT NULL COMMENT '用户昵称',
  `password` varchar(32) DEFAULT NULL COMMENT 'MD5 (MD5 (pass明文+固定salt) + salt)',
  `salt` varchar(10) DEFAULT NULL COMMENT 'md5的盐',
  `head` varchar(128) DEFAULT NULL COMMENT '头像，云存储的ID',
  `register date` datetime DEFAULT NULL COMMENT '注册时间',
  `last_login_date` datetime DEFAULT NULL COMMENT '上蔟登录时间',
  `login count` int(11) DEFAULT '0' COMMENT '登录次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='秒杀的用户表';

CREATE TABLE `order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `delivery_addr_id` bigint(20) DEFAULT NULL COMMENT '收获地址ID',
  `goods_name` varchar(16) DEFAULT NULL COMMENT '冗余过来的商品名称',
  `goods_count` int(11) DEFAULT '0' COMMENT '商品数量',
  `goods_price` decimal(10,2) DEFAULT '0.00' COMMENT '商品单价',
  `order_channel` tinyint(4) DEFAULT '0' COMMENT '1pc , 2android , 3ios',
  `status` tinyint(4) DEFAULT '0' COMMENT '订单状态, 0新建末支付, 1已支付, 2已发货, 3已收货, 4已退款, 5已完成',
  `create_date` datetime DEFAULT NULL COMMENT '订单的创建时间',
  `pay_ date` datetime DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COMMENT='订单信息表';

CREATE TABLE `user` (
  `id` int(10) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';


INSERT INTO `miaosha`.`goods`(`id`, `goods_name`, `goods_title`, `goods_img`, `goods_detail`, `goods_price`, `goods_stock`)
VALUES (1, 'iphonex', '苹果iphonex', '/img/iphonex.png', NULL, 5288.00, 1);
INSERT INTO `miaosha`.`goods`(`id`, `goods_name`, `goods_title`, `goods_img`, `goods_detail`, `goods_price`, `goods_stock`)
VALUES (2, 'meta10.', '华为 meta10', '/img/meta10.png', NULL, 9288.00, 1);

INSERT INTO `miaosha`.`miaosha_goods`(`id`, `goods_id`, `miaosha_price`, `stock_count`, `start_date`, `end_date`)
VALUES (1, 1, 0.01, 10, '2017-11-05 15:18:00', '2017-11-13 14:00:18');
INSERT INTO `miaosha`.`miaosha_goods`(`id`, `goods_id`, `miaosha_price`, `stock_count`, `start_date`, `end_date`)
VALUES (2, 2, 0.01, 10, '2017-11-12 14:00:14', '2017-11-13 14:00:24');