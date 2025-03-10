package com.ohgiraffers.section01.xmlconfig;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class MenuDAO {
    public List<MenuDTO> selectAllMenus(SqlSession sqlSession) {
        /* 설명. selectList는 조회가 안 되어도 객체가 넘어오기에 null이 아님 */
        return sqlSession.selectList("MenuMapper.selectAllMenus");
    }

    public MenuDTO selectMenuByMenuCode(SqlSession sqlSession, int menuCode) {
        /* 설명. selectOne은 조회가 안 되면 null이 넘어감 */
        return sqlSession.selectOne("MenuMapper.selectMenu", menuCode);
    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }

    public int updateMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.update("MenuMapper.updateMenu", menu);
    }

    public int deleteMenu(SqlSession sqlSession, int menuCode) {
        return sqlSession.delete("MenuMapper.deleteMenu", menuCode);
    }
}
