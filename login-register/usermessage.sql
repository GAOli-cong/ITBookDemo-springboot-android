/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-12-02 10:56:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for usermessage
-- ----------------------------
DROP TABLE IF EXISTS `usermessage`;
CREATE TABLE `usermessage` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of usermessage
-- ----------------------------
INSERT INTO `usermessage` VALUES ('31', '高立聪', '123456', '北京', '15628737220');
INSERT INTO `usermessage` VALUES ('30', 'aaa', 'aaa', 'aaa', '111111');
INSERT INTO `usermessage` VALUES ('29', '1234', '1234', '北京', '1222223434');
INSERT INTO `usermessage` VALUES ('28', '123', '123', '132', '123');
INSERT INTO `usermessage` VALUES ('27', '111', '111', '111', '111');
INSERT INTO `usermessage` VALUES ('26', 'zhangsan1', '123456', '北京', '124345');
INSERT INTO `usermessage` VALUES ('25', 'zhangsan', '123456', '泰安', '1234567');
INSERT INTO `usermessage` VALUES ('32', 'hao', 'hao', '北京', '15628737220');
INSERT INTO `usermessage` VALUES ('33', '1234444', '321', '123', '321');
INSERT INTO `usermessage` VALUES ('34', 'admin', 'admin', '123', '123');
