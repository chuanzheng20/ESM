package com.esm.domain.query;

import com.esm.domain.Five;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author:陈炜灵
 * @Date:2022/8/30 15:18
 * @Version 1.0
 */
@Data
public class FiveQuery extends Five {
    private String userId;
    private LocalDate date;
    private String name;
    private  Double money;
    private Double otherWages;
    private Double preTax;
    private Double afterTax;
    @Override
    public String toString() {
        return super.toString().replace("}",",").replace("'","\"").replace("Five","")+
                "userId:\"" + userId + "\"" +
                ", date:'" + date + "\"" +
                ", name:'" + name + "\"" +
                ", money:" + money +
                ", otherWages:" + otherWages +
                ", preTax:" + preTax +
                ", afterTax:" + afterTax +
                '}';
    }
}
