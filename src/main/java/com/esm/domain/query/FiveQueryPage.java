package com.esm.domain.query;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

/**
 * @Author:陈炜灵
 * @Date:2022/9/4 17:18
 * @Version 1.0
 */
@Data
public class FiveQueryPage {
    public List<FiveQuery> rows;
    public Integer totalCount;
}
