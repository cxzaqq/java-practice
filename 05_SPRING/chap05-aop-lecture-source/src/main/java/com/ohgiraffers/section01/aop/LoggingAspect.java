package com.ohgiraffers.section01.aop;

import java.util.Arrays;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    /* 설명.
     *  타겟 클래스의 메소드에서 어드바이스를 적용할 수 있는 지점들을 조인포인트(joinpoint)라고 한다.
     *  포인트컷(pointcut)은 여러 조인포인트들에 어드바이스(advice)를 적용할 곳을 지정한 것이다
     *  해당 조인포인트에서 어드바이스가 동작한다.
     *
     * 설명.
     *  <포인트컷 표현식>
     *  execution([수식어] 리턴타입 [클래스이름].이름(파라미터))
     *  1. 수식어: public, private 등 수식어를 명시(생략 가능)
     *  2. 리턴 타입: 리턴 타입을 명시
     *  3. 클래스 이름(패키지명 포함) 및 메소드 이름: 클래스이름과 메소드 이름을 명시
     *  4. 파라미터(매개변수): 메소드의 파라미터를 명시
     *  5. " * ": 1개이면서 모든 값이 올 수 있음
     *  6. " .. ": 0개 이상의 모든 값이 올 수 있음
     *
     * 설명.
     *  ex)
     *   execution(public Integer com.ohgiraffers.section01.advice.*.*(*))
     *   => com.ohgiraffers.section01.advice 패키지에 속해 있는 바로 다음 하위 클래스에 파라미터가 1개인 모든 메소드
     *      이자 접근 제어자가 public이고 반환형이 Integer인 경우
     *   execution(* com.ohgiraffers.section01.advice.annotation..stu*(..))
     *   => com.ohgiraffers.section01.advice 패키지 및 하위 패키지에 속해 있고 이름이 stu로 시작하는 파라미터가 0개
     *      이상인 모든 메소드이며 접근제어자와 반환형은 상관 없음
     * */

    /* 설명. Pointcut 표현식을 재활용하고자 할 때는 메소드로 따로 빼서 @Pointcut을 활용한다 */
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void loggingAspect() {
    }

    /* 설명. 1. Before Advice */
//    @Before("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    @Before("LoggingAspect.loggingAspect()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("--------------------------BEFORE START--------------------------");
        System.out.println("Before Advice 동작");
        System.out.println("Before joinPoint.getTarget(): " + joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature(): " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0) {
            System.out.println("Before joinPoint.getArgs(): " + Arrays.toString(joinPoint.getArgs()));
        }
        System.out.println("--------------------------BEFORE END--------------------------");
    }

    /* 설명. 2. After Advice */
    @After("LoggingAspect.loggingAspect()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("--------------------------AFTER START--------------------------");
        System.out.println("After Advice 동작");
        System.out.println("After joinPoint.getTarget(): " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature(): " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0) {
            System.out.println("After joinPoint.getArgs(): " + Arrays.toString(joinPoint.getArgs()));
        }
        System.out.println("--------------------------AFTER END--------------------------");
    }

    /* 설명. 3. AfterReturning Advice */
    /* 설명. returning의 이름과 매개변수의 이름이 같아야 함 */
    /* 설명. Pointcut에 해당하는 위치가 담긴 메소드가 같은 클래스에 있으면 클래스 소속 생략 가능 */
    @AfterReturning(pointcut = "loggingAspect()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("--------------------------AFTER RETURN START---------------------------");
        System.out.println("After Returning result: " + result);

        if (result != null && result instanceof List) {
            ((List<MemberDTO>) result).add(new MemberDTO((3L), "반환 값 가공"));
        }
        System.out.println("--------------------------AFTER RETURN END---------------------------");
    }

    /* 설명. 4. AfterThrowing Advice */
    /* 설명. annotation의 throwing 속성과 어드바이스의 매개변수 이름이 일치해야 한다. */
    @AfterThrowing(pointcut = "loggingAspect()", throwing = "exception")
    public void logAfterThrowing(Throwable exception) {
        System.out.println("--------------------------AFTER THROW START-------------------------");
        System.out.println("After Throwing exception: " + exception);
        System.out.println("--------------------------AFTER THROW END-------------------------");
    }

    /* 설명. 5. Around Advice */
    /* 설명.
    *   target method를 완전히 장악하기 때문에 앞서 살펴 본 어드바이스 모두
    *   Around Advice 하나로 대체가 가능하다.
    *   target method를 언제 실행할지, 아니면 실행을 안 할지 여부도 제어한다.(필터와 유사)
    *   but target method를 실행하는 proceed() 메소드를 잊는 경우가 자주 발생하기 때문에 사용 시
    *   주의해야 하며 가능한 최소한의 요건을 충족하면서도 가장 약한 어드바이스를 쓰는 것이 바람직하다. */
    @Around("loggingAspect()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("--------------------------Around START-------------------------");

        /* 설명. 작성 안 하면 target method가 실행되지 않을 수도 있다. */
        Object result = joinPoint.proceed(); // 타겟 메소드 동작

        System.out.println("--------------------------Around END-------------------------");

        /* 설명. 실행된 target 메소드를 반환(다른 어드바이스가 다시 실행될 수 있다.) */
        return result;
    }
}
