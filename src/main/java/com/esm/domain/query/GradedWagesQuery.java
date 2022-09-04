package com.esm.domain.query;

import com.esm.domain.GradedWages;
import lombok.Data;

@Data
public class GradedWagesQuery extends GradedWages {

    private String sectorName;

    @Override
    public String toString() {
        return super.toString() +
                "GradedWagesQuery{" +
                "sectorName='" + sectorName + '\'' +
                '}';
    }
}
