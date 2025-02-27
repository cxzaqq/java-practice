package com.ohgiraffers.section02.xmlconfig;


import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new GenericXmlApplicationContext("section02/xmlconfig/spring-context.xml");
        
        /* 설명. 컨테이너에 들어있는 모든 bean의 이름(id)를 확인 */
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        /* 설명. 기본적으로 bean은 singleton인데 나중에 설정으로 바꿀 수 있음 */
        /* 설명. 1. bean의 id를 가지고 컨테이너에서 추출 */
        MemberDTO member = (MemberDTO) context.getBean("member");
        System.out.println("member = " + member); // lombok의 @ToString 어노테이션 작동

        /* 설명. 2. bean의 클래스의 메타 정보(bean의 타입)를 전달하여 추출 */
        MemberDTO member2 = context.getBean(MemberDTO.class);
        System.out.println("member2 = " + member2);

        /* 설명. 3. bean의 id와 클래스의 메타 정보를 전달하여 추출 */
        MemberDTO member3 = context.getBean("member", MemberDTO.class);
        System.out.println("member3 = " + member3);

        System.out.println(member == member2);
    }
}
