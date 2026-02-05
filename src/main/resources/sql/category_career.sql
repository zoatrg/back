create table tbl_category_career (
    id bigint unsigned auto_increment primary key,
    career_type varchar(255) not null,
    member_id bigint unsigned not null,
    constraint fk_category_career_member foreign key(member_id)
        references tbl_member(id)
)