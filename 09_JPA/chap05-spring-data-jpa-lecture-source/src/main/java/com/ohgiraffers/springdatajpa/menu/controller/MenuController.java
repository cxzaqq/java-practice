package com.ohgiraffers.springdatajpa.menu.controller;

import com.ohgiraffers.springdatajpa.common.Pagination;
import com.ohgiraffers.springdatajpa.common.PagingButtonInfo;
import com.ohgiraffers.springdatajpa.menu.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.service.MenuService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/menu")
@Slf4j // lombok 추가 시 logger 변수를 지정하지 않아도 됨
public class MenuController {

    private final MenuService menuService;

    /* 설명.
    *   Logger를 활용한 로그 생성 이유?
    *   1. println보다 성능적으로 우수
    *   2. 외부 리소스 파일로 따로 저장 및 송출 가능
    *   3. 로그레벨에 따른 확인 가능(개발: debug, 서비스: info) */
//    Logger logger = LoggerFactory.getLogger(MenuController.class);
//    Logger logger = LoggerFactory.getLogger(getClass());
    
    
    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/{menuCode}")
    public String findMenuByCode(@PathVariable int menuCode, Model model) {
//        System.out.println("menuCode = " + menuCode);
//        logger.debug("menuCode = {}", menuCode);
        log.debug("menuCode: {}", menuCode);

        MenuDTO menu = menuService.findMenuByCode(menuCode);

        model.addAttribute("menu", menu);

        return "menu/detail";
    }

    /* 설명. 페이징 처리 전 */
//    @GetMapping("/list")
//    public String findMenuList(Model model) {
//        List<MenuDTO> menuList = menuService.findMenuList();
//
//        model.addAttribute("menuList", menuList);
//
//        return "menu/list";
//    }

    /* 설명. 페이징 처리 후 */
    /* 설명.
    *   @PageableDefault
    *   1. 기본 한 페이지에 10개의 데이터(size, value)
    *   2. 기본 1페이지 부터(0부터) */
    @GetMapping("list")
    public String findMenuList(@PageableDefault Pageable pageable, Model model) {
        log.debug("pageable: {}", pageable);

        Page<MenuDTO> menuList = menuService.findMenuList(pageable);

        log.debug("조회한 내용 목록: {}", menuList.getContent());
        log.debug("총 페이지 수: {}", menuList.getTotalPages());
        log.debug("총 메뉴 수: {}", menuList.getTotalElements());
        log.debug("해당 페이지에 표시될 요소 수: {}", menuList.getSize());
        log.debug("해당 페이지에 실제 요소 수: {}", menuList.getNumberOfElements());

        /* 설명. Page 객체를 통해 PagingButtonInfo 추출 */
        PagingButtonInfo paging = Pagination.getPagingButtonInfo(menuList);

        model.addAttribute("menuList", menuList);
        model.addAttribute("paging", paging);

        return "menu/list";
    }

    @GetMapping("querymethod")
    public void queryMethodPage() {}

    @GetMapping("search")
    /* 설명. @RequestParam은 생략 가능(클라이언트에서 넘겨준 이름과 같아야 함) */
//    public String findMenuPrice(int menuPrice, Model model) {
    public String findMenuPrice(@RequestParam int menuPrice, Model model) {
        List<MenuDTO> menuList = menuService.findMenuPrice(menuPrice);
        model.addAttribute("menuList", menuList);
        model.addAttribute("menuPrice", menuPrice);

        return "menu/searchResult";
    }

    @GetMapping("regist")
    public void registMenuPage() {}

    @GetMapping("category")
    /* 설명. @ResponseBody를 사용하면 반환 데이터가 json 문자열로 알아서 조립되어 반환됨
    *   viewResolver를 이제 거치지 않음 */
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {
        return menuService.findAllCategory();
    }

    @PostMapping("regist")
    /* 설명. 커맨드 객체 */
    public String registMenu(MenuDTO newMenu) {
//        log.debug(newMenu.toString());
        menuService.registMenu(newMenu);

        return "redirect:/menu/list";
    }

    @GetMapping("modify")
    public void modifyMenuPage() {}

    @PostMapping("modify")
    public String modifyMenu(MenuDTO modifyMenu) {
        menuService.modifyMenu(modifyMenu);

        return "redirect:/menu/" + modifyMenu.getMenuCode();
    }

    @GetMapping("delete")
    public void deleteMenuPage() {}

    @PostMapping("delete")
    public String deleteMenu(@RequestParam int menuCode) {

        menuService.deleteMenu(menuCode);

        return "redirect:/menu/list";
    }
}
