package com.ohgiraffers.section04.dto;

import java.io.Serializable;
import java.util.Date;

/* 설명. DTO? Data Transfer Object.
*   자바빈(Java Bean)이란?
*   JSP에서 사용되는 표준 액션 태그로 접근할 수 있게 만든 자바 클래스이다.
*   자바 코드를 모르는 웹 퍼블리셔들도 자바 코드를 사용할 수 있도록 태그 형식으로 지원하는 문법을
*   의미하는데 그 때 사용할 수 있도록 규칙을 지정해 놓은 java 클래스를 자비빈(java bean)이라 부른다.
*   지금은 특정 목적 및 프레임워크를 위해 클래스를 작성하는 규칙이라고 보면 된다.
*
*  설명.
*   자바빈 작성 규칙
*   1. 자바빈은 특정 패키지에 속해 있어야 함.(default 패키지 사용 금지)
*   2. 필드의 접근 제어자는 private으로 선언해야 함(캡슐화 적용)
*   3. 기본 생성자가 명시적으로 존재해야 한다(매개변수 있는 생성자는 선택 사항)
*   4. 직렬화(Serializable 구현)을 고려해야 한다.(선택 사항)
* */
public class UserDTO /*implements Serializable*/ {
    private String id;
    private String pwd;
    private String name;
    private java.util.Date enroolDate;

    public UserDTO() {
    }

    public UserDTO(String id, String pwd, String name, Date enroolDate) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.enroolDate = enroolDate;
    }

    /* 설명. 아니 이렇게 우회로를 다 만들 거면 왜 private으로 캡슐화를 했지?
    *   이건 보통 자바 개발자가 사용하는 것이 아닌 특정 프레임워크, 웹 퍼블리셔 등이 사용함
    *   명명 규칙이 있음.
    *   무조건 get 또는 set 으로 시작하고 필드 이름으로 낙타체 사용 */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEnroolDate() {
        return enroolDate;
    }

    public void setEnroolDate(Date enroolDate) {
        this.enroolDate = enroolDate;
    }

    /* 설명. 이걸 작성하면 그냥 sout 가능 */
    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", enroolDate=" + enroolDate +
                '}';
    }
}
