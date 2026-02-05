create table tbl_notification
(
    id bigint auto_increment primary key,
    receiver_id int not null,
    sender_id int not null,
    target_follower_id bigint not null,
    message varchar(255) not null,
    created_at datetime default now() not null
);