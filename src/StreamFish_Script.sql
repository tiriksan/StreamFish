-- Drop table sentences --
DROP VIEW todaysTasks; --
DROP TABLE menu_dish;
DROP TABLE dish_ingredients;
DROP TABLE dish_categories;
DROP TABLE special_categories;
DROP TABLE ingredients;
DROP TABLE dish;
DROP TABLE orders;
DROP TABLE subscription;
DROP TABLE menu;
DROP TABLE customer_address;
DROP TABLE customer;
DROP TABLE employees;
/*DROP VIEW todaystasks;*/
/*DROP VIEW orderinfo;*/

-- Create table sentences --
CREATE TABLE customer(
customer_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
customer_name VARCHAR(70) NOT NULL,
phone CHAR(8) NOT NULL,
business CHAR(1) NOT NULL,
status CHAR(1) NOT NULL DEFAULT '1'
);

CREATE TABLE customer_address(
address VARCHAR(50),
zip_code INTEGER,
city VARCHAR(50),
customer_id INTEGER,
CONSTRAINT address_pk PRIMARY KEY (address, customer_id)
);

CREATE TABLE employees(
empl_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
user_type SMALLINT DEFAULT 0,
username VARCHAR(20) NOT NULL,
password VARCHAR(20) NOT NULL,
status CHAR(1) NOT NULL DEFAULT '1'
);

CREATE TABLE ingredients(
ingredient_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
ingredient_name VARCHAR(50) NOT NULL,
amount INTEGER DEFAULT 0,
expiry_date DATE
);

CREATE TABLE dish(
dish_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
dish_name VARCHAR(100),
status CHAR(1) NOT NULL DEFAULT '1'
);

CREATE TABLE menu(
menu_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
menu_name VARCHAR(255) NOT NULL,
price INTEGER DEFAULT 0,
description VARCHAR(2000) DEFAULT 'No description',
status CHAR(1) NOT NULL DEFAULT '1'
);

CREATE TABLE orders(
order_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
delivery_date DATE NOT NULL,
deliver_time TIME,
address VARCHAR(255),
nr_persons INTEGER DEFAULT 1,
empl_id INTEGER,
menu_id INTEGER,
customer_id INTEGER,
subscription_id INTEGER,
status CHAR(1) NOT NULL DEFAULT '1'
);

CREATE TABLE subscription(
subscription_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
duration INTEGER,
from_date DATE,
to_date DATE,
days CHAR(7),
status CHAR(1) NOT NULL DEFAULT '1'
);

CREATE TABLE special_categories(
category_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
description VARCHAR(255)
);

CREATE TABLE dish_categories(
dish_id INTEGER,
category_id INTEGER
);

CREATE TABLE dish_ingredients(
dish_id INTEGER,
ingredient_id INTEGER
);

CREATE TABLE menu_dish(
menu_id INTEGER,
dish_id INTEGER
);

-- Alter table sentences --
ALTER TABLE orders
ADD CONSTRAINT orders_fk_1 FOREIGN KEY(empl_id)
REFERENCES employees ON DELETE SET NULL;

ALTER TABLE orders
ADD CONSTRAINT orders_fk_2 FOREIGN KEY(menu_id)
REFERENCES menu ON DELETE SET NULL;

ALTER TABLE orders
ADD CONSTRAINT orders_fk_3 FOREIGN KEY(customer_id)
REFERENCES customer ON DELETE CASCADE;

ALTER TABLE orders
ADD CONSTRAINT orders_fk4 FOREIGN KEY(subscription_id)
REFERENCES subscription ON DELETE CASCADE;

ALTER TABLE customer
ADD CONSTRAINT unique_name_phone UNIQUE(customer_name, phone);

ALTER TABLE customer_address
ADD CONSTRAINT customer_ad_fk FOREIGN KEY(customer_id) 
REFERENCES customer;

ALTER TABLE dish_categories
ADD CONSTRAINT dish_categories_fk_1 FOREIGN KEY(dish_id)
REFERENCES dish ON DELETE CASCADE;

ALTER TABLE dish_categories
ADD CONSTRAINT dish_categories_fk_2 FOREIGN KEY(category_id)
REFERENCES special_categories ON DELETE SET NULL;

ALTER TABLE dish_ingredients
ADD CONSTRAINT dish_ingredients_fk_1 FOREIGN KEY(dish_id)
REFERENCES dish;

ALTER TABLE dish_ingredients
ADD CONSTRAINT dish_ingredients_fk_2 FOREIGN KEY(ingredient_id)
REFERENCES ingredients;

ALTER TABLE menu_dish
ADD CONSTRAINT menu_dish_fk_1 FOREIGN KEY(menu_id)
REFERENCES menu ON DELETE CASCADE;

ALTER TABLE menu_dish
ADD CONSTRAINT menu_dish_fk_2 FOREIGN KEY(dish_id)
REFERENCES dish ON DELETE CASCADE;

--Create view: todays tasks--

CREATE VIEW todaysTasks AS SELECT orders.order_id, customer_name, address, phone, menu_name, nr_persons, price*nr_persons "Total price", username 
FROM customer LEFT JOIN orders ON customer.CUSTOMER_ID = orders.CUSTOMER_ID 
LEFT JOIN menu ON orders.MENU_ID = menu.MENU_ID
LEFT JOIN employees ON orders.EMPL_ID = employees.EMPL_ID
WHERE delivery_date = CURRENT DATE AND customer.status = '1' AND orders.status = '1';


-- Insert sentences --
INSERT INTO employees VALUES(DEFAULT, DEFAULT, 'Admin', 'NoSoup4U', DEFAULT);
INSERT INTO SFDB.EMPLOYEES (USER_TYPE, USERNAME, PASSWORD, STATUS) VALUES (0, 'norc', 'passord', '1');
INSERT INTO menu VALUES(DEFAULT, 'NorCs Delicious Tapas', 400, 'Test-menu', DEFAULT);
INSERT INTO SFDB.MENU (MENU_NAME, PRICE, DESCRIPTION, STATUS) VALUES ('TirikSans Pizza Speciale', 404, 'Price not found', '1');
INSERT INTO SFDB.MENU (MENU_NAME, PRICE, DESCRIPTION, STATUS) VALUES ('Prebens Nugatti Extraordinale', 75, 'En spesiell forrett med en gratis "Nuggati no igjen!?" fra Preben selv', '1');
INSERT INTO SFDB.MENU (MENU_NAME, PRICE, DESCRIPTION, STATUS) VALUES ('Sindres Frittflyvende Flyndre', 220, 'Fire flytedyktige, frittflyvende, flate flyndrer fra Fosen', '1');