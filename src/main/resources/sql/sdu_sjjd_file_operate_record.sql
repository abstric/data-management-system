/*
Navicat MySQL Data Transfer

Source Server         : levi
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : data_management_system

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2017-08-09 17:59:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sdu_sjjd_file_operate_record
-- ----------------------------
DROP TABLE IF EXISTS `sdu_sjjd_file_operate_record`;
CREATE TABLE `sdu_sjjd_file_operate_record` (
  `file_id` varchar(30) NOT NULL,
  `file_name` varchar(100) NOT NULL,
  `file_type` varchar(30) NOT NULL,
  `file_operate` varchar(30) NOT NULL COMMENT 'up or down',
  `file_operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `file_operate_persion` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
