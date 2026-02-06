drop table tbl_team_category_business_field;
create table tbl_team_category_business_field
(
    id bigint unsigned auto_increment primary key,
    team_id bigint unsigned not null,
    catergory_id bigint unsigned not null ,
    constraint fk_category_business_field foreign key (team_id)
    references tbl_team (id),
    constraint fk_category_business_field_team foreign key (catergory_id)
    references tbl_team_category_business_field_team(id)
);