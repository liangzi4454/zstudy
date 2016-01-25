CREATE TABLE `product_category` (
  `zid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` char(32) DEFAULT '' COMMENT '扩展主键',
  `name` varchar(50) NOT NULL COMMENT '商品分类名称',
  `code` char(10) NOT NULL COMMENT '商品分类编号',
  `level` smallint(6) DEFAULT NULL COMMENT '商品分类级别',
  `picture` varchar(100) DEFAULT NULL COMMENT '商品分类图片',
  `adv_url` varchar(100) DEFAULT NULL COMMENT '广告超链接',
  PRIMARY KEY (`zid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='商品分类表';