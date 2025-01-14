1
SELECT student.name , student.age, faculty.name
FROM student
INNER JOIN faculty ON student.faculty_id = faculty.id;

2
SELECT student.name, student.age, avatar.file_path
FROM avatar
INNER JOIN student ON avatar.student_id = student.id;