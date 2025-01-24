package ru.hogwarts.school.homework291.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.homework291.service.InfoService;

@RequestMapping(path = "/port")
@RestController
public class InfoController {

    @Autowired
    private InfoService info;

    @GetMapping
    public int getPort(){
        return info.getThisPort();
    }
}
