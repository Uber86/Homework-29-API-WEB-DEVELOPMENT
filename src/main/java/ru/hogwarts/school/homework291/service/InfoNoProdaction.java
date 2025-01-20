package ru.hogwarts.school.homework291.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!prodaction")
public class InfoNoProdaction implements InfoService{

    @Override
    public int getThisPort() {
        return 0;
    }
}
