/*
 Navicat Premium Data Transfer

 Source Server         : 线下服务器
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : 172.16.1.60:3306
 Source Schema         : tiantue

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 05/12/2018 10:56:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_admin_permission
-- ----------------------------
DROP TABLE IF EXISTS `base_admin_permission`;
CREATE TABLE `base_admin_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单名称',
  `pid` int(11) DEFAULT NULL COMMENT '父菜单id',
  `descpt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单url',
  `create_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '添加时间',
  `update_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(1) DEFAULT NULL COMMENT '删除标志（0:删除 1：存在）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of base_admin_permission
-- ----------------------------
INSERT INTO `base_admin_permission` VALUES (1, '系统管理', 0, '系统管理', '', date_format(now(), '%Y-%m-%d %H:%I:%S') , date_format(now(), '%Y-%m-%d %H:%I:%S'), 1);
INSERT INTO `base_admin_permission` VALUES (2, '账号管理', 1, '账号管理', '/user/userManage', date_format(now(), '%Y-%m-%d %H:%I:%S') , date_format(now(), '%Y-%m-%d %H:%I:%S'), 1);
INSERT INTO `base_admin_permission` VALUES (3, '角色管理', 1, '角色管理', '/role/roleManage', date_format(now(), '%Y-%m-%d %H:%I:%S') , date_format(now(), '%Y-%m-%d %H:%I:%S'),1);
INSERT INTO `base_admin_permission` VALUES (7, '权限管理', 1, '权限管理', '/permission/permissionManage', date_format(now(), '%Y-%m-%d %H:%I:%S') , date_format(now(), '%Y-%m-%d %H:%I:%S'), 1);
INSERT INTO `base_admin_permission` VALUES (9, '项目管理', 0, '项目管理', '', date_format(now(), '%Y-%m-%d %H:%I:%S') , date_format(now(), '%Y-%m-%d %H:%I:%S'), 1);
INSERT INTO `base_admin_permission` VALUES (10, '项目基本信息', 9, '项目基本信息', '/project/projectManage',  date_format(now(), '%Y-%m-%d %H:%I:%S') , date_format(now(), '%Y-%m-%d %H:%I:%S'), 1);
INSERT INTO `base_admin_permission` VALUES (11, '项目节点信息', 9, '项目节点信息', '/project/projectNodeManage', date_format(now(), '%Y-%m-%d %H:%I:%S') , date_format(now(), '%Y-%m-%d %H:%I:%S'), 1);
INSERT INTO `base_admin_permission` VALUES (12, '项目人员信息', 9, '项目人员信息', '/project/projectUserManage', date_format(now(), '%Y-%m-%d %H:%I:%S') , date_format(now(), '%Y-%m-%d %H:%I:%S'), 1);

SET FOREIGN_KEY_CHECKS = 1;
