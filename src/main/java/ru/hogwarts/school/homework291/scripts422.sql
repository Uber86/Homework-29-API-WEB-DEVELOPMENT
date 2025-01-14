CREATE TABLE human (
    id BIGINT,
    age SMALLINT,
    name VARCHAR(50)PRIMARY KEY,
    driver_license BOOLEAN,
    car_id SMALLINT REFERENCES car (id)
);

CREATE TABLE car (
    id INTEGER,
    brand VARCHAR(50),
    model VARCHAR(50),
    price INTEGER
);

