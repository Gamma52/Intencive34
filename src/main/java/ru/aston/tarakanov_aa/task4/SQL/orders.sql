CREATE TABLE orders(
id INT auto_increment PRIMARY KEY,
product VARCHAR(255),
weight REAL,
price REAL);

INSERT INTO orders(product, weight, price) values('box', 4.0, 10.5);
INSERT INTO orders(product, weight, price) values('table', 3.2, 15.2);
INSERT INTO orders(product, weight, price) values('bulb', 0.3, 2.3);
INSERT INTO orders(product, weight, price) values('bird', 0.1, 5.0);
INSERT INTO orders(product, weight, price) values('gun', 4.3, 50.0);
INSERT INTO orders(product, weight, price) values('brush', 0.1, 2.3);
INSERT INTO orders(product, weight, price) values('ears', 0.2, 20.8);
INSERT INTO orders(product, weight, price) values('saw', 8.8, 8.0);
INSERT INTO orders(product, weight, price) values('pen', 0.1, 4.1);