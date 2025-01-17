-- liquibase formatted sql

-- changeset ssostrovsky:1
CREATE INDEX
student_name_ind ON student (name);

-- changeset ssostrovsky:2
CREATE INDEX
faculty_name_color_ind ON faculty (name, color);