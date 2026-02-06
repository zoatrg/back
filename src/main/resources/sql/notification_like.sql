drop table tbl_like_notification;
create table tbl_like_notification(
    id bigint unsigned auto_increment primary key,
    follow_id bigint unsigned not null,
    constraint fk_follow_like_notification foreign key (follow_id)
    references tbl_follow(id)
);