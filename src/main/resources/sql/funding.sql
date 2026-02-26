use CandM;
-- 펀딩 테이블
drop table tbl_funding;
create table tbl_funding (
id bigint unsigned auto_increment primary key,
funding_target_amount bigint default 0,
funding_current_amount bigint default 0,
funding_title varchar(255) not null,
start_date date not null,
end_date date not null,
funding_url varchar(255) unique not null,
funding_description text,
funding_contact_email varchar(255) not null,
created_datetime datetime default current_timestamp(),
funding_status enum('active', 'inactive') default 'inactive',
team_id bigint unsigned not null ,
constraint fk_funding_team foreign key (team_id)
                         references tbl_team(id)
);

select * from tbl_funding;
