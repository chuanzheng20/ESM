package com.esm.domain;

import lombok.Data;

@Data
public class NavDataItem {
    private String index;
    private String name;
    private String path;

    public NavDataItem() {
    }

    public NavDataItem(String index, String name, String path) {
        this.index = index;
        this.name = name;
        this.path = path;
    }


}
