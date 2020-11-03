CREATE DATABASE IF NOT EXISTS jdr_toilet;
USE jdr_toilet;

-- ##### 用户表 #####
DROP TABLE IF EXISTS t_toilet_user;
CREATE TABLE t_toilet_user
(
  `id`          BIGINT(20) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_date` DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete`   TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '逻辑删除；0=未删除，1=已删除',
  `name`        VARCHAR(20)                     NOT NULL DEFAULT '' COMMENT '用户姓名',
  `sex`         TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '性别；0=男，1=女',
  `mobile`      VARCHAR(20)                     NOT NULL DEFAULT '' COMMENT '用户手机号',
  `type`        TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '用户类型；0=普通用户，1=VIP用户，2=管理员',
  `status`      TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '用户状态；0=正常用户，1=用户已注销'
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4 COMMENT '用户表';

-- ##### 厕所表 #####
DROP TABLE IF EXISTS t_toilet_toilet;
CREATE TABLE t_toilet_toilet
(
  `id`            BIGINT(20) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_date`   DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date`   DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete`     TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '逻辑删除；0=未删除，1=已删除',
  `type`          TINYINT(2)                      NOT NULL DEFAULT 1 COMMENT '厕所类型；0=男厕所，1=女厕所',
  `floor`         INTEGER                         NOT NULL DEFAULT -1 COMMENT '厕所楼层',
  `admin_user_id` BIGINT(20)                      NOT NULL DEFAULT -1 COMMENT '管理人id',
  `status`        TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '厕所状态；0=正常运行，1=维修中'
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4 COMMENT '厕所表';

-- ##### 坑位表 #####
DROP TABLE IF EXISTS t_toilet_pit;
CREATE TABLE t_toilet_pit
(
  `id`               BIGINT(20) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_date`      DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date`      DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete`        TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '逻辑删除；0=未删除，1=已删除',
  `type`             TINYINT(2)                      NOT NULL DEFAULT 1 COMMENT '坑位类型；0=蹲式，1=马桶，2=便池',
  `parent_toilet_id` BIGINT(20)                      NOT NULL DEFAULT -1 COMMENT '所属厕所id',
  `status`           BIGINT(20)                      NOT NULL DEFAULT -1 COMMENT '坑位状态；0=空闲状态[清洁完毕]，1=使用中，2=待清洁，3=维修中'
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4 COMMENT '坑位表';

-- ##### 洗手台表 #####
DROP TABLE IF EXISTS t_toilet_wash_basin;
CREATE TABLE t_toilet_wash_basin
(
  `id`               BIGINT(20) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_date`      DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date`      DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete`        TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '逻辑删除；0=未删除，1=已删除',
  `parent_toilet_id` BIGINT(20)                      NOT NULL DEFAULT -1 COMMENT '所属厕所id',
  `status`           TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '洗手台状态；0=正常运行，1=维修中'
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4 COMMENT '洗手台表';

-- ##### 产品表 #####
DROP TABLE IF EXISTS t_toilet_product;
CREATE TABLE t_toilet_product
(
  `id`                  BIGINT(20) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_date`         DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date`         DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete`           TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '逻辑删除；0=未删除，1=已删除',
  `name`                VARCHAR(20)                     NOT NULL DEFAULT '' COMMENT '产品名称',
  `price`               DECIMAL                         NOT NULL DEFAULT 0 COMMENT '产品价格（单位元）',
  `stock`               INTEGER                         NOT NULL DEFAULT 0 COMMENT '产品库存',
  `product_category_id` BIGINT(20)                      NOT NULL DEFAULT 0 COMMENT '产品类别id'
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4 COMMENT '产品表';

-- ##### 产品类别表 #####
DROP TABLE IF EXISTS t_toilet_category;
CREATE TABLE t_toilet_category
(
  `id`                 BIGINT(20) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_date`        DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date`        DATETIME                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete`          TINYINT(2)                      NOT NULL DEFAULT 0 COMMENT '逻辑删除；0=未删除，1=已删除',
  `name`               VARCHAR(20)                     NOT NULL DEFAULT '' COMMENT '产品类别名称',
  `parent_category_id` BIGINT(20)                      NOT NULL DEFAULT -1 COMMENT '父类产品id'
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4 COMMENT '产品类别表（产品分类，如食物、衣物等等）';