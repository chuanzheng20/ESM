package com.esm.controller;

import com.esm.domain.query.UserQuery;
import lombok.Data;

import java.util.List;

@Data
public class ResultPage {
    public Object rows;
    public Integer totalCount;
}
