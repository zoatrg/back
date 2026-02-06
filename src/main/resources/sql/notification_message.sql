drop table tbl_message_notification;
create table tbl_message_notification(
  id bigint unsigned auto_increment primary key ,
  message_room_id bigint unsigned not null,
  constraint fk_room_notification foreign key(message_room_id)
  references tbl_message_room(id)
);