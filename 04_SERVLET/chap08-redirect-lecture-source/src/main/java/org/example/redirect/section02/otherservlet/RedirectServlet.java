package org.example.redirect.section02.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    /* 설명. redirect로 서블릿에 접근 시 무조건 doGet임 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("리다이렉트 이후 request의 attribute 확인: " + req.getAttribute("test"));
        System.out.println("리다이렉트 이후 request의 parameter 확인: " + req.getParameter("test"));

    }
}
