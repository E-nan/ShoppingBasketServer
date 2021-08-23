insert into user(user_id, user_pw, user_name, user_address) values ("enan", "1234", "정인환", "안산시")
insert into user(user_id, user_pw, user_name, user_address) values ("hong", "1234", "홍길동", "서울시")
insert into user(user_id, user_pw, user_name, user_address) values ("test", "1234", "테스터", "제주도")

insert into item(item_name, item_price, item_description) values ("모니터", "50000", "모니터 입니다.")
insert into item(item_name, item_price, item_description) values ("키보드", "20000", "키보드 입니다.")
insert into item(item_name, item_price, item_description) values ("마우스", "10000", "마우스 입니다.")

insert into basket(user_no, item_no, item_count) values (1, 1, 1)
insert into basket(user_no, item_no, item_count) values (1, 2, 1)
insert into basket(user_no, item_no, item_count) values (1, 3, 2)
insert into basket(user_no, item_no, item_count) values (2, 1, 2)
