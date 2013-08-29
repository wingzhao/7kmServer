-- 创建数据库
CREATE DATABASE daojia
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

-- 创建表

-- 品类表
CREATE TABLE `category` (
	`id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '品类主键',
	`parent_id` INT(11) NULL DEFAULT '0' COMMENT '父品类id',
	`cat_name` VARCHAR(20) NULL DEFAULT NULL COMMENT '品类名称',
	`is_enable` TINYINT(1) NULL DEFAULT NULL COMMENT '是否可用 TrueOrFalse enum',
	`last_time` DATETIME NULL DEFAULT NULL COMMENT '最后更新时间',
	PRIMARY KEY (`id`),
	INDEX `indx_last_time` (`last_time`)
)
COMMENT='品类表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

