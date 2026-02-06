drop table tbl_post;
create table tbl_post
(
    id bigint unsigned auto_increment primary key,
    post_title varchar(255) not null,
    post_content text not null,
    post_view_count int default 0 not null,
    post_created_at datetime default now() not null,
    post_updated_at datetime default now() not null,
    post_status enum('active', 'inactive') default 'inactive'
);

