package com.ohgiraffers.common;

import org.springframework.stereotype.Repository;

/*
   설명.
    @Controller
    @Service
    @Repository
    @Configuratrion
    => @Component 계열
    모두 내부적으로 @Component를 가지고 있는데 이게 있으면 컨테이너가 bean으로 관리해 줌
    단 범위를 정해야 함
*/
@Repository
public class MemberDAO {
}
