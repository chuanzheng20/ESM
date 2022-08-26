package com.esm.domain;

import lombok.Data;

import java.util.List;

/**
 * 传递给前端的级别数据
 */
@Data
public class Level {

    private Integer value;
    private String  label;
    private List<Level> children;

}
