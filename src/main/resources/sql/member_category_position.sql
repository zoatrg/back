drop table tbl_member_category_position;
create table tbl_member_category_position(
    id bigint unsigned auto_increment primary key,
    member_id bigint unsigned not null,
    category_id bigint unsigned not null,
    constraint fk_category_position_member foreign key(member_id)
    references tbl_member(id),
    constraint fk_member_category_position foreign key (category_id)
        references tbl_member_category_position_member(id)
);