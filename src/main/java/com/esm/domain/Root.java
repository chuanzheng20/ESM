package com.esm.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_root")
public class Root {
    @TableId
    private Integer rootId;
    private String idx;
    private String name;
    private String icon;
    private String path;
    private Integer fatherId;
    private String apiPaths;

    @Override
    public String toString() {
        return "Root{" +
                "\"rootId\":" + rootId +
                ", \"idx\":'" + idx + '\'' +
                ", \"name\":'" + name + '\'' +
                ", \"icon\":'" + icon + '\'' +
                ", \"path\":'" + path + '\'' +
                ", \"fatherId\":" + fatherId +
                ", \"apiPath\":" + apiPaths +
                '}';
    }
}
