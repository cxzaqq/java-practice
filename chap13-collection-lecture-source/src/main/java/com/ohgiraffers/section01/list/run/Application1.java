package com.ohgiraffers.section01.list.run;

import java.util.ArrayList;
import java.util.Arrays;
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
