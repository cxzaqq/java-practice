package org.example.forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward")
public class ReceiveInformationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        System.out.println("userId = " + userId);
        System.out.println("password = " + password);

        /* 설명.
        *   이 부분에서 id와 pw에 해당하는 user 정보를 DB까지 가서 select 하고 확인하는
        *   비즈니스 로직이 수행되어야 한다. (회원의 정보를 조회해 옴)
        *   조회가 성공적이라 가정 후 동적 페이지 생성 후 응답 */

        req.setAttribute("userName", "royoon");

        RequestDispatcher rd = req.getRequestDispatcher("print");
        rd.forward(req, resp);
    }
}
