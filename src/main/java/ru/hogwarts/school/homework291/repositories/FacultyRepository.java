package ru.hogwarts.school.homework291.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.homework291.model.Faculty;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Collection<Faculty> findByColor(String color);

    Collection<Faculty> findByNameIgnoreCaseOrColorIgnoreCase(String name, String color);

}
