drop table tbl_member_category_career;
create table tbl_member_category_career (
    id bigint unsigned auto_increment primary key,
    member_id bigint unsigned not null,
    category_id bigint unsigned not null ,
    constraint fk_category_career_member foreign key(member_id)
    references tbl_member(id),
    constraint fk_member_category_career foreign key (category_id)
    references tbl_member_category_career_member(id)
);
