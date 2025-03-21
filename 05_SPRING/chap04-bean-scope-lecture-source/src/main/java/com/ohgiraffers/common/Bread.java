package com.ohgiraffers.common;

import java.util.Date;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Bread extends Product {
    private java.util.Date bakedDate;

    public Bread(String name, int price, Date bakedDate) {
        super(name, price);
        this.bakedDate = bakedDate;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "bakedDate=" + bakedDate +
                "} " + super.toString();
    }
}
