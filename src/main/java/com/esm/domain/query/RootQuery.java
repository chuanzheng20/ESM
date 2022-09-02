package com.esm.domain.query;

import com.esm.domain.Root;
import lombok.Data;

import java.util.List;

@Data
public class RootQuery extends Root {
    private List<RootQuery> children;

    @Override
    public String toString() {
        return super.toString().replace("}",",").replace("'","\"").replace("Root","") +
                "\"children\":" + children +
                '}';
    }
}
