package ru.hogwarts.school.homework291.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.homework291.model.Avatar;

import java.util.Optional;

@Repository
@Transactional
public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    Optional<Avatar> findByStudentId(Long studentId);


}
