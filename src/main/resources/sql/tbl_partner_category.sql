use CandM;

    -- 파트너 카테고리 테이블
create table tbl_partner_category (
id int auto_increment primary key, -- 리스트 고유번호
position varchar(255) not null, -- 포지션(enum)
career varchar(255) not null, -- 경력(enum)
interest varchar(255) not null, -- 관심분야(enum)
join_condition varchar(255) not null -- 합류조건(enum)
);