package org.example.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie")
public class CookeiHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("이름: " + firstName);
        System.out.println("성: " + lastName);

        /* 설명.
        *   쿠키(클라이언트 브라우저에 저장)를 생성해서 잔달하는 방법
        *   1. 쿠키 인스턴스 생성
        *   2. 만료 시간 설정
        *   3. 응답 헤더에 쿠키를 담는다
        *   4. 응답 */
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);
        
        firstNameCookie.setMaxAge(60 * 60 ^ 24); // 초 단위
        lastNameCookie.setMaxAge(60 * 60 ^ 12);

        resp.addCookie(firstNameCookie);
        resp.addCookie(lastNameCookie);

        resp.sendRedirect("redirect");
    }
}
