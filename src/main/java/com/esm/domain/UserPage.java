package com.esm.domain;

import com.esm.domain.query.UserQuery;
import lombok.Data;

import java.util.List;

@Data
public class UserPage {
    public Object rows;
    public Integer totalCount;
}
