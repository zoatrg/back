drop table tbl_member_category_joining;
create table tbl_member_category_joining (
    id bigint unsigned auto_increment primary key,
    member_id bigint unsigned not null,
    category_id bigint unsigned not null ,
    constraint fk_category_joining_member foreign key(member_id)
    references tbl_member(id),
    constraint fk_member_category_joining foreign key (category_id)
    references tbl_member_category_joining_member(id)
);