package com.ohgiraffers.section02.variable;

public class Applcation1 {
    public static void main(String[] args) {

        /* 수업목표. 변수의 사용 목적에 대해 이해할 수 있다. */

        /* 목차. 값에 의미를 부여하기 위한 목적(가독성) */
        System.out.println("=== 값에 의미 부여 테스트 ===");
        System.out.println("보너스를 포함한 급여: " + (3000000 + 500000) + "원");

        int salary = 3000000;
        int bonus = 500000;
        System.out.println("보너스를 포함한 급여: " + (salary + bonus) + "원");

        /* 목차. 2. 한 번 지정해둔 값을 재사용하기 위한 목적 */
        System.out.println("=== 변수에 저장한 값 재사용 테스트 ===");

        System.out.println("1번 고객에게 포인트를 100포인트 지급했습니다.");
        System.out.println("2번 고객에게 포인트를 100포인트 지급했습니다.");
        System.out.println("3번 고객에게 포인트를 100포인트 지급했습니다.");
        System.out.println("4번 고객에게 포인트를 100포인트 지급했습니다.");
        System.out.println("5번 고객에게 포인트를 100포인트 지급했습니다.");
        System.out.println("6번 고객에게 포인트를 100포인트 지급했습니다.");
        System.out.println("7번 고객에게 포인트를 100포인트 지급했습니다.");
        System.out.println("8번 고객에게 포인트를 100포인트 지급했습니다.");
        System.out.println("9번 고객에게 포인트를 100포인트 지급했습니다.");
        System.out.println("10번 고객에게 포인트를 100포인트 지급했습니다.");
        System.out.println();

        int point = 100;
        System.out.println("1번 고객에게 포인트를 " + point + "포인트 지급했습니다.");
        System.out.println("2번 고객에게 포인트를 " + point + "포인트 지급했습니다.");
        System.out.println("3번 고객에게 포인트를 " + point + "포인트 지급했습니다.");
        System.out.println("4번 고객에게 포인트를 " + point + "포인트 지급했습니다.");
        System.out.println("5번 고객에게 포인트를 " + point + "포인트 지급했습니다.");
        System.out.println("6번 고객에게 포인트를 " + point + "포인트 지급했습니다.");
        System.out.println("7번 고객에게 포인트를 " + point + "포인트 지급했습니다.");
        System.out.println("8번 고객에게 포인트를 " + point + "포인트 지급했습니다.");
        System.out.println("9번 고객에게 포인트를 " + point + "포인트 지급했습니다.");
        System.out.println("10번 고객에게 포인트를 " + point + "포인트 지급했습니다.");

        /* 목차. 코드의 흐름에 따라 변경되는 값을 같은 이름으로 사용할 목적 */
        System.out.println("=== 변수에 저장된 값 변경 테스트 ===");
        int sum = 0;

        sum += 10;
        System.out.println("sum에 10을 더한 값: " + sum);
    }
}
