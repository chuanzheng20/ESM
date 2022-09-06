package com.esm.domain.query;

import com.esm.domain.Wages;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:陈炜灵
 * @Date:2022/8/31 17:47
 * @Version 1.0
 */
@Data
@Transactional
@Service
public class WagesQuery extends Wages {
    private  Double money;

    @Override
    public String toString() {
        return "WagesQuery{" +
                "money=" + money +
                '}';
    }
}
