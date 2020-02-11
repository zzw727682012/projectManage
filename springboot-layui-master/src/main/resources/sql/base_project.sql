
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_project_info
-- ----------------------------
DROP TABLE IF EXISTS `base_project_info`;
CREATE TABLE `base_project_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目名称',
  `project_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目类型',
  `project_source` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目来源',
  `project_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目编号',
  `project_budget_amount` decimal(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '预算总经费',
  `project_account_amount` decimal(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '到账经费',
  `project_manager_id` int(11) NOT NULL COMMENT '项目主导人id',
  `project_contract` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目合同',
  `create_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '添加时间',
  `update_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(1) DEFAULT NULL COMMENT '删除标志（0:删除 1：存在）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;


DROP TABLE IF EXISTS `base_project_user`;
CREATE TABLE `base_project_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目名称',
  `project_id` int(11) NOT NULL COMMENT '项目id',
  `project_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目编号',
  `project_user_id int(11) DEFAULT NULL COMMENT '参研人员id',
  `project_manager_id` int(11) NOT NULL COMMENT '项目主导人id'  `create_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '添加时间',
  `update_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(1) DEFAULT NULL COMMENT '删除标志（0:删除 1：存在）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

DROP TABLE IF EXISTS `base_project_plan`;
CREATE TABLE `base_project_plan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目名称',
  `project_id` int(11) NOT NULL COMMENT '项目id',
  `project_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目编号',
  `project_node_name varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目结点名称',
  `project_node_finish varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目结点是否完成',
  `project_node_delay_reason varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目结点未完成原因',

  `project_manager_id` int(11) NOT NULL COMMENT '项目主导人id'  `create_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '添加时间',
  `update_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(1) DEFAULT NULL COMMENT '删除标志（0:删除 1：存在）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
-- ----------------------------
-- Records of base_project_info
-- ----------------------------
INSERT INTO `base_project_info` VALUES (1, '系统管理', 0, '系统管理', '', '2018-11-30 10:27:34', '2018-11-30 10:27:34', 1);
INSERT INTO `base_project_info` VALUES (2, '账号管理', 1, '账号管理', '/user/userManage', '2018-11-30 11:44:41', '2018-11-30 11:56:34', 1);
INSERT INTO `base_project_info` VALUES (3, '角色管理', 1, '角色管理', '/role/roleManage', '2018-11-30 11:45:27', '2018-11-30 11:45:27', 1);
INSERT INTO `base_project_info` VALUES (7, '权限管理', 1, '权限管理', '/permission/permissionManage', '2018-11-30 11:48:35', '2018-11-30 15:13:38', 1);
INSERT INTO `base_project_info` VALUES (9, '基本设置', 0, '基本设置', '', '2018-11-30 12:10:32', '2018-11-30 12:10:32', 1);
INSERT INTO `base_project_info` VALUES (10, '服务类目管理', 9, '服务类目管理', '/goodsCategory/goodsCategoryManage', '2018-12-04 11:47:07', '2018-12-04 11:47:07', 1);
INSERT INTO `base_project_info` VALUES (11, '服务类型管理', 9, '服务类型管理', '/serviceType/serviceTypeManage', '2018-12-04 11:47:59', '2018-12-04 11:47:59', 1);
INSERT INTO `base_project_info` VALUES (12, '支付方式', 9, '支付方式', '/payplatform/payplatManage', '2018-12-04 11:48:44', '2018-12-04 11:48:44', 1);
INSERT INTO `base_project_info` VALUES (13, '银行管理', 9, '银行管理', '/bank/bankManage', '2018-12-04 11:49:13', '2018-12-04 11:49:13', 1);
INSERT INTO `base_project_info` VALUES (14, '省市区管理', 9, '省市区管理', '/position/positionManage', '2018-12-04 11:49:36', '2018-12-04 11:50:02', 1);

SET FOREIGN_KEY_CHECKS = 1;
