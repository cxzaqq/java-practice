package org.example.section01.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

/* 설명. 
*   @WebFilter라는 어노테이션을 통해 필터 설정을 할 수 있지만 필터의 동작 순서를 원하는 대로
*   동작하게 하기 위해서는 Servlet에서는 web.xml을 활용한 xml 방식의 설정을 통해서만 바꿔줄 수 있다.
*   (필터의 동작 순서는 web.xml에 작성한 filter mapping의 순서에 따라 동작한다. */
//@WebFilter("/*")      // 모든 요청에 대해 처리되는 필터를 만들고 싶을 때
//@WebFilter(filterName = "secondFilter", urlPatterns = "/first/*")
@WebFilter(filterName = "secondFilter")
public class SecondFilter implements Filter {
    public SecondFilter() {
        System.out.println("SecondFilter 인스턴스 생성!");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SecondFilter의 init 호출!");
    }

    @Override
    public void destroy() {
        System.out.println("SecondFilter의 destroy 호출!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("SecondFilter의 doFilter 호출!");

        /* 설명. FilterChain에서 제공하는 doFilter는 다음 필터 또는 서블릿으로 진행하라는 의미이다. */
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("서블릿 다녀온 후(second)");
    }
}
