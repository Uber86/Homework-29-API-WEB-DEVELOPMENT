package ru.hogwarts.school.homework291.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.homework291.model.Student;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findByAge(int age);

    Collection<Student> findByAgeBetween(int min, int max);

    @Query(value = "SELECT AVG(age) AS age FROM student", nativeQuery = true)
    List<StudentsByCategory> getStudentsAvg();

    @Query(value = "SELECT COUNT(*) AS total FROM student", nativeQuery = true)
    Long getStudentsQuantity();

    @Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT 4" , nativeQuery = true)
    List<StudentsByCategory> getStudentsDesc();





}
