package org.example.lifecycle.section01.xml;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

public class LifeCycleTestServlet extends HttpServlet {

    /* 설명. 기본 생성자 */
    public LifeCycleTestServlet() {
        System.out.println("xml 방식 서블릿 기본 생성자 실행!");
    }

    /* 설명. 객체 생성 시 자동으로 호출됨 */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("xml 매핑 init() 메소드 호출!");
    }

    /* 설명. 생성된 객체를 소멸하기 전에 실행됨 */
    @Override
    public void destroy() {
        System.out.println("xml 매핑 destroy() 메소드 호출!");
    }

    /* 설명. 객체 생성 후 요청이 들어오면 이게 호출됨 */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("xml 매핑 service() 메소드 호출!");
    }
}
