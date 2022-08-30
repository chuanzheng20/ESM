package com.esm.domain.query;

import com.esm.domain.User;
import lombok.Data;

@Data
public class UserQuery extends User {
    private Integer sectorId;
    private String sectorName;
    private String gradedName;
    private Double money;

    @Override
    public String toString() {
        return super.toString()+
                "UserQuery{" +
                "sectorId=" + sectorId +
                ", sectorName='" + sectorName + '\'' +
                ", gradedName='" + gradedName + '\'' +
                ", money=" + money +
                '}';
    }
}
