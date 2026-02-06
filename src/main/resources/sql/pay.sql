use CandM;
-- 결제 테이블
create table tbl_pay
(
    id bigint auto_increment primary key,
    pay_final_amount bigint not null,
    pay_status enum ('active', 'inactive') not null,
    pay_method enum ('creditcard', 'banktransfer', 'paypal') not null,
    funding_id bigint unsigned not null ,
    member_id bigint unsigned not null ,
    constraint fk_pay_member foreign key (member_id)
references tbl_member(id),
    constraint fk_pay_funding foreign key (funding_id)
references tbl_funding(id)
);
