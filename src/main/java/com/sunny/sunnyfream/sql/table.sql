#数据库设计
-- sunny-ad 数据库
DROP DATABASE sunny_fream;
CREATE DATABASE sunny_fream
  CHARACTER SET utf8;

USE sunny_fream;

#用户表
CREATE TABLE sys_user (
  yhdh                 VARCHAR(11)  NOT NULL,
  name                 VARCHAR(20)  NOT NULL,
  password             VARCHAR(255) NOT NULL,
  bmbh                 INT(12)      NOT NULL,
  isexpired            INT(1)       NOT NULL,
  iscredentialsexpired INT(1)       NOT NULL,
  isenabled            INT(1)       NOT NULL,
  islocked             INT(1)       NOT NULL,
  yhyxq                DATE         NOT NULL,
  mmyxq                DATE         NOT NULL,
  csrq                 DATE,
  gender               INT(1),
  email                VARCHAR(32),
  sfzmhm               VARCHAR(32),
  lxdh                 INT(11),
  lxdz                 VARCHAR(120),
  ip                   VARCHAR(120),
  PRIMARY KEY (yhdh)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8;

#角色表
CREATE TABLE role (
  id   INT(11)     NOT NULL AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  desc VARCHAR(120),
  pid  INT(11),
  PRIMARY KEY (id, name)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8;

#用户角色关系表
CREATE TABLE user_role (
  uid INT(11) NOT NULL,
  pid INT(11) NOT NULL,
  KEY idx_uid (uid),
  KEY idx_Pid (pid)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8;

#权限表
CREATE TABLE permission_group (
  id   INT(11)     NOT NULL AUTO_INCREMENT,
  name VARCHAR(32) NOT NULL,
  type INT(2),
  PRIMARY KEY (id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8;

#权限角色关系表
CREATE TABLE permission_role (
  rid INT(11) NOT NULL,
  pid INT(11) NOT NULL,
  KEY idx_rid (rid),
  KEY idx_Pid (pid)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8;

# #用户表
# CREATE TABLE permission_config (
#   `id`         VARCHAR(255) NOT NULL,
#   `url`        VARCHAR(255) DEFAULT NULL
#   COMMENT '链接地址',
#   `permission` VARCHAR(255) DEFAULT NULL
#   COMMENT '需要具备的权限',
#   `sort`       INT(50)      DEFAULT NULL
#   COMMENT '排序',
#   PRIMARY KEY (`id`)
# )
#   ENGINE = InnoDB
#   DEFAULT CHARSET = utf8;

#部门表
CREATE TABLE user_role (
  uid INT(11) NOT NULL,
  pid INT(11) NOT NULL,
  KEY idx_uid (uid),
  KEY idx_Pid (pid)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8;