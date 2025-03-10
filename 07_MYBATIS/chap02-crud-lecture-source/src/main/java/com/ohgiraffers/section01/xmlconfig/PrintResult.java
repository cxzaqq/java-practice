package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

public class PrintResult {
    public void printMenus(List<MenuDTO> menuList) {
//        menuList.forEach(menu -> System.out.println(menu));
        System.out.println();
        menuList.forEach(System.out::println);
        System.out.println();
    }

    public void printErrorMessage(String message) {
        System.out.println();
        System.out.println("에러 메시지: " + message);
        System.out.println();
    }

    public void printMenu(MenuDTO menu) {
        System.out.println();
        System.out.println("menu = " + menu);
        System.out.println();
    }

    public void printSuccessMessage(String statusCode) {
        String successMessage = "";
        switch (statusCode) {
            case "regist": successMessage = "신규 메뉴 등록에 성공하였습니다."; break;
            case "modify": successMessage = "기존 메뉴 수정에 성공하였습니다."; break;
            case "remove": successMessage = "기존 메뉴 삭제에 성공하였습니다.";
        }
        
        System.out.println();
        System.out.println(successMessage);
        System.out.println();
    }
}
