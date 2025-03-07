package com.ohgiraffers.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* 설명. Interceptor 추가 및 static(정적) 리소스 호출 경로 등록 설정 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    private StopwatchInterceptor stopwatchInterceptor;

    @Autowired
    public WebConfiguration(StopwatchInterceptor stopwatchInterceptor) {
        this.stopwatchInterceptor = stopwatchInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(stopwatchInterceptor)
                .excludePathPatterns("/css/**");
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/")
                /* 설명. 항상 새로 요청하면 서버에 부담이 될 수 있어서 캐싱 처리 */
                .setCachePeriod(100); // 초 단위
    }
}
