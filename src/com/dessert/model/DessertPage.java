package com.dessert.model;

import java.util.List;

public class DessertPage {
    private final List<Dessert> dessertList;
    private final int totalRecords;

    public DessertPage(List<Dessert> dessertList, int totalRecords) {
        this.dessertList = dessertList;
        this.totalRecords = totalRecords;
    }

    public List<Dessert> getDessertList() {
        return dessertList;
    }

    public int getTotalRecords() {
        return totalRecords;
    }
}
