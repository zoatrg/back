drop table tbl_member;
create table tbl_member
(
    id bigint unsigned auto_increment primary key,
    member_email varchar(255) unique not null,
    member_password varchar(255) not null,
    member_name varchar(255) not null,
    member_phone_number varchar(255) unique not null,
    member_status enum ('active','inactive') default 'inactive',
    created_datetime datetime default current_timestamp(),
    updated_datetime datetime default current_timestamp()
);
