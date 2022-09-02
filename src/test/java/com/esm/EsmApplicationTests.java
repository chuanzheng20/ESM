package com.esm;

import com.esm.service.NavService;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Calendar;

@SpringBootTest
class EsmApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private NavService navService;

    @Test
    void testGetNavByPower(){
        // // System.out.println(navService.getNavByRoleId(1));
        // Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        // String year = String.valueOf(c.get(Calendar.YEAR)).substring(2);
        // String month = String.format("%02d",c.get(Calendar.MONTH));
        // String date = String.format("%02d",c.get(Calendar.DATE));
        // String hour = String.format("%02d",c.get(Calendar.HOUR_OF_DAY));
        // String minute = String.format("%02d",c.get(Calendar.MINUTE));
        // String second = String.format("%02d",c.get(Calendar.SECOND));
        // // int second = c.get(Calendar.SECOND);
        // String ms = Integer.toString(c.get(Calendar.MILLISECOND)) ;
        //
        // System.out.println(year + month + date +hour + minute + second + ms.substring(0 ,1));
        // System.out.println(ms);
        // System.out.println();

        String path = "/pages/usermanage.html";
        String[] split = path.split("/");
        String p=path;
        System.out.println(Arrays.toString(split));
        if (StringUtils.isNumeric(split[split.length-1].split(",")[0])){
            p =  path.replace("/"+split[split.length-1],"");
        }

        System.out.println(p);


    }

}
