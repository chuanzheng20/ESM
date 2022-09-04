package com.esm.domain.query;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.esm.domain.User;
import lombok.Data;

@Data
public class UserRoleQuery extends User {

    private String roleName;
    private String power;

    @Override
    public String toString() {
        return super.toString() +
                "UserRoleQuery{" +
                "roleName='" + roleName + '\'' +
                ", power='" + power + '\'' +
                '}';
    }
}
