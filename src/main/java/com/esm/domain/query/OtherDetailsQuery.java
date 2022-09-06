package com.esm.domain.query;

import com.esm.domain.OtherDetails;
import com.esm.domain.OtherType;
import lombok.Data;

import java.time.LocalDate;

/**
 * @Author:陈炜灵
 * @Date:2022/8/30 15:19
 * @Version 1.0
 */
@Data
public class OtherDetailsQuery extends OtherType {
    private Integer num;

    @Override
    public String toString() {
        return super.toString().replace("}",",").replace("'","\"").replace("OtherType","") +
                "\"num\":" + num +
                '}';
    }
}
