insert into app_user(id, password, username, price, weekly_working_hours) values(1, '$2a$10$bnC26zz//2cavYoSCrlHdecWF8tkGfPodlHcYwlACBBwJvcEf0p2G', 'test@gmail.com', 0, 0);
insert into user_role(app_user_id, role) values(1, 'ADMIN');
insert into user_role(app_user_id, role) values(1, 'PREMIUM_MEMBER');