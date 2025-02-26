package org.example.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

/* 설명. /first 이후 경로는 어떤 것이든 지금의 FirstFilter를 거치는 요청 경로가 된다. */
//@WebFilter(filterName = "firstFilter", urlPatterns = "/first/*")
@WebFilter(filterName = "firstFilter")
/* 설명. 필터는 톰캣 실행 시 인스턴스가 생성됨 */
public class FirstFilter implements Filter {
    public FirstFilter() {
        System.out.println("FirstFilter 인스턴스 생성!");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FirstFilter의 init 호출!");
    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter의 destroy 호출!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("FirstFilter의 doFilter 호출!");

        /* 설명. FilterChain에서 제공하는 doFilter는 다음 필터 또는 서블릿으로 진행하라는 의미이다. */
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("서블릿 다녀온 후(first)");
    }
}
