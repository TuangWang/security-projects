-- MySQL Script generated by MySQL Workbench
-- Thu Jun 13 15:41:19 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema BBS
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `BBS` ;

-- -----------------------------------------------------
-- Schema BBS
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BBS` DEFAULT CHARACTER SET utf8mb4 ;
USE `BBS` ;

-- -----------------------------------------------------
-- Table `BBS`.`tbl_bbs_board`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BBS`.`tbl_bbs_board` ;

CREATE TABLE IF NOT EXISTS `BBS`.`tbl_bbs_board` (
  `board_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '板块id',
  `board_title` VARCHAR(45) NOT NULL,
  `board_desc` VARCHAR(45) NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`board_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `BBS`.`tbl_bbs_comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BBS`.`tbl_bbs_comment` ;

CREATE TABLE IF NOT EXISTS `BBS`.`tbl_bbs_comment` (
  `content` VARCHAR(500) NULL DEFAULT '评论内容',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  `comment_id` BIGINT NOT NULL AUTO_INCREMENT,
  `post_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`comment_id`),
  INDEX `fk_tbl_bbs_comment_tbl_bbs_post1_idx` (`post_id` ASC),
  INDEX `fk_tbl_bbs_comment_tbl_bbs_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_tbl_bbs_comment_tbl_bbs_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `BBS`.`tbl_bbs_post` (`post_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_bbs_comment_tbl_bbs_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `BBS`.`tbl_bbs_user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `BBS`.`tbl_bbs_post`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BBS`.`tbl_bbs_post` ;

CREATE TABLE IF NOT EXISTS `BBS`.`tbl_bbs_post` (
  `post_id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(10) NOT NULL,
  `content` TEXT(10000) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  `user_id` BIGINT NOT NULL,
  `board_id` BIGINT NOT NULL,
  PRIMARY KEY (`post_id`),
  INDEX `fk_tbl_bbs_post_tbl_bbs_user1_idx` (`user_id` ASC),
  INDEX `fk_tbl_bbs_post_tbl_bbs_board1_idx` (`board_id` ASC),
  CONSTRAINT `fk_tbl_bbs_post_tbl_bbs_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `BBS`.`tbl_bbs_user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_bbs_post_tbl_bbs_board1`
    FOREIGN KEY (`board_id`)
    REFERENCES `BBS`.`tbl_bbs_board` (`board_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `BBS`.`tbl_bbs_school`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BBS`.`tbl_bbs_school` ;

CREATE TABLE IF NOT EXISTS `BBS`.`tbl_bbs_school` (
  `school_id` INT NOT NULL,
  `school_name` VARCHAR(45) NULL,
  `school_location` VARCHAR(255) NULL,
  `school_url` VARCHAR(255) NULL COMMENT '校徽',
  PRIMARY KEY (`school_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '学校表';


-- -----------------------------------------------------
-- Table `BBS`.`tbl_bbs_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BBS`.`tbl_bbs_user` ;

CREATE TABLE IF NOT EXISTS `BBS`.`tbl_bbs_user` (
  `user_id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL COMMENT '用户名',
  `password` VARCHAR(45) NOT NULL COMMENT '密码',
  `icon_url` VARCHAR(1000) NULL COMMENT '图像url',
  `phone` CHAR(11) NULL COMMENT '手机号',
  `weixin` VARCHAR(45) NULL COMMENT '微信号',
  `qq` VARCHAR(45) NULL COMMENT 'qq号',
  `level` VARCHAR(45) NULL COMMENT '论坛等级',
  `title` VARCHAR(45) NULL COMMENT '头衔',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  `student_number` VARCHAR(45) NULL COMMENT '学号',
  `status` CHAR(1) NULL COMMENT '账号状态\n0 正常\n1 未认证\n2 锁定\n3 删除\n',
  `school_id` INT NOT NULL,
  `gender` CHAR(1) NULL COMMENT '0 male\n1 female',
  `email` VARCHAR(255) NULL COMMENT '邮箱',
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  INDEX `fk_tbl_bbs_user_tbl_bbs_school_idx` (`school_id` ASC),
  CONSTRAINT `fk_tbl_bbs_user_tbl_bbs_school`
    FOREIGN KEY (`school_id`)
    REFERENCES `BBS`.`tbl_bbs_school` (`school_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
