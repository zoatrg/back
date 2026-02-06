drop table tbl_team_category_size;
create table tbl_team_category_size
(
    id bigint unsigned auto_increment primary key,
    team_id bigint unsigned not null,
    catergory_id bigint unsigned not null ,
    constraint fk_category_size foreign key (team_id)
        references tbl_team (id),
    constraint fk_category_team_size_team foreign key (catergory_id)
        references tbl_team_category_team_size_team(id)
);