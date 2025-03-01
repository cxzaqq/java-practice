package com.ohgiraffers.section01.scope.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfiguration {

    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new java.util.Date());
    }
    
    @Bean
    public Product milk() {
        return new Beverage("딸기우유", 1000, 500);
    }
    
    @Bean
    public Product water() {
        return new Beverage("암반수", 1000, 500);
    }
    
    @Bean
    /* 설명. bean 스코프를 수정하게 되면 bean 객체의 life cycle을 다른 주기로 가져갈 수 있다. */
//    @Scope("singleton") // 안 적어도 이게 기본임
    /* 설명. bean에 접근할 때마다 새로운 객체를 생성해 줌 */
    @Scope("prototype")
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}
