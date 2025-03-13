package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntityManagerCRUDTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {

        /* 설명. EntityManager가 생성될 때마다 고유의 새로운 영속성 컨텍스트(Entity를 관리하는 자바의 창고)가 생성된다. */
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @Test
    public void selectMenuByMenuCodeTest() {
        int menuCode = 2;

        /* 설명. 영속성 컨텍스트 확인 후 없으면 DB select 후 영속성 컨텍스트에 넣는다.
        *   즉 여러번 find 해도 select 한 번 동작 */
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        Menu foundMenu2 = entityManager.find(Menu.class, menuCode);
        Menu foundMenu3 = entityManager.find(Menu.class, menuCode);

        Assertions.assertNotNull(foundMenu);
        Assertions.assertNotNull(foundMenu2);
        Assertions.assertNotNull(foundMenu3);
        System.out.println("foundMenu = " + foundMenu);
        System.out.println("foundMenu == foundMenu2: " + (foundMenu == foundMenu2));
    }

    @Test
    public void insertNewMenuTest() {
        Menu menu = new Menu();
        menu.setMenuName("꿀발린추어탕");
        menu.setMenuPrice(7000);
        menu.setCategoryCode(4);
        menu.setOrderableStatus("Y");

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            entityManager.persist(menu);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Test
    public void updateMenuNameTest() {
        Menu menu = entityManager.find(Menu.class, 2); // 2번을 관리해줘. (없으면 select)
        System.out.println("menu = " + menu);

        String menuNameToChange = "우럭스무디";

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            // snapshot과 dirty check 후 flush 시 쿼리를 생성해 날림 즉 같은 값이면 쿼리 실행 안 됨
            menu.setMenuName(menuNameToChange);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
    
    @Test
    public void deleteMenuTest() {
        /* 설명. 지울 대상을 DB로부터 가져와서 엔티티의 객체로 받음 */
        Menu menuToRemove = entityManager.find(Menu.class, 3);
        System.out.println("menuToRemove = " + menuToRemove);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            entityManager.remove(menuToRemove);
            transaction.commit();
            System.out.println("삭제 커밋 성공");
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("삭제 롤백");
        }
    }
}
