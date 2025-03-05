package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodMappingTestController {
//    @RequestMapping(value="/menu/regist")
    @RequestMapping(value="/menu/regist", method = RequestMethod.GET)
    public String registMenu(Model model) { // Model은 SSR에서 쓰는 것으로 응답할 페이지이 재료가 된다.
        System.out.println("/menu/regist 경로의 GET 요청 받아보기");

        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출");

        /* 설명. resources/templates에 있는 view의 이름임(응답 갑이 아님)
        *   view resolver가 prefix(src/main/resources/templates), suffix(.html)를 붙여줌 */
        return "mappingResult";
    }
    
    @RequestMapping(value="/menu/modify", method = RequestMethod.POST)
    public String modifyMenu(Model model) {
        System.out.println("/menu/modify 경로의 POST 요청 받아보기");

        model.addAttribute("message", "POST 방식의 메뉴 수정용 핸들러 메소드 호출");

        return "mappingResult";
    }

    @GetMapping("/menu/delete")
    public String getDeleteMenu(Model model) {
        model.addAttribute("message", "GET 방식의 메뉴 삭제용 핸들러 메소드 호출");

        return "mappingResult";
    }

    @PostMapping("/menu/delete")
    public String postDeleteMenu(Model model) {
        model.addAttribute("message", "POST 방식의 메뉴 삭제용 핸들러 메소드 호출");

        return "mappingResult";
    }
}
