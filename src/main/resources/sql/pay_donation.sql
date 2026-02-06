drop table tbl_donation;
create table tbl_donation(
    id bigint unsigned auto_increment primary key ,
    donation_amount bigint unsigned default 0,
    funding_id bigint unsigned not null ,
    member_id bigint unsigned not null ,
    constraint fk_funding_donation foreign key (funding_id)
                         references tbl_funding(id),
    constraint fk_member_donation foreign key (member_id)
        references tbl_member(id)
);