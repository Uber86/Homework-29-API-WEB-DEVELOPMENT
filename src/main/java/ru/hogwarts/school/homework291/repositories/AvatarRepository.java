package ru.hogwarts.school.homework291.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.homework291.model.Avatar;

import java.util.Optional;

@Transactional
public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    Optional<Avatar> findByStudentId(Long studentId);


}
