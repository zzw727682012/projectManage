
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_project_info
-- ----------------------------
DROP TABLE IF EXISTS `base_project_info`;
CREATE TABLE `base_project_info` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`project_name` VARCHAR(30) NOT NULL COMMENT '项目名称' COLLATE 'utf8_general_ci',
	`project_source` VARCHAR(50) NULL DEFAULT NULL COMMENT '项目来源' COLLATE 'utf8_general_ci',
	`project_budget_amount` DECIMAL(11,0) NULL DEFAULT NULL COMMENT '预算总经费',
	`project_account_amount` DECIMAL(11,0) NULL DEFAULT NULL COMMENT '到账经费',
	`project_manager_id` INT(10) NULL DEFAULT NULL COMMENT '项目主导人id',
	`project_researchers` VARCHAR(200) NULL DEFAULT NULL COMMENT '项目参研人员' COLLATE 'utf8_general_ci',
	`technical_report` VARCHAR(200) NULL DEFAULT NULL COMMENT '技术报告' COLLATE 'utf8_general_ci',
	`final_report` VARCHAR(200) NULL DEFAULT NULL COMMENT '总结报告' COLLATE 'utf8_general_ci',
	`node_count` INT(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '节点数量',
	`create_time` VARCHAR(64) NULL DEFAULT NULL COMMENT '添加时间' COLLATE 'utf8_general_ci',
	`expiration_time` VARCHAR(64) NULL DEFAULT NULL COMMENT '到期时间' COLLATE 'utf8_general_ci',
	`if_finish` VARCHAR(50) NULL DEFAULT NULL COMMENT '完成标志' COLLATE 'utf8_general_ci',
	`start_time` VARCHAR(64) NULL DEFAULT NULL COMMENT '开始日期' COLLATE 'utf8_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
ROW_FORMAT=COMPACT
AUTO_INCREMENT=22
;



DROP TABLE IF EXISTS `base_project_user`;
CREATE TABLE `base_project_user` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`user_name` VARCHAR(30) NOT NULL COMMENT '姓名' COLLATE 'utf8_general_ci',
	`user_sex` VARCHAR(10) NOT NULL DEFAULT '' COMMENT '性别' COLLATE 'utf8_general_ci',
	`user_birthday` VARCHAR(50) NULL DEFAULT NULL COMMENT '出生日期' COLLATE 'utf8_general_ci',
	`user_politics_status` VARCHAR(50) NULL DEFAULT NULL COMMENT '政治面貌' COLLATE 'utf8_general_ci',
	`user_join_time` VARCHAR(50) NULL DEFAULT NULL COMMENT '入党团时间' COLLATE 'utf8_general_ci',
	`user_graduate_institutions` VARCHAR(50) NULL DEFAULT NULL COMMENT '毕业院校' COLLATE 'utf8_general_ci',
	`user_organization` VARCHAR(50) NULL DEFAULT NULL COMMENT '工作单位' COLLATE 'utf8_general_ci',
	`user_teaching_office` VARCHAR(50) NULL DEFAULT NULL COMMENT '教研室' COLLATE 'utf8_general_ci',
	`user_home_address` VARCHAR(50) NULL DEFAULT NULL COMMENT '家庭住址' COLLATE 'utf8_general_ci',
	`create_time` VARCHAR(64) NULL DEFAULT NULL COMMENT '添加时间' COLLATE 'utf8_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
ROW_FORMAT=COMPACT
AUTO_INCREMENT=25
;


DROP TABLE IF EXISTS `base_project_node`;
CREATE TABLE `base_project_node` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`project_name` VARCHAR(30) NULL DEFAULT NULL COMMENT '项目名称' COLLATE 'utf8_general_ci',
	`project_id` INT(10) NOT NULL COMMENT '项目id',
	`project_node_name` VARCHAR(50) NOT NULL COMMENT '项目节点名称' COLLATE 'utf8_general_ci',
	`project_node_finish` VARCHAR(10) NULL DEFAULT NULL COMMENT '项目节点是否完成' COLLATE 'utf8_general_ci',
	`project_manager_id` INT(10) NULL DEFAULT NULL COMMENT '主导人id',
	`project_node_attachment` VARCHAR(200) NULL DEFAULT NULL COMMENT '节点附件' COLLATE 'utf8_general_ci',
	`create_time` VARCHAR(64) NULL DEFAULT NULL COMMENT '添加时间' COLLATE 'utf8_general_ci',
	`expiration_time` VARCHAR(64) NULL DEFAULT NULL COMMENT '截止日期' COLLATE 'utf8_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
ROW_FORMAT=COMPACT
AUTO_INCREMENT=19
;


SET FOREIGN_KEY_CHECKS = 1;
