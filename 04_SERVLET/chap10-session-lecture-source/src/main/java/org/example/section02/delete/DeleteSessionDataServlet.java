package org.example.section02.delete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteSessionDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        System.out.println("attribute 무효화 전 firstName: " + session.getAttribute("firstName"));
        System.out.println("attribute 무효화 후 lastName: " + session.getAttribute("lastName"));

        session.invalidate();       // HttpSession 객체의 Attribute 값들을 무효화

        /* 설명. 세션이 무효화되면 attribute를 가져올 수 없게 된다. 접근 시 500 에러 발생(로그아웃 개념으로 많이 쓰게 된다.) */
        System.out.println("attribute 무효화 전 firstName: " + session.getAttribute("firstName"));
        System.out.println("attribute 무효화 후 lastName: " + session.getAttribute("lastName"));
        

    }
}
