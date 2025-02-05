package com.ohgiraffers.section02.superkeyword;

import java.util.Date;

public class Product {
    private String code;
    private String brand;
    private String name;
    private int price;
    private java.util.Date menufactureDate;

    public Product() {
    }

    public Product(String code, String brand, String name, int price, Date menufactureDate) {
        this.code = code;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.menufactureDate = menufactureDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getMenufactureDate() {
        return menufactureDate;
    }

    public void setMenufactureDate(Date menufactureDate) {
        this.menufactureDate = menufactureDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", menufactureDate=" + menufactureDate +
                '}';
    }
}
