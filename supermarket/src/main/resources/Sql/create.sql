-------- 系统
	--	用户
CREATE TABLE `t_sm_system_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `telphone` varchar(100) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `beizhu` varchar(255) DEFAULT NULL,
  `createBy` int(11) DEFAULT NULL,
  `updateBy` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `del` char(10) DEFAULT NULL,
  `enable` char(10) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;




--------	业务
	-----	库存

CREATE TABLE `t_sm_stock` (
  `stockId` int(11) NOT NULL AUTO_INCREMENT,
  `productId` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `createBy` int(11) DEFAULT NULL,
  `updateBy` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `del` char(10) DEFAULT NULL,
  `enable` char(10) DEFAULT NULL,
  PRIMARY KEY (`stockId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;