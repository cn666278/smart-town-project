drop table if exists checkpoints;

create table checkpoints
(
    id          int auto_increment primary key,
    name        varchar(255),
    img         varchar(255),
    description varchar(255),
    contact     varchar(255),
    latitude     varchar(255),
    longitude     varchar(255),
    address     varchar(255)
) engine=InnoDB;
