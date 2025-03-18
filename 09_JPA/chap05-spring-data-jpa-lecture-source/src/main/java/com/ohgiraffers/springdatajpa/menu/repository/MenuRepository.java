package com.ohgiraffers.springdatajpa.menu.repository;


import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/* 설명. JpaRepository를 extends 하면 알아서 하위 구현체(콩)를 만들어준다. */
public interface MenuRepository extends JpaRepository<Menu, Integer> {// entity, pk 타입
    List<Menu> findByMenuPriceGreaterThan(int menuPrice); // 메소드 이름만 잘 작성하면 where절을 추가해서 잘 작성해줌
}
