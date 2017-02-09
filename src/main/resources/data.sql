insert into app_user(id, password, username) values(1, '$2a$10$bnC26zz//2cavYoSCrlHdecWF8tkGfPodlHcYwlACBBwJvcEf0p2G', 'test@gmail.com');
insert into user_role(app_user_id, role) values(1, 'ADMIN');
insert into user_role(app_user_id, role) values(1, 'PREMIUM_MEMBER');