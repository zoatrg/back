create table tbl_member_profile_file
(
	id bigint unsigned not null primary key,
	member_id bigint unsigned not null,
	constraint fk_member_profile_file_member foreign key (member_id)
	references tbl_member(id),
    constraint fk_member_profile_file_file foreign key (id)
    references tbl_file(id)
);

select * from tbl_member_profile_file;

create view view_member_profile_file as
    (
    select f.id,
           file_path,
           file_name,
           file_original_name,
           file_size,
           file_content_type,
           created_datetime,
           updated_datetime,
           member_id

from tbl_file f
    join tbl_member_profile_file mpf
        on f.id = mpf.id
    );

select * from view_member_profile_file;