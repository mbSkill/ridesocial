package com.bostic.ridesocial.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {
    @Autowired PostService service;

    @Test
    public void timeStampWorks(){
        System.out.println(service.getTimestamp());
        assertNotNull(service.getTimestamp(),service.getTimestamp().toString());
    }

}