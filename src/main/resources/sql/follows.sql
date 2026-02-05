drop table tbl_follows;
create table tbl_follows
(
    id int auto_increment primary key,
    follower_id int not null unique,
    following_id int not null unique,
    created_datetime datetime default now() not null
);