package com.ohgiraffers.section01.xmlconfig;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class MenuService {
    private final MenuDAO menuDAO;

    public MenuService() {
        menuDAO = new MenuDAO();
    }

    public List<MenuDTO> findAllMenus() {
        /* 설명. sqlSession은 요청 당 생성해야 하기에 전역으로 빼면 안 된다. */
        SqlSession sqlSession = getSqlSession();

        List<MenuDTO> menuList = menuDAO.selectAllMenus(sqlSession);

        sqlSession.close();
        return menuList;
    }

    public MenuDTO findMenuByMenuCode(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        MenuDTO menu = menuDAO.selectMenuByMenuCode(sqlSession, menuCode);

        sqlSession.close();
        return menu;
    }

    public boolean registMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.insertMenu(sqlSession, menu);

        /* 설명. 성공 실패에 따라 트랜잭션 처리(commit/rollback) */
        if (result == 1) sqlSession.commit();
        else sqlSession.rollback();

        sqlSession.close();

        return result == 1;
    }

    public boolean modifyMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.updateMenu(sqlSession, menu);

        if (result > 0) sqlSession.commit();
        else sqlSession.rollback();

        sqlSession.close();

        return result > 1;
    }

    public boolean removeMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.deleteMenu(sqlSession, menuCode);

        if (result > 0) sqlSession.commit();
        else sqlSession.rollback();

        sqlSession.close();

        return result > 0;
    }
}
