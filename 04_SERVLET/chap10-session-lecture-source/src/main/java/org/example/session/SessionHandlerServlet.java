package org.example.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        /* 설명.
        *   요청이 서블릿으로 들어올 때 HttpServletRequest에는 JSESSIONID라는 값이 Header에 같이
        *   포함되어 넘어온다. 그때 해당 JSESSIONID에 맞는 HttpSession 객체를 생성해서 해당 사용자를 위한
        *   전용 저장 공간을 제공하게 된다. (없으면 생성 있으면 참조)
        *   (요청을 보낸 사람 전용 Session 저장 공간 생성) */
        HttpSession session = req.getSession();
        System.out.println("session 객체의 default 만료 시간: " + session.getMaxInactiveInterval());

        session.setMaxInactiveInterval(60 * 10);    // 10분으로 수정

        System.out.println("session 객체의 수정 후 만료 시간: " + session.getMaxInactiveInterval());

        /* 설명. session에도 attribute를 설정할 수 있다. */
        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        System.out.println("===== in session servlet =====");
        System.out.println("session id(해당 session JSESSIONID): " + session.getId());
        System.out.println("firstName = " + session.getAttribute("firstName").toString());
        System.out.println("lastName = " + session.getAttribute("lastName").toString());

        resp.sendRedirect("redirect");
    }
}
