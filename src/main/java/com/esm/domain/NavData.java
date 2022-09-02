package com.esm.domain;

import lombok.Data;

import java.util.List;

@Data
public class NavData {
    private String index;
    private String name;
    private String icon;
    private List<NavDataItem> items;

    public NavData() {

    }

    public NavData(String index, String name, String icon, List<NavDataItem> items) {
        this.index = index;
        this.name = name;
        this.icon = icon;
        this.items = items;
    }
}
