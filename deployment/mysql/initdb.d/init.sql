DROP TABLE IF EXISTS tb_user;

CREATE TABLE tb_user  (
    user_id varchar(20) NOT NULL,
    user_nm varchar(60) NOT NULL,
    addr    varchar(100) NULL,
    cell_phone varchar(20),
    agree_inform varchar(1),
    birth_dt varchar(6),
    primary key (user_id)
);

insert into tb_user (user_id, user_nm, addr, cell_phone, agree_inform, birth_dt)
values ('user01', 'kildong', 'seoul', '010-1234-5678', 'N', '201231');
