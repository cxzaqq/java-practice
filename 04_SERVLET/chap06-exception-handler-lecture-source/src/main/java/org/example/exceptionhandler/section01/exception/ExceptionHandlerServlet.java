package org.example.exceptionhandler.section01.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> attrNames = req.getAttributeNames();
        while (attrNames.hasMoreElements()) {
            System.out.println(attrNames.nextElement());
        }

        int statusCode = (int) req.getAttribute("jakarta.servlet.error.status_code");
        System.out.println("statusCode: " + statusCode);
        String message = (String) req.getAttribute("jakarta.servlet.error.message");
        String servletName = (String) req.getAttribute("jakarta.servlet.error.servlet_name");
        System.out.println("servletName: " + servletName);
        System.out.println("message: " + message);

        /* 설명. 위 재료들을 가지고 동적인 에러 페이지 생성 및 응답 */
        StringBuilder errorPage = new StringBuilder();
        errorPage.append("<h1>")
                .append(statusCode)
                .append("-")
                .append(message)
                .append("</h1>")
                .append("<br>\n")
                .append("<p>에러 발생한 서블릿 명: ")
                .append(servletName)
                .append("</p>");

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print(errorPage);
        out.flush();
        out.close();
    }
}
