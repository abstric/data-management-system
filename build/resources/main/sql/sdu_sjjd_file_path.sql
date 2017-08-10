/*
Navicat MySQL Data Transfer

Source Server         : levi
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : data_management_system

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2017-08-10 16:06:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sdu_sjjd_file_path
-- ----------------------------
DROP TABLE IF EXISTS `sdu_sjjd_file_path`;
CREATE TABLE `sdu_sjjd_file_path` (
  `file_id` varchar(18) NOT NULL,
  `file_name` varchar(100) NOT NULL,
  `file_type` varchar(30) NOT NULL,
  `file_path` varchar(300) NOT NULL,
  `lrsj` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `xgsj` timestamp NULL DEFAULT NULL,
  `lrr` varchar(30) DEFAULT NULL,
  `xgr` varchar(30) DEFAULT NULL,
  `file_size` double(10,2) NOT NULL,
  `file_download_count` int(10) DEFAULT '0',
  PRIMARY KEY (`file_id`,`file_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
