package com.dessert.model;

import java.util.Date;

public class Dessert {

    private int id;
    private String name;
    private String type;
    private String manufacturer;
    private Date ProductionDate;
    private String ProductionAdd;
    private float price;
    private int stock;
    public Dessert(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getProductionDate() {
        return ProductionDate;
    }
    public void setProductionDate(Date productionDate) {
        ProductionDate = productionDate;
    }

    public String getProductionAdd() {
        return ProductionAdd;
    }

    public void setProductionAdd(String productionAdd) {
        ProductionAdd = productionAdd;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Dessert{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", ProductionDate=" + ProductionDate +
                ", ProductionAdd='" + ProductionAdd + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
