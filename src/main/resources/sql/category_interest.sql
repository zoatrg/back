create table tbl_category_interest (
    id bigint unsigned auto_increment primary key,
    category_interest varchar(255) not null,
    member_id bigint unsigned not null,
    constraint fk_category_interest_member foreign key(member_id)
        references tbl_member(id)
)