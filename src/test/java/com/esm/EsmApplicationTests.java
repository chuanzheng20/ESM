package com.esm;

import com.esm.service.NavService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EsmApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private NavService navService;

    @Test
    void testGetNavByPower(){
        System.out.println(navService.getNavByRoleId(1));
    }

}
