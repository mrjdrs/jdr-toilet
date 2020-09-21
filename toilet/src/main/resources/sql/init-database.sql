CREATE DATABASE IF NOT EXISTS jdr_toilet;
USE jdr_toilet;

-- ##### 用户表 #####
DROP TABLE IF EXISTS t_toilet_user;
CREATE TABLE t_toilet_user
(
  `id`          BIGINT(20) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT 'id',
  `create_date` DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete`   TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '逻辑删除；0=未删除，1=已删除',
  `name`        VARCHAR(20)                     NOT NULL DEFAULT '' COMMENT '用户姓名',
  `sex`         TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '性别；0=男人，1=女人',
  `age`         TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '年龄',
  `type`        TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '用户类型；0=普通用户，1=VIP用户，2=管理员'
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4 COMMENT '用户表';

-- ##### 纸巾表 #####
DROP TABLE IF EXISTS t_toilet_paper_towel;
CREATE TABLE t_toilet_paper_towel
(
  `id`                 BIGINT(20) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_date`        DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date`        DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete`          TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '逻辑删除；0=未删除，1=已删除',
  `type`               TINYINT(2)                      NOT NULL DEFAULT 1 COMMENT '纸巾类型；0=抽纸，1=卷纸',
  `remaining_quantity` INTEGER                         NOT NULL DEFAULT 0 COMMENT '剩余数量',
  `price`              DECIMAL                         NOT NULL DEFAULT 0 COMMENT '价格'
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4 COMMENT '纸巾表';

-- ##### 坑位表 #####
DROP TABLE IF EXISTS t_toilet_pit;
CREATE TABLE t_toilet_pit
(
  `id`            BIGINT(20) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_date`   DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date`   DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete`     TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '逻辑删除；0=未删除，1=已删除',
  `type`          TINYINT(2)                      NOT NULL DEFAULT 1 COMMENT '坑位类型；0=自动蹲式，1=手动蹲式，2=自动马桶，3=手动马桶，4=自动便池，5=手动便池',
  `parent_toilet` BIGINT(20)                      NOT NULL DEFAULT -1 COMMENT '所属厕所',
  `occupied_user` BIGINT(20)                      NOT NULL DEFAULT -1 COMMENT '占有用户'
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4 COMMENT '坑位表';

-- ##### 厕所表 #####
DROP TABLE IF EXISTS t_toilet_toilet;
CREATE TABLE t_toilet_toilet
(
  `id`          BIGINT(20) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_date` DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete`   TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '逻辑删除；0=未删除，1=已删除',
  `type`        TINYINT(2)                      NOT NULL DEFAULT 1 COMMENT '厕所类型；0=男厕所，1=女厕所',
  `floor`       INTEGER                         NOT NULL DEFAULT -1 COMMENT '厕所楼层',
  `admin`       BIGINT(20)                      NOT NULL DEFAULT -1 COMMENT '管理人'
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4 COMMENT '厕所表';

-- ##### 洗手台表 #####
DROP TABLE IF EXISTS t_toilet_wash_basin;
CREATE TABLE t_toilet_wash_basin
(
  `id`          BIGINT(20) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_date` DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete`   TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '逻辑删除；0=未删除，1=已删除',
  `type`        TINYINT(2)                      NOT NULL DEFAULT 1 COMMENT '厕所类型；0=自动出水，1=手动拉闸'
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4 COMMENT '洗手台表';