package ru.hogwarts.school.homework291.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.homework291.repositories.StudentsByCategory;
import ru.hogwarts.school.homework291.service.StudentService;

import java.util.List;

@RestController
public class StudentsByCategoryController {

    private final StudentService service;

    public StudentsByCategoryController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students-by-avg")
    public List<StudentsByCategory> getStudentsAvg(){
        return service.getStudentsAvg();

    }

    @GetMapping("/students-by-quantity")
    public Long getStudentsQuantity(){
        return service.getStudentsQuantity();

    }

    @GetMapping("/students-by-desc")
    public List<StudentsByCategory> getStudentsDesc(){
        return service.getStudentsDesc();

    }





}
