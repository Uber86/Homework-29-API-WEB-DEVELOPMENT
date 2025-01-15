1
ALTER TABLE student
ADD CONSTRAINT age_constraint CHECK (age >= 16);

2
ALTER TABLE student
ADD PRIMARY KEY (name);

3
ALTER TABLE faculty
ADD CONSTRAINT name_color_unique UNIQUE (name, color);

4
CREATE TABLE student
age INTEGER DEFAULT 20;

