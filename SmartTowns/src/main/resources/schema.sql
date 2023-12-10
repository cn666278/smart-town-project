drop table if exists checkpoints;
create table checkpoints
(
    id          int auto_increment primary key,
    name        varchar(255),
    img         varchar(255),
    description varchar(255),
    contact     varchar(255),
    latitude    varchar(255),
    longitude   varchar(255),
    address     varchar(255)
) engine = InnoDB;

drop table if exists users;
create table users
(
    id          int auto_increment primary key,
    username    varchar(50)          not null,
    password    varchar(500)         not null,
    enabled     boolean default true not null,
    profile_img varchar(255),
    account     int,
    email       varchar(255),
    badge       varchar(255)
) engine = InnoDB;

drop table if exists roles;
create table roles
(
    id   int(11)     NOT NULL AUTO_INCREMENT primary key,
    name varchar(45) NOT NULL
) engine = InnoDB;

drop table if exists users_roles;
create table users_roles
(
    id      bigint auto_increment primary key,
    user_id int(11) NOT NULL,
    role_id int(11) NOT NULL
) engine = InnoDB;

DROP VIEW IF EXISTS user_authorities;
CREATE VIEW user_authorities as
select u.username as username, CONCAT('ROLE_', r.name) as authority
from users u
         inner join users_roles ur on u.id = ur.user_id
         inner join roles r on ur.role_id = r.id;

drop table if exists user_checkpoint;
create table user_checkpoint
(
    id            int auto_increment primary key,
    user_id       int,
    checkpoint_id int
) engine = InnoDB;
