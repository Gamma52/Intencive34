CREATE TABLE users(
id INT auto_increment PRIMARY KEY,
name VARCHAR(255),
surname VARCHAR(255),
telephone VARCHAR(255),
email VARCHAR(255),
order_id INT);

insert into users(name, surname, telephone, email, order_id) values('Vasya', 'Petrov', '+70983620122', 'petrov@mail.ru', 1);
insert into users(name, surname, telephone, email, order_id) values('Oleg', 'Toro', '+71113620122', 'toro@mail.ru', 2);
insert into users(name, surname, telephone, email, order_id) values('Masha', 'Koko', '+74413620122', 'koko@mail.ru', 3);
insert into users(name, surname, telephone, email, order_id) values('Dasha', 'Pushkin', '+73123620122', 'pushkin@mail.ru', 4);
insert into users(name, surname, telephone, email, order_id) values('Vika', 'Green', '+71221363122', 'green@mail.ru', 5);