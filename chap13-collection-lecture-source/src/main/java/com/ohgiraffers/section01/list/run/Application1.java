package com.ohgiraffers.section01.list.run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 컬렉션 프레임워크에 대해 이해할 수 있다. */

        /* 설명. 모든 컬렉션은 제네릭 타입이면 다이아몬드 연산자(<>)를 생략하면 <Object>인 상태이다. */
//        ArrayList list = new ArrayList();
        List<Object> list = new ArrayList<>(); // ArrayList는 List의 하위 클래스이다.

        /* 설명. 데이터를 넣은 순서를 기억한다. */
        list.add("apple");
        list.add(123);
        list.add(4.56);
        list.add(new java.util.Date());

        /* 설명. 모든 컬렉션은 toString()이 잘 오버라이딩 되어 쉽게 출력해 볼 수 있다. */
        System.out.println("list: " + list);

        System.out.println("첫번째 값: " + list.get(0));
        System.out.println("두번째 값: " + list.get(1));
        System.out.println("list에 담긴 데이터의 크기: " + list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        /* 설명.
        *   배열보다 좋은 점
        *   1. 미리 크기를 할당할 필요가 없다.
        *   2. 들어있는 값의 갯수를 잘 파악할 수 있다.
        *   3. 경우에 따라(제네릭 타입을 생략하면) 다양한 값을 한 번에 저장할 수 있다.
        *   4. 중간에 값을 추가 및 삭제가 용이하다. */

        /* 설명. 2번째 위치에 10을 끼워넣기 */
        list.add(1, 10);
        System.out.println("list: " + list);
        list.add(1, 10);
        System.out.println("list: " + list);

        /* 설명. 원하는 위치 값 수정 */
        list.set(0, "banana");
        System.out.println("list: " + list);

        /* 설명. 원하는 위치 값 제거(이후 값들 다 땡겨오기) */
        list.remove(0);
        System.out.println("list[0] " + list.get(0));

        /* 설명. 추가로 컬렉션 대신 배열로 중간에 값 추가 연습해 보기 */
        int[] intArr = new int[5];
        int num = 0;
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = ++num;
        }

        System.out.println(Arrays.toString(intArr));
        intArr = addOne(intArr,0, 10);
        System.out.println(Arrays.toString(intArr));

        /* 설명. ArrayList를 활용한 정렬 */
        /* 목차. 1. 문자열 데이터 정렬(feat. 오름차순) */
        List<String> stringList = new ArrayList<>();
        /* 설명. 내림차순 시에는 LinkedList로 변경해야 함. ArrayList와 LinkedList는 형제임.*/
//        List<String> stringList = new LinkedList<>(); // 내림차순 시에는 LinkedList로 변경. descendingIterator() 사용 위해
        /* 설명.
        *   LinkedList<String> stringList = new LinkedList<>();를 하지 않고 왜
        *   List<String> stringList = new LinkedList<>(); 이렇게 다형성을 적용해서 작성하는가?
        *   타입 은닉화 기술. 구현 은닉(인터페이스 활용). LinkedList<>()가 구현체
        *   실제로 어떤 객체가 생성되는 것인지 모르게. List는 인터페이스(직접 객체 생성이 안 됨)
        *   컴파일 시점에서는 List(부모)인 줄 알게 하는 거임. 왜?
        *   결국 유지보수 때문임. 다른 곳이 바뀌어도 나에게는 문제가 번져오지 않게 하기 위해
        *   따라서 보통 좌측에는 부모 타입(인터페이스)을 둠 => 하위 구현체가 바뀌어도 상관 없게*/
        stringList.add("apple");
        stringList.add("orange");
        stringList.add("banana");
        stringList.add("mango");
        stringList.add("grape");

        System.out.println("문자열 데이터: " + stringList);
        /* 설명. 실제로는 ArrayList 안에 있는 데이터인 String에 정의된 기준(오름차순)대로 정렬됨 */
        Collections.sort(stringList);
        System.out.println("오름차순 정렬된 문자열 데이터: " + stringList);

        /* 목차. 1-1. 문자열 데이터 내림차순 정렬 */
        /* 설명. StringTokenizer와 비슷함. Iterator는 순회가 가능한 데이터 구조로 저장함. 직접은 안 되고 메소드 사용 */
        /* 설명. 제네릭 클래스를 생략하면 Object로 인식함 but 꼭 명시하자. 타입 안정성을 위해
        *   Iterator iter = ... => Iterator<Object> iter = ... */
        Iterator<String> iter = ((LinkedList<String>)stringList).descendingIterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

    }

    public static int[] addOne(int[] arr, int index, int num) {
        int[] newArr = new int[arr.length + 1];

        // index 이전까지 복사
        System.arraycopy(arr, 0, newArr, 0, index);

        // 새로운 숫자 추가
        newArr[index] = num;

        // index 이후의 요소들을 복사
        System.arraycopy(arr, index, newArr, index + 1, arr.length - index);

        return newArr;
    }
}
