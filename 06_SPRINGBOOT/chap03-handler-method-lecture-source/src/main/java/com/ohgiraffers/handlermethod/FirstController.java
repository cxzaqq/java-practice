package com.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/regist")
    public String regist() {
        /* 설명. 'src/main/resources/templates/first/regist.html' 이렇게 view resolver가 접두, 접미사를 붙이는데
        *   따라서 templates 내부에 first라는 폴더를 만들어서 파일을 생성해야 함 */
        return "/first/regist";
    }

    /* 설명. 핸들러 메소드에서 반환이 없으면 요청 경로 그대로를 반환함 */
//    public void regist() {}

    /* 설명. request는 사용자 입력 값(parameter)를 담는 용도로 쓰고 Model은 백엔드에서 동적 페이지를 만들 때 사용하는 용도로 쓰자. */
    @PostMapping("regist")
    public String registMenu(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        System.out.println("name = " + name);
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        String message = name + "을(를) 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 " + price +
                "원으로 등록하였습니다!";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("modify")
    public void modify() {}

    /* 설명. 
    *   request의 parameter로 넘어오는 값들의 key값과 일치하는 변수명(어노테이션 생략 가능)을 작성하고
    *   @RequestParam 어노테이션을 적용하면 알아서 값을 꺼내고 해당 매개 변수의 자료형에 맞게 변환까지 해 준다.(가능한 경우)
    *
    *  설명.
    *   1. defaultValue: 사용자의 입력 값이 없거나("") 아니면 request의 parameter 키 값과 일치하지 않는
    *                     매개변수 사용 시 매개변수가 가질 기본 default 값을 작성한다.
    *   2. name: request parameter의 키 값과 다른 매개 변수 명을 사용하고 싶을 때 request parameter의 키 값을 작성한다.*/
    @PostMapping("modify1")
    public String modify1(Model model,
//                        @RequestParam(name="name", defaultValue = "디폴트") String modifyName,
//                        @RequestParam(name="modifyPrice", defaultValue = "0") int modifyPrice) {
                        @RequestParam(name="name") String modifyName,
                        int modifyPrice) { // 넘어온 parameter의 key 값과 핸들러 메소드의 매개변수 이름이 같으면 생략 가능
        
        String message = modifyName + " 메뉴의 가격을 " + modifyPrice + "로 변경하였습니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @PostMapping("modify2")
    public String modify2(Model model,
                          @RequestParam Map<String, String> parameterMap) {
        String modifyName = parameterMap.get("name");
        /* 설명. Map으로 받으면 타입 변환을 해줘야 함 */
        int modifyPrice = Integer.parseInt(parameterMap.get("modifyPrice"));

        String message = modifyName + "메뉴의 가격을 " + modifyPrice + "로 변경하였습니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("search")
    public void searchMenu() {}

    @PostMapping("search")
    /* 설명. 이렇게 사용하려면 기본 생성자 및 setter가 있어야 함
    *   즉 스프링이 기본 생성자로 객체를 생성 후 모든 필드에 대해 set 호출 및 자료형 변환까지 해준다.
    *   => 커맨드 객체(사용자의 입력을 받아낼 클래스) (bean X)
    *
    *  설명.
    *   @ModelAttribute 어노테이션을 활용하면 커맨드 객체를 모델에 attribute로 담아주며 이후 view의 재료로 사용할 수 있다.
    *   (키 값 작성 유무에 따라 화면에서 활용하는 방법이 다르다) */
    public String searchMenu(@ModelAttribute("menu") MenuDTO menu) {
        System.out.println("menu = " + menu);
        return "first/searchResult";
    }
}
