/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : test1

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2016-11-05 21:17:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20)  AUTO_INCREMENT    NOT NULL COMMENT '主键id',
  `userName` varchar(32)  DEFAULT '' NOT NULL COMMENT '用户名',
  `passWord` varchar(32)  DEFAULT '' NOT NULL COMMENT '密码',
  `user_sex` varchar(32)  DEFAULT '' NOT NULL COMMENT '性别',
  `nick_name` varchar(32) DEFAULT '' NOT NULL COMMENT '昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28;

