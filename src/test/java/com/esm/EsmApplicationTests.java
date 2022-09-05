package com.esm;

import com.esm.dao.FiveDao;
import com.esm.dao.UserDao;
import com.esm.domain.query.OtherDetailsQuery;
import com.esm.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.List;

@SpringBootTest
class EsmApplicationTests {


    @Test
    void contextLoads() {
    }


    @Autowired
    private NavService navService;
    @Autowired
    private FiveDao fiveDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    @Autowired
    private FiveService fiveService;

    @Test
    void testGetNavByPower(){
        // System.out.println(navService.getNavByRoleId(1));
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        String year = String.valueOf(c.get(Calendar.YEAR)).substring(2);
        String month = String.format("%02d",c.get(Calendar.MONTH));
        String date = String.format("%02d",c.get(Calendar.DATE));
        String hour = String.format("%02d",c.get(Calendar.HOUR_OF_DAY));
        String minute = String.format("%02d",c.get(Calendar.MINUTE));
        String second = String.format("%02d",c.get(Calendar.SECOND));
        // int second = c.get(Calendar.SECOND);
        String ms = Integer.toString(c.get(Calendar.MILLISECOND)) ;

        System.out.println(year + month + date +hour + minute + second + ms.substring(0 ,1));
        System.out.println(ms);
        System.out.println();

    }
@Test
    void test(){
//       System.out.println(fiveQueryService.selectById("12345004"));
//    System.out.println(fiveDao.selectById(1));
//    System.out.println(userService.selectAll());
//    List<OtherDetailsQuery> otherDetailsQuery = otherDetailsQueryService.select("12345001","1");
    //System.out.println();
}
}
