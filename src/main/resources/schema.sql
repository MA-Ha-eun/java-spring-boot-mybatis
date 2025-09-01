-- 데이터베이스 생성 -- 근데 나는 이미 만들어둬서 이 부분 주석처리함
-- create database codingon default character set utf8 default collate utf8_general_ci;
use codingon;
-- drop table if exists codingon;

DROP TABLE IF EXISTS board;

-- users 테이블 생성
drop table if exists users;
create table users(
    id bigint auto_increment primary key,
    username varchar(50) not null,
    email varchar(100) not null,
    created_at timestamp default current_timestamp
);

-- users 테이블에 더미 데이터 삽입
insert into users (username, email) values
    ('john_doe', 'jon.doe@example.com'),
    ('jane_smith', 'jane.smith@example.com'),
    ('bob_johnson', 'bob.johnson@example.com');

-- select * from users;

-- 실습. 게시판 시스템
create table board(
    id bigint auto_increment primary key,
    title varchar(20) not null,
    content varchar(100) not null,
    writer varchar(10) not null,
    registered timestamp default current_timestamp
);

insert into board (title, content, writer) values
    ('title1', 'hi', 'john'),
    ('t2', 'test', 'jane'),
    ('제목', '내용', 'nn');

select * from board;
