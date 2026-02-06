drop table tbl_team_category_position;
create table tbl_team_category_position
(
    id bigint unsigned auto_increment primary key,
    team_id bigint unsigned not null,
    catergory_id bigint unsigned not null ,
    constraint fk_category_position foreign key (team_id)
        references tbl_team (id),
    constraint fk_category_position_team foreign key (catergory_id)
        references tbl_team_category_position_team(id)
);