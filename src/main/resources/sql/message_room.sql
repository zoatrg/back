drop table tbl_message_room;
create table tbl_message_room
(
    id bigint unsigned auto_increment primary key,
    created_member_id bigint unsigned not null,
    invited_member_id bigint unsigned not null
);