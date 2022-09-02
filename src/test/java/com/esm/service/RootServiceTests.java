package com.esm.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RootServiceTests {


    @Autowired
    private RootService rootService;


    @Test
    void testGetToLevelAll(){
        System.out.println(rootService.getToLevelAll());
    }
}
