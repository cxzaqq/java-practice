package com.ohgiraffers.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
/* 설명. @Data로 하면 다 생성되지만 내부 클래스로 생성되고 메모리를 더 사용하기에
*   편할 순 있어도 좋은 방식은 아니다. */
public class MemberDTO {
    private int sequence;
    private String id;
    private String pwd;
    private String name;
}
