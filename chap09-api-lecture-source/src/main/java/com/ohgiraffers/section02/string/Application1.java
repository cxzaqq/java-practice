package com.ohgiraffers.section02.string;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. String 클래스의 자주 사용하는 메소드에 대해 숙지하고 응용할 수 있다 */
        /* 목차. 1. charAt() */
        /* 설명. 해당 인덱스 위치의 한 문자를 반환 */
        String str1 = "apple";

        for (int i = 0; i < str1.length(); i++) {
            System.out.println("charAt(" + i + ") = " + str1.charAt(i));
        }

        /* 목차. 2. compareTo() */
        /* 설명. 유니코드상 문자를 비교하여 정수로 반환 첫 글자부터 */
        String str2 = "java";
        String str3 = "java";
        String str4 = "JAVA";
        String str5 = "mariaDB";
        String testStr = "jbva";
        System.out.println(str2.compareTo(str3));
        System.out.println(str2.compareTo(str4));
        System.out.println(str4.compareTo(str2));
        System.out.println(str2.compareTo(str5));
        System.out.println(str5.compareTo(str2));
        System.out.println(str2.compareTo(testStr));

        /* 목차. 3. concat() */
        /* 설명. 문자열을 합쳐줌 */
        System.out.println("concat(): " + str2.concat(str5));

        /* 목차. 4. indexOf() */
        /* 설명. 해당 문자와 일치하는 가장 첫번째 인덱스를 반환. 없으면 -1 */
        String indexOf = "java mariaDB";
        System.out.println("indexOf('a'): " + indexOf.indexOf('a'));
        System.out.println("indexOf('z'): " + indexOf.indexOf('z'));

        /* 목차. 5. trim() */
        /* 설명. 공백 제거. 원본에 영향 X
        *   양쪽만. 가운데는 아님 */
        String trimStr = "    java    ";
        System.out.println("trimStr: #" + trimStr + "#");
        System.out.println("trim(): #" + trimStr.trim() + "#");
        System.out.println("trimStr: " + trimStr);
        System.out.println("trimTest: " + "    ja    va     ".trim());

        /* 목차. 6. toLowerCase()/toUpperCase() */
        /* 설명. 문자열 전체를 소문자/대문자로 바꿔준다 원본에 영향 X*/
        String caseStr = "javamariaDB";
        System.out.println("toLowerCase(): " + caseStr.toLowerCase());
        System.out.println("toUpperCase(): " + caseStr.toUpperCase());
        System.out.println("caseStr: " + caseStr);

        /* 목차. 7. substring() */
        /* 설명. 3, 6 => index 3 ~ 5 / 3 => index 3 ~ end 원본에 영향 X*/
        String javamariaDB = "java mariaDB";
        System.out.println("substring(3, 6): " + javamariaDB.substring(3, 6));
        System.out.println("substring(3): " + javamariaDB.substring(3));
        System.out.println("javamariaDB: " + javamariaDB);

        /* 목차. 8. replace() */
        /* 설명. 특정 문자열을 다른 문자열로 대체 원본에 영향 X */
        System.out.println("replace(): " + javamariaDB.replace("java", "python"));
        System.out.println("javamariaDB: " + javamariaDB);

        /* 목차. 9. length() */
        /* 설명. 문자열 길이 반환 */
        System.out.println("length(): " + javamariaDB.length());
        System.out.println("빈 문자열의 길이: " + "".length());

        /* 목차. 10. isEmpty() */
        /* 설명. 문자열이 비었는가? */
        System.out.println("isEmpty(): " + "".isEmpty());
        System.out.println("isEmpty(): " + "abc".isEmpty());

    }
}
