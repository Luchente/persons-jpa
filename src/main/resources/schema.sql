CREATE TABLE IF NOT EXISTS PERSONS (
  name           VARCHAR(50)  NOT NULL,
  surname        VARCHAR(50)  NOT NULL,
  age            INT          NOT NULL,
  phone_number   VARCHAR(32),
  city_of_living VARCHAR(60)  NOT NULL,
  PRIMARY KEY (name, surname, age)
);
