package com.ohgiraffers.mybatisspring.section01.factorybean;

import java.util.List;

public interface MenuMapper {
    List<MenuDTO> findAllMenuByOrderableStatus(String test);
}
