package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public Account accountGenerator() {
        return new PersonalAccount(20, "110-234-567890");
    }

    @Bean
    public MemberDTO memberGenerator() {

        /* 설명. setter 주입 */
//        MemberDTO member = new MemberDTO();
//        member.setSequence(1);
//        member.setName("hong");
//        member.setPhone("010-1234-1234");
//        member.setEmail("hong@test.com");
//        member.setPersonalAccount(accountGenerator());

        /* 설명. 생성자 주입 */
        MemberDTO member = new MemberDTO(
                1, "hong", "010-1234-1234",
                "hong@test.com", accountGenerator());

        return member;
    }
}
