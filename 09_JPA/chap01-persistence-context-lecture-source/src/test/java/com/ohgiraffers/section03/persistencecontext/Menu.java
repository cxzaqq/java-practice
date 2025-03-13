package com.ohgiraffers.section03.persistencecontext;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="section03_menu")
@Table(name="tbl_menu") // 없으면 테이블을 만들어줌
public class Menu {

    /* 설명. 복합키 설정?
    *   각 필드에 @Id 달면 됨 */
    @Id
    @Column(name="menu_code")
    /* 설명. 
    *   TABLE: 번호 전용 테이블을 사용
    *   SEQUENCE: MySQL은 사용 불가. oracle에서 사용
    *   IDENTITY: auto increment
    *   UUID: 난수로 PK 생성
    *   AUTO: DBMS에 맞춰서 적용 */
    /* 설명. Entity 객체를 만들 때 값을 넣지 않거나(DB의 auto_increment를 따르게)
         auto ddl을 통해 Entity 테이블 생성 시 활용할 목적 */
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int menuCode;
    
    @Column(name="menu_name")
    private String menuName;

    @Column(name="menu_price")
    private int menuPrice;

    @Column(name="category_code")
    private int categoryCode;

    @Column(name="orderable_status")
    private String orderableStatus;

    public Menu() {
    }

    public Menu(int menuCode, String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
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

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
