drop table tbl_post_team;
create table tbl_post_team(
    id bigint unsigned auto_increment primary key,
    team_id bigint unsigned not null ,
    post_id bigint unsigned not null ,
    constraint fk_post_team_team foreign key (team_id)
        references tbl_team (id),
    constraint fk_post_team foreign key (id)
    references tbl_post(id)
);