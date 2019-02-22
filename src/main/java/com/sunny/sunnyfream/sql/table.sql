#数据库设计
-- sunny-ad 数据库
drop DATABASE sunny_fream;
CREATE DATABASE sunny_fream character set utf8;

use sunny_fream;

#权限表
CREATE TABLE permission (
  id   INT(11)      NOT NULL AUTO_INCREMENT,
  name VARCHAR(20)  NOT NULL,
  url  VARCHAR(255) NOT NULL
    PRIMARY KEY(id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8;

INSERT INTO permission (id, name, url) VALUES (1, 'add', '');
INSERT INTO permission (id, name, url) VALUES (2, 'delete', '');
INSERT INTO permission (id, name, url) VALUES (3, 'edit', '');
INSERT INTO permission (id, name, url) VALUES (4, 'query', '');

#用户表
CREATE TABLE user (
  id       INT(11)      NOT NULL AUTO_INCREMENT,
  name     VARCHAR(20)  NOT NULL,
  password VARCHAR(255) NOT NULL
    PRIMARY KEY(id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8;

INSERT INTO user VALUES (1, 'admin', '123');
INSERT INTO user VALUES (2, 'test', '123');
#角色表
CREATE TABLE role (
  id   INT(11)     NOT NULL AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL
    PRIMARY KEY(id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8;

INSERT INTO role VALUES (1, 'admin');
INSERT INTO role VALUES (2, 'guest');

#权限角色关系表
CREATE TABLE permission_role (
  rid INT(11) NOT NULL,
  pid INT(11) NOT NULL,
  KEY idx_rid (rid),
  KEY idx_Pid (pid)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8;
INSERT INTO permission_role VALUES (1, 1);
INSERT INTO permission_role VALUES (1, 2);
INSERT INTO permission_role VALUES (1, 3);
INSERT INTO permission_role VALUES (1, 4);
INSERT INTO permission_role VALUES (2, 1);
INSERT INTO permission_role VALUES (2, 4);
#用户角色关系表
CREATE TABLE user_role (
  uid INT(11) NOT NULL,
  pid INT(11) NOT NULL,
  KEY idx_uid (uid),
  KEY idx_Pid (pid)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8;

INSERT INTO user_role VALUES (1, 1);
INSERT INTO user_role VALUES (2, 2);

#用户表
CREATE TABLE permission_config (
  `id` varchar(255) NOT NULL,
  `url` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `permission` varchar(255) DEFAULT NULL COMMENT '需要具备的权限',
  `sort` int(50) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;