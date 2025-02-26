package org.example.section02.uses;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/member/*")
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        /* 설명.
        *   톰캣 10버전 이전에는 post 요청일 때는 인코딩 설정을 하지 않으면 한글이 깨진다.
        *   10버전은 굳이 안 해도 되지만 현업의 경우에 따라 필요할 수 있고 추가로 다른 인코딩
        *   설정으로 바꿀 때도 해당 방식의 필터로 활용할 수 있다. */
        if("POST".equals(httpRequest.getMethod())) {
            httpRequest.setCharacterEncoding("UTF-8");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
