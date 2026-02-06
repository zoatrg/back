drop table tbl_follow;
create table tbl_follow
(
    id bigint unsigned auto_increment primary key,
    follower_id int not null unique,
    following_id int not null unique,
    created_datetime datetime default now() not null
);