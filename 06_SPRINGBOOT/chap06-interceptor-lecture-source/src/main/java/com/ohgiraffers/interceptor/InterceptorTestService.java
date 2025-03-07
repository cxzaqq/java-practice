package com.ohgiraffers.interceptor;

import org.springframework.stereotype.Service;

@Service
public class InterceptorTestService {
    public void test() {
        System.out.println("service bean 동작 확인");
    }
}
