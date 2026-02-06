use CandM;
-- 펀딩 테이블
drop table tbl_funding;
create table tbl_funding (
id bigint unsigned auto_increment primary key,       -- 펀딩 고유번호
funding_target_amount bigint default 0,            -- 펀딩 목표금액
funding_current_amount bigint default 0,          -- 펀딩 현재금액
funding_title varchar(255) not null,                      -- 펀딩 이름
start_date date not null,                        -- 펀딩 시작일
end_date date not null,                          -- 펀딩 마감일
funding_description text,                                -- 펀딩 내용
funding_contact_email varchar(255) not null,                -- 사용자 이메일
created_datetime datetime default current_timestamp(),   -- 펀딩 등록일
funding_status enum('active', 'inactive') default 'inactive', -- 펀딩 상태
team_id bigint unsigned not null ,
constraint fk_funding_team foreign key (team_id)
                         references tbl_team(id)
);

funding_category varchar(100) not null,                  -- 펀딩 카테고리
funding_image_url varchar(255),                          -- 펀딩 이미지
