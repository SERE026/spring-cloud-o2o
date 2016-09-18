/*
Navicat MySQL Data Transfer

Source Server         : cloud
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : cloud

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2016-09-12 16:01:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_cloud_event
-- ----------------------------
DROP TABLE IF EXISTS `t_cloud_event`;
CREATE TABLE `t_cloud_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` bigint(20) DEFAULT NULL,
  `last_modified` bigint(20) DEFAULT NULL,
  `cloud_event_type` int(11) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cloud_event_id_uindex` (`id`),
  KEY `IDX_CLOUD_EVENT_USER` (`id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
