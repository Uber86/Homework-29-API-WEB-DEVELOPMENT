package ru.hogwarts.school.homework291.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.homework291.model.Student;
import ru.hogwarts.school.homework291.service.StudentService;

import java.util.List;

@RequestMapping(path = "/avatar")
@RestController
public class AvatarTController {

    private  final StudentService service;

    public AvatarTController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/page-list")
    public ResponseEntity<List<Student>> getAllAvatar(@RequestParam("page") Integer pageNumber,
                                                      @RequestParam("size") Integer pageSize) {
        List<Student> avatar = service.getAvatarPage(pageNumber, pageSize);
        return ResponseEntity.ok(avatar);
    }
}
