package com.ohgiraffers.transactional.section01.annotation;

public class OrderMenu {
    private int orderCode;
    private int menuCode;
    private int orderAmount;

    public OrderMenu() {
    }

    public OrderMenu(int orderCode, int menuCode, int orderAmount) {
        this.orderCode = orderCode;
        this.menuCode = menuCode;
        this.orderAmount = orderAmount;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    @Override
    public String toString() {
        return "OrderMenu{" +
                "orderCode=" + orderCode +
                ", menuCode=" + menuCode +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
