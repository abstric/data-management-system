/*
Navicat MySQL Data Transfer

Source Server         : levi
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : data_management_system

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2017-08-09 17:59:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sdu_sjjd_user
-- ----------------------------
DROP TABLE IF EXISTS `sdu_sjjd_user`;
CREATE TABLE `sdu_sjjd_user` (
  `uid` varchar(18) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `lrsj` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `xgsj` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
