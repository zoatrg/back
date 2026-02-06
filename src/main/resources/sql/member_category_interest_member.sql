drop table tbl_member_category_interest_member;
create table tbl_member_category_interest_member(
    id bigint unsigned auto_increment primary key,
    category_interest_name varchar(255) not null
);