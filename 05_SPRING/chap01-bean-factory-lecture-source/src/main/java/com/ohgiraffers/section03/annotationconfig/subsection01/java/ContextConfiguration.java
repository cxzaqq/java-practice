package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import com.ohgiraffers.common.MemberDAO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/* 설명.
*   section03에서는 ComponentScan과 관련하여 java 클래스에서 @ComponentScan 범위를
*   bean으로 등록하는 방법을 다룬다. 실제 bean으로 등록할 때 자주 쓰는 어노테이션 */
@Configuration

/* 설명. 1. 기본적으로는 설정파일이 있는 패키지 및 하위만 Scan하지만 basePackages를 바꾸면 다른 범위까지 가능하다. */
//@ComponentScan(basePackages = "com.ohgiraffers")

/* 설명. 2. 범위 및 필터를 적용해서 제외하고자 하는 bean을 등록하는 경우(excludeFilters)
*           (Blacklist 방식) */
//@ComponentScan(basePackages = "com.ohgiraffers", excludeFilters = {
//        @ComponentScan.Filter(
//                /* 설명. 2-1. 타입으로 설정 */
////                type = FilterType.ASSIGNABLE_TYPE,
////                classes = {MemberDAO.class}
//
//                /* 설명. 2-2. 어노테이션 종류로 설정 */
//                type = FilterType.ANNOTATION,
//                classes = {org.springframework.stereotype.Repository.class}
//        )
//})

/* 설명. 3. 범위 및 필터를 적용해서 등록하고자 하는 bean을 등록하는 경우(includeFilters)
*           (Whitelist 방식) */
@ComponentScan(basePackages = {"com.ohgiraffers", "com"},
                useDefaultFilters = false,                      // 현재 설정 파일 bean 제외 나머지는 off
                includeFilters = {
                    @ComponentScan.Filter(
                            type = FilterType.ASSIGNABLE_TYPE,
                            classes = {MemberDAO.class}         // MemberDAO 타입 bean만 등록
                    )
                })
public class ContextConfiguration {
}
