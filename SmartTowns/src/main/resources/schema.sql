drop table if exists checkpoint;

create table checkpoint
(
    id          int auto_increment primary key,
    name        varchar(255),
    img         varchar(255),
    description varchar(255),
    contact     varchar(255)
) engine=InnoDB;
