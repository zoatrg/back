drop table tbl_team_category_current_level;
create table tbl_team_category_current_level
(
    id bigint unsigned auto_increment primary key,
    team_id bigint unsigned not null,
    catergory_id bigint unsigned not null ,
    constraint fk_category_current_level foreign key (team_id)
        references tbl_team (id),
    constraint fk_category_current_level_team foreign key (catergory_id)
        references tbl_team_category_current_level_team(id)
);