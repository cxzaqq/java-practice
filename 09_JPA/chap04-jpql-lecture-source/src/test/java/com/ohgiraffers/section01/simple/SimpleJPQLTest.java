package com.ohgiraffers.section01.simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleJPQLTest {
    private static EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    @Test
    public void TypedQuery를_이용한_단일행_단일열_조회_테스트() {
        /* 설명. DBMS에 독립적으로 작성 가능. ( */
        String jpql = "SELECT menuName FROM menu_section01 WHERE menuCode = 7";

        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);

        String resultMenuName = query.getSingleResult();
        Assertions.assertEquals("민트미역국", resultMenuName);
    }

    @Test
    public void Query를_이용한_단일행_단일열_조회_테스트() {
        /* 설명. DBMS에 독립적으로 작성 가능. ( */
        String jpql = "SELECT menuName FROM menu_section01 WHERE menuCode = 7";

        Query query = entityManager.createQuery(jpql);

        Object resultMenuName = query.getSingleResult();
        Assertions.assertEquals("민트미역국", resultMenuName);

        /* 설명. 단일행 일부 다중열(Object[]일 시) */
        /* 설명. 쓰기 지연 저장소로 가는 게 아니라 바로 flush가 일어남. 즉 영속성 컨텍스트를 온전히 활용하지 못함
        *   1차 캐시로 관리는 되는데 덮어씌워짐(컬럼 2개 조회 혹은 모든 컬럼 조회 등) */
        /* 설명. jqpl을 통해 일부분의 조회 결과 컬럼을 받아내는 것을 projection이라고 한다. */
//        String jpql = "SELECT m.menuName, m.menuPrice FROM menu_section01 m WHERE m.menuCode = 7";
//        Query query = entityManager.createQuery(jpql);
//        List<Object[]> resultColumns = query.getResultList();
//
//        Object[] resultRow = resultColumns.get(0);
//        Arrays.stream(resultRow).forEach(System.out::println);
//
//        Assertions.assertInstanceOf(String.class, resultRow[0]);
//        Assertions.assertInstanceOf(Integer.class, resultRow[1]);
    }

    @Test
    public void TypedQuery를_이용한_다중행_다중열_조회_테스트() {
        String jpql = "SELECT m FROM menu_section01 m";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);

        List<Menu> foundMenuList = query.getResultList();
        foundMenuList.forEach(System.out::println);

        Assertions.assertFalse(foundMenuList.isEmpty());
    }

    @Test
    public void distinct를_활용한_중복제거_여러_행_조회_테스트() {
        
        /* 설명. 메뉴에 할당된 카테고리의 종류르 ㄹ조회하는 jpql 구문 */
        String jpql = "SELECT DISTINCT m.categoryCode FROM menu_section01 m";
        TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
        List<Integer> categoryCodeList = query.getResultList();
        categoryCodeList.forEach(System.out::println);

        Assertions.assertFalse(categoryCodeList.isEmpty());
    }

    @Test
    public void in_연산자를_활용한_조회_테스트() {
        String jpql = "SELECT m FROM menu_section01 m WHERE m.categoryCode IN (6, 10)";
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class).getResultList();
        menuList.forEach(System.out::println);
        Assertions.assertFalse(menuList.isEmpty());
    }

    @Test
    public void like_연산자를_활용한_조회_테스트() {
        String jpql = "SELECT m FROM menu_section01 m WHERE m.menuName LIKE '%마늘%'";
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class).getResultList();
        menuList.forEach(System.out::println);
        Assertions.assertFalse(menuList.isEmpty());
    }
}
