package com.ohgiraffers.assertions.section02.assertj;

import com.ohgiraffers.assertions.section01.jupiter.NumberValidator;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertJTest {

    /* 수업목표. test 작성을 위한 3rd party lib 중 AssertJ의 사용법에 대해 이해할 수 있다. */
    /* 설명. 1. 문자열 테스트하기 */
    @Test
    @DisplayName("문자열 테스트하기")
    void testStringValidation() {

        // given
        String expected = "hello world";

        // when
        String actual = new String(expected);

        // then
        Assertions.assertThat(actual)
                .isNotEmpty()           // 문자열이 비어있지 않은지
                .isNotBlank()           // 문자열이 공백이 아닌 문자열이 포함 되는지
                .contains("hello")
                .doesNotContain("banana")
                .startsWith("h")
                .endsWith("d")
                .isEqualTo("hello world");
    }

    /* 설명. 2. 숫자 테스트하기 */
    @Test
    @DisplayName("숫자 테스트하기")
    void testIntegerValidation() {
        double pi = Math.PI;

        Double actual = pi;

        Assertions.assertThat(actual)
                .isPositive()
                .isGreaterThan(3)
                .isLessThan(4)
                .isEqualTo(Math.PI);
    }
    
    /* 설명. 3. 날짜 테스트하기 */
    @Test
    @DisplayName("날짜 테스트하기")
    void testLocalDateTimeValidation() {
        String birthday = "2020-01-01T16:42:00.000";

        LocalDateTime theDay = LocalDateTime.parse(birthday);

        Assertions.assertThat(theDay)
                .hasYear(2020)
                .hasMonthValue(1)
                .hasMonth(Month.JANUARY)
                .hasDayOfMonth(1)
                .isBetween("2020-01-01T00:00:00.000", "2020-01-01T23:59:59.000")
                .isBefore(LocalDateTime.now());
    }

    /* 설명. 4. 예외 테스트하기 */
    @Test
    @DisplayName("예외 테스트하기")
    void testExceptionValidation() {
//        Throwable thrown = AssertionsForClassTypes.catchThrowable(() -> {
//            throw new IllegalArgumentException("잘못된 파라미터를 입력하셨습니다.");
//        });

        int firstNum = 10;
        int secondNum = 0;

        NumberValidator validator = new NumberValidator();
        Exception exception = org.junit.jupiter.api.Assertions.assertThrows(
                Exception.class,
                () -> validator.checkDividableNumbers(firstNum, secondNum)
        );

//        Assertions.assertThat(thrown)
        Assertions.assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("파라미터");
                .hasMessageContaining("0으로");
    }
    
    /* 설명. 5. filter를 이용한 단정문 테스트하기 */
    @Test
    @DisplayName("filtering assertions 테스트하기")
    void testFilteringAssertions() {
        Member member1 = new Member(1, "user01", "홍길동", 20);
        Member member2 = new Member(2, "user02", "김길동", 19);
        Member member3 = new Member(3, "user03", "이길동", 40);
        Member member4 = new Member(4, "user04", "박길동", 23);
        Member member5 = new Member(5, "user05", "최길동", 16);

        /* 설명. Arrays.asList 부분은 실제 DB에서 5명의 회원을 조회해서 List 형태로 반환하는 기능이라고 가정 */
        List<Member> members = Arrays.asList(member1, member2, member3, member4, member5);

        Assertions.assertThat(members)
                .filteredOn(member -> member.getAge() > 20) // 나이가 20살 초과인 멤버만 필터링
                .containsOnly(member3, member4);                    // 결과가 member3, 4만 있는지
    }

    /* 설명. 6. 객체 프로퍼티 검증하기 */
    @Test
    @DisplayName("객체의 프로퍼티 검증 테스트하기")
    void testPropertyValidation() {
        Member member1 = new Member(1, "user01", "홍길동", 20);
        Member member2 = new Member(2, "user02", "김길동", 19);
        Member member3 = new Member(3, "user03", "이길동", 40);
        Member member4 = new Member(4, "user04", "박길동", 23);
        Member member5 = new Member(5, "user05", "최길동", 16);

        List<Member> members = Arrays.asList(member1, member2, member3, member4, member5);

        Assertions.assertThat(members)
                .filteredOn("age", 20)
                .containsOnly(member1);
    }
}
