package com.ohgiraffers.springdatajpa.menu.service;

import com.ohgiraffers.springdatajpa.menu.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.entity.Category;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.repository.CategoryRepository;
import com.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MenuService {

    private final MenuRepository menuRepository;
    private  final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository,
                       ModelMapper modelMapper,
                       CategoryRepository categoryRepository) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    /* 설명. 1. findById() */
    public MenuDTO findMenuByCode(int menuCode) {

//        Menu menu = menuRepository.findById(menuCode).get();
        Menu menu = menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);
        log.debug("Menu: {}", menu);

        return modelMapper.map(menu, MenuDTO.class);
    }

    /* 설명. 2. findAll() (paging 처리 전) */
    public List<MenuDTO> findMenuList() {
        List<Menu> menus = menuRepository.findAll(Sort.by("menuCode").descending());
        return menus.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).toList();
    }

    /* 설명. 3. findAll() (paging 처리 후) */
    public Page<MenuDTO> findMenuList(@PageableDefault Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                                    pageable.getPageSize(),
                                    Sort.by("menuCode").descending());
        Page<Menu> menuList = menuRepository.findAll(pageable);

        return menuList.map(menu -> modelMapper.map(menu, MenuDTO.class));
    }

    /* 설명. 4. QueryMethod 활용 */
    public List<MenuDTO> findMenuPrice(int menuPrice) {
        List<Menu> menus = menuRepository.findByMenuPriceGreaterThan(menuPrice);

        return menus.stream().map(menu -> modelMapper.map(menu, MenuDTO.class))
                .collect(Collectors.toList());
    }

    /* 설명. 5. jpql 및 native sql 활용 */
    public List<CategoryDTO> findAllCategory() {
        List<Category> categories = categoryRepository.findAllCategories();
        return categories.stream().map(category -> modelMapper.map(category, CategoryDTO.class)).toList();
    }

    /* 설명. 6. 추가하기 */
    @Transactional // insert, update, delete 중 하나라도 수행하면 @Transactional 필수(커밋 됨)
    public void registMenu(MenuDTO newMenu) {
        menuRepository.save(modelMapper.map(newMenu, Menu.class));
    }

    @Transactional
    public void modifyMenu(MenuDTO modifyMenu) {

        /* 설명. 수정할 메뉴를 가져와서(영속 상태로 만들어) 영속 상태인 객체를 수정하면 update */
        Menu foundMenu = menuRepository.findById(modifyMenu.getMenuCode()).get();
        foundMenu.setMenuName(modifyMenu.getMenuName());
    }

    @Transactional
    public void deleteMenu(int menuCode) {
        menuRepository.deleteById(menuCode);
    }
}
