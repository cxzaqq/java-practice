package org.example.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        
        String firstName = session.getAttribute("firstName").toString(); // 이게 좀 더 효율적이지만 큰 차이는 없음
        String lastName = (String) session.getAttribute("lastName");

        System.out.println("===== in redirect servlet =====");
        System.out.println("session id(해당 session JSESSIONID): " + session.getId());
        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        StringBuilder responseText = new StringBuilder();
        responseText.append("<h3>당신의 이름은 ")
                .append(firstName)
                .append("<br>그리고 성은 ")
                .append(lastName)
                .append("</h3>");

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print(responseText);
        out.flush();
        out.close();
    }
}
