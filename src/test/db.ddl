CREATE TABLE `uc_sellercategory` (
  `zid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` char(32) DEFAULT '',
  `seller_code` varchar(45) DEFAULT '' COMMENT '店铺编号',
  `category_code` varchar(45) DEFAULT '' COMMENT '分类编号',
  `category_name` varchar(450) DEFAULT '' COMMENT '分类名称',
  `parent_code` varchar(45) DEFAULT '' COMMENT '父分类编号',
  `sort` varchar(45) DEFAULT '' COMMENT '排序',
  `flaginable` varchar(45) DEFAULT '449746250001' COMMENT '是否可用',
  `level` varchar(10) DEFAULT '' COMMENT '分类级别',
  `photo` varchar(450) DEFAULT '' COMMENT '图片',
  `adv_flag` varchar(45) DEFAULT '449746250001' COMMENT '广告是否可用',
  `adv_pic` varchar(450) DEFAULT '' COMMENT '广告图片',
  `adv_href` varchar(450) DEFAULT '' COMMENT '广告超链接',
  PRIMARY KEY (`zid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='店铺商品分类表';

CREATE TABLE `pc_brandinfo` (
  `zid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` char(32) DEFAULT '',
  `brand_code` varchar(45) DEFAULT '' COMMENT '品牌编号',
  `brand_name` varchar(450) DEFAULT '' COMMENT '中文名称',
  `brand_name_en` varchar(45) DEFAULT NULL COMMENT '英文名称',
  `flag_enable` int(11) DEFAULT '1' COMMENT '是否可用',
  `brand_pic` varchar(450) DEFAULT '' COMMENT '品牌图片',
  `brand_note` varchar(8000) DEFAULT '' COMMENT '品牌描述',
  `parent_code` varchar(45) DEFAULT '' COMMENT '父节点',
  `cpsrate` decimal(18,2) DEFAULT '0.00' COMMENT '佣金比例',
  `create_usernm` varchar(45) DEFAULT '' COMMENT '创建人',
  `create_time` varchar(19) DEFAULT '' COMMENT '创建时间',
  `create_usercode` varchar(45) DEFAULT '' COMMENT '创建人编号',
  PRIMARY KEY (`zid`),
  UNIQUE KEY `brand_code_UNIQUE` (`brand_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4033 DEFAULT CHARSET=utf8 COMMENT='商品品牌表';

CREATE TABLE `uc_sellercategory_brand_relation` (
  `zid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` char(32) DEFAULT NULL,
  `brand_code` varchar(45) DEFAULT NULL COMMENT '品牌编号',
  `category_code` varchar(45) DEFAULT '' COMMENT '分类编号',
  `seller_code` varchar(45) DEFAULT '' COMMENT '店铺编号',
  `create_time` char(19) DEFAULT '' COMMENT '创建时间',
  PRIMARY KEY (`zid`)
) ENGINE=InnoDB AUTO_INCREMENT=355 DEFAULT CHARSET=utf8 COMMENT='分类与品牌关系表';

CREATE TABLE `uc_sellercategory_product_relation` (
  `zid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` char(32) DEFAULT NULL,
  `product_code` varchar(45) DEFAULT NULL COMMENT '商品编号',
  `category_code` varchar(45) DEFAULT '' COMMENT '分类编号',
  `seller_code` varchar(45) DEFAULT '' COMMENT '店铺编号',
  PRIMARY KEY (`zid`)
) ENGINE=InnoDB AUTO_INCREMENT=75309 DEFAULT CHARSET=utf8 COMMENT='店铺商品分类与商品关联表';

CREATE TABLE `pc_productinfo` (
  `zid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` char(32) DEFAULT '',
  `product_code_old` varchar(45) DEFAULT '' COMMENT '老数据',
  `product_code` varchar(45) DEFAULT '' COMMENT '商品编码',
  `product_name` varchar(450) DEFAULT '' COMMENT '商品名称',
  `product_shortname` varchar(450) DEFAULT '' COMMENT '商品简称',
  `video_url` varchar(450) DEFAULT '' COMMENT '商品视频链接',
  `seller_code` varchar(45) DEFAULT '' COMMENT '卖家编号',
  `small_seller_code` varchar(45) DEFAULT '' COMMENT '小用户编号',
  `brand_code` varchar(45) DEFAULT '' COMMENT '品牌编号',
  `product_weight` decimal(18,2) DEFAULT '0.00' COMMENT '商品重量',
  `flag_sale` int(11) DEFAULT '1' COMMENT '是否可售',
  `create_time` char(19) DEFAULT '' COMMENT '创建时间',
  `update_time` char(19) DEFAULT '' COMMENT '更新时间',
  `min_sell_price` decimal(18,2) DEFAULT '0.00' COMMENT '销售价格最小',
  `max_sell_price` decimal(18,2) DEFAULT '0.00' COMMENT '销售价格最大',
  `market_price` decimal(18,2) DEFAULT '0.00' COMMENT '市场价格',
  `cost_price` decimal(18,2) DEFAULT '0.00' COMMENT '成本价格',
  `tax_rate` decimal(18,2) DEFAULT '0.00' COMMENT '税率',
  `product_status` varchar(45) DEFAULT '4497153900060001' COMMENT '商品状态',
  `product_volume` decimal(18,2) DEFAULT '0.00' COMMENT '体积',
  `transport_template` varchar(45) DEFAULT '' COMMENT '运费模板',
  `area_template` varchar(45) DEFAULT '' COMMENT '限购地区模板',
  `sell_productcode` varchar(50) DEFAULT '' COMMENT '商家编码',
  `supplier_name` varchar(450) DEFAULT '' COMMENT '供应商名称',
  `mainpic_url` varchar(200) DEFAULT '' COMMENT '主图Url',
  `labels` varchar(8000) DEFAULT '' COMMENT '商品标签',
  `flag_payway` int(11) DEFAULT '0' COMMENT '是否货到付款 0 否 1 是',
  `product_volume_item` varchar(500) DEFAULT '' COMMENT '长宽高',
  `sale_scope_did` varchar(45) DEFAULT '449746400001' COMMENT '销售范围限制',
  `validate_flag` varchar(1) DEFAULT 'N' COMMENT '是否是虚拟商品  Y：是  N：否',
  `product_code_copy` varchar(45) DEFAULT '' COMMENT '来源商品编号',
  `adpic_url` varchar(200) DEFAULT '' COMMENT '广告图',
  PRIMARY KEY (`zid`),
  UNIQUE KEY `product_code` (`product_code`),
  KEY `product_code_old` (`product_code_old`),
  KEY `index_product_status` (`product_status`)
) ENGINE=InnoDB AUTO_INCREMENT=436867 DEFAULT CHARSET=utf8 COMMENT='商品信息表';


