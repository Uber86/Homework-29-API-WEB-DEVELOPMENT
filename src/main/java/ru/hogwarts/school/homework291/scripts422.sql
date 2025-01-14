CREATE TABLE student (
    id SMALLINT,
    age SMALLINT CHECK (age >= 16),
    name VARCHAR(50) PRIMARY KEY,
    faculty_id SMALLINT REFERENCES faculty (id)
);

CREATE TABLE faculty (
    id SMALLINT,
    color,name  VARCHAR(50) UNIQUE,
);

CREATE TABLE avatar (
    id SMALLINT,
    data OID,
    file_path TEXT,
    file_size BIGINT,
    media_type TEXT,
    student_id SMALLINT REFERENCES student(id)
);

