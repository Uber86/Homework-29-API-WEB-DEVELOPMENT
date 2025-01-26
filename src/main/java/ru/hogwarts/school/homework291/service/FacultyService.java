package ru.hogwarts.school.homework291.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;
import ru.hogwarts.school.homework291.model.Faculty;
import ru.hogwarts.school.homework291.model.Student;
import ru.hogwarts.school.homework291.repositories.FacultyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class FacultyService {

    Logger logger = LoggerFactory.getLogger(FacultyService.class);

    @Autowired
    private FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty create(Faculty faculty) {
        logger.info("Was invoked method for create faculty");
        return facultyRepository.save(faculty);
    }

    public Faculty get(long id) {
        logger.info("Was invoked method for get faculty");
        return facultyRepository.findById(id).get();
    }

    public Faculty update(Faculty faculty) {
        logger.info("Was invoked method for update faculty");
        if (!facultyRepository.existsById(faculty.getId())){
            throw new ErrorResponseException(HttpStatusCode.valueOf(404));
        }
        return facultyRepository.save(faculty);
    }

    public void delete(long id) {
        logger.info("Was invoked method for delete faculty");
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> findByNameOrColor(String name, String color) {
        logger.info("Was invoked method for findByNameOrColor faculty");
        return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(name, color);
    }

    public long getByMaxLenght() {
        List<Faculty> faculties = new ArrayList<>(facultyRepository.findAll());
        int maxLenght = faculties.stream()
                .mapToInt((value) -> {
                    return value.getName().length();
                })
                .summaryStatistics()
                .getMax();
        return maxLenght;
    }

}
