package org.example.section01.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder responseText = new StringBuilder();
        responseText.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("<body>\n")
                .append("<h1>servlet response</h1>\n")
                .append("<h2>한글 테스트입니다.</h2>\n")
                .append("</body>\n")
                .append("</html>");

        /* 설명. MIME 타입과 인코딩 설정
        *   길을 열기 전에 설정해야 함
        *   but jakarta는 굳이 안 해도 됨 */
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8"); // 이렇게 한 줄로 가능

        /* 설명. 길을 열고 */
        PrintWriter out = resp.getWriter();
        
        /* 설명. responseText를 보낸다 */
        out.print(responseText);

        /* 설명. 출력 시에는 버퍼를 비우기 위해 항상 flush()를 호출 */
        out.flush();
        out.close();
    }
}
