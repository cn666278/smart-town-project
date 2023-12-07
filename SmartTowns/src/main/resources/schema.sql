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
    name        varchar(255),
    password    varchar(255),
    profile_img varchar(255),
    account     int,
    email       varchar(255),
    badge       varchar(255)
) engine = InnoDB;



drop table if exists user_checkpoint;

create table user_checkpoint
(
    id            int auto_increment primary key,
    user_id       varchar(255),
    checkpoint_id varchar(255)
) engine = InnoDB;