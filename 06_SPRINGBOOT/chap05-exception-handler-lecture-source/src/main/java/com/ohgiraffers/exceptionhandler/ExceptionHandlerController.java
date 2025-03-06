package com.ohgiraffers.exceptionhandler;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class ExceptionHandlerController {
    @GetMapping("simple-null")
    public String simpleNullPointerExceptionTest() {

        if(true) {
            throw new NullPointerException();
        }

        return "/";
    }

    @GetMapping("simple-user")
    public String userExceptionTest() throws MemberRegistException {
        if(true) {
            throw new MemberRegistException("요건을 충족하지 못했습니다.");
        }

        return "/";
    }

    @GetMapping("annotation-null")
    public String nullPointerExceptionHandlerTest() {
        String str = null;
        str.charAt(0);

        return "/";
    }

    /* 설명. 다른 파일의 설정보다 지역적으로 설정한 핸들링이 우선순위가 높음 */
    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler() {
        System.out.println("이 Controller에서 NullPointer 예외 발생 시 여기 오는지 확인");

        return "error/default";
    }

    @GetMapping("annotation-user")
    public String userExceptionHandlerTest() throws MemberRegistException {
        if(true) {
            throw new MemberRegistException("요건을 충족하지 못했습니다.");
        }

        return "/";
    }
    
    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(Model model) {
        System.out.println("이 Controller에서 MemberRegist 예외 발생 시 여기 오는지 확인");

        model.addAttribute("exceptionMessage", "유럽 가봤니?");

        return "error/default";
    }
}
