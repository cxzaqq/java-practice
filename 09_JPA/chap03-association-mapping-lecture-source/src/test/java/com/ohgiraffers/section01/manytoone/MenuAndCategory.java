package com.ohgiraffers.section01.manytoone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name="menu_and_category")
@Table(name="tbl_menu")
public class MenuAndCategory {

    @Id
    @Column(name="menu_code")
    private int menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name="menu_price")
    private int menuPrice;
    
    @ManyToOne(fetch = FetchType.LAZY) // 메뉴 -> 카테고리의 전체 카디널리티
    @JoinColumn(name="category_code") // FK 제약 조건이 있는 컬럼명(자식테이블에 있는 컬럼명만 쓴다.)
    private Category category;      // 메뉴 1개가 카테고리 엔티티 객체를 몇 개 가지나(List<Type>/Type)

    @Column(name="orderable_status")
    private String orderableStatus;

    public MenuAndCategory() {
    }

    public MenuAndCategory(int menuCode, String menuName, int menuPrice, Category category, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = category;
        this.orderableStatus = orderableStatus;
    }

    public int getMeuCode() {
        return menuCode;
    }

    public void setMeuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuAndCategory{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
//                ", category=" + category +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
