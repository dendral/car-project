DROP TABLE IF EXISTS car_price;
DROP TABLE IF EXISTS price;
DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS brand;


CREATE TABLE brand (
  id int auto_increment primary key,
  brand_name varchar(100) NOT NULL
);

CREATE TABLE car (
  id int auto_increment primary key,
  model varchar(100) DEFAULT NULL,
  color varchar(50) DEFAULT NULL,
  brand_id int NOT NULL,
  foreign key (brand_id) references brand(id)
);

CREATE TABLE price (
  id int auto_increment primary key,
  start_date date NOT NULL,
  end_date date NOT NULL,
  price double NOT NULL
);

CREATE TABLE car_price (
  id int auto_increment primary key,
  car_id int NOT NULL,
  price_id int NOT NULL--,
  --foreign key (car_id) references car(id),
  --foreign key (price_id) references price(id)
);


INSERT INTO brand (brand_name) VALUES ('Chevrolet');
INSERT INTO brand (brand_name) VALUES ('Mazda');

INSERT INTO car (model, color, brand_id) VALUES ('Suburban', 'Black', 1);
INSERT INTO car (model, color, brand_id) VALUES ('Mazda3', 'White', 2);
INSERT INTO car (model, color, brand_id) VALUES ('Mazda CX3', 'Silver', 2);
INSERT INTO car (model, color, brand_id) VALUES ('Mazda6', 'Gray', 2);

INSERT INTO price (start_date, end_date, price) VALUES ('2020-01-20', '2020-02-05',50000);
INSERT INTO price (start_date, end_date, price) VALUES ('2020-03-01', '2020-03-30',30000);

INSERT INTO car_price (car_id, price_id) VALUES (1, 1);
INSERT INTO car_price (car_id, price_id) VALUES (1, 2);
INSERT INTO car_price (car_id, price_id) VALUES (2, 2);
INSERT INTO car_price (car_id, price_id) VALUES (3, 2);

