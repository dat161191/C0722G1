insert into role (id, name)
values (1, 'ROLE_USER');
insert into role (id, name)
values (2, 'ROLE_ADMIN');

insert into abc.user (id, is_enabled, password, username)
values (1, true, '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'user');
insert into abc.user (id, is_enabled, password, username)
values (2, true, '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'admin');

insert into user_role (user_id, role_id)
values (1, 1);
insert into user_role (user_id, role_id)
values (2, 1);
insert into user_role (user_id, role_id)
values (2, 2);