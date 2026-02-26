drop table tbl_team;
create table tbl_team
(
    id bigint unsigned auto_increment primary key,
    team_title varchar(255) unique not null,
    team_url varchar(255) unique not null,
    team_contact_email varchar(255) unique not null,
    team_status enum ('active', 'inactive') default 'inactive',
    team_intro text not null,
    member_id bigint unsigned not null,
    created_datetime datetime default current_timestamp(),
    updated_datetime datetime default current_timestamp(),
    constraint fk_member_id_team foreign key (member_id)
        references tbl_member (id)
);



insert into tbl_team (team_title, team_intro, team_url, team_contact_email, member_id)
values ('candm', 'hihi', '1234', '1234@gmail.com', '1')

select * from tbl_team;


select * from tbl_team;

insert into tbl_team (team_title, team_intro, team_url, team_contact_email, member_id)
values ('asf', 'asfsf', '1ffas234', '123421t3@gmail.com', '2')

SELECT * FROM tbl_team WHERE team_title = '';
DELETE FROM tbl_team WHERE team_title = '';

