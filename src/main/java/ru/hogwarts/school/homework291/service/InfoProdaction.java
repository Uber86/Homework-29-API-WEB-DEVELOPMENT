package ru.hogwarts.school.homework291.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prodaction")
public class InfoProdaction implements InfoService{

    @Value("${server.port}")
    private int port;


    public int getThisPort() {
        return port;
    }
}
