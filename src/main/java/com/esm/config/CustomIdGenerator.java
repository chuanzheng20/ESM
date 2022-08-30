package com.esm.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class CustomIdGenerator implements IdentifierGenerator {

    private final AtomicLong al = new AtomicLong(1);

    @Override
    public Number nextId(Object entity) {
        return null;
    }

    @Override
    public String nextUUID(Object entity) {
        //可以将当前传入的class全类名来作为bizKey,或者提取参数来生成bizKey进行分布式Id调用生成.
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        String year = String.valueOf(c.get(Calendar.YEAR)).substring(2);
        String month = String.format("%02d",c.get(Calendar.MONTH));
        String date = String.format("%02d",c.get(Calendar.DATE));
        String hour = String.format("%02d",c.get(Calendar.HOUR_OF_DAY));
        String minute = String.format("%02d",c.get(Calendar.MINUTE));
        String second = String.format("%02d",c.get(Calendar.SECOND));
        // int second = c.get(Calendar.SECOND);
        String ms = Integer.toString(c.get(Calendar.MILLISECOND)) ;

        String id = year + month + date +hour + minute + second + ms.substring(0 ,1);

        return id;
    }
}