create table tbl_team_file(
    id bigint unsigned primary key,
    team_id bigint unsigned not null,
    constraint  fk_team_file_team foreign key (team_id)
                          references tbl_team(id),
    constraint  fk_team_file_file foreign key (id)
        references tbl_file(id)
);

select * from tbl_team_file;


create view view_team_file as
(
select f.id,
       file_path,
       file_name,
       file_original_name,
       file_size,
       file_content_type,
       created_datetime,
       updated_datetime,
       team_id
from tbl_file f
         join tbl_team_file tf
              on f.id = tf.id
    );

select * from tbl_team_file;
select * from view_team_file;
delete from tbl_funding_file;