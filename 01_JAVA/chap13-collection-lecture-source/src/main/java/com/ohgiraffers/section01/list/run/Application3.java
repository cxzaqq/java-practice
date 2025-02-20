package com.ohgiraffers.section01.list.run;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. List 계열을 출력하는 4가지 방법 */
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");
        list.add("grape");
        list.add("mango");
        
        /* 설명. 1. toString() 활용하기 */
        System.out.println(list);
        
        /* 설명. 2. for문 활용하기 */
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        /* 설명. 3. for-each문 활용하기 */
        for(String str : list) {
            System.out.println(str);
        }
        
        /* 설명. 4. iterator 활용하기 */
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("기존 list: " + list);
        /* 설명. 1번 인덱스의 과일 수정 */
        list.set(1, "pineapple");
        System.out.println("수정 후: " + list);

        /* 설명. 요소 제거 */
        /* 설명. 2번 인덱스 제거 */
        list.remove(2);
        System.out.println("제거 후: " + list);

        /* 설명. 전체 제거
        *   'null'과 '객체는 있지만 비어있음'을 잘 구분하자 */
        list.clear(); // 객체가 날라가는 게 아니라 요소만 없애라는 것
//        list = null; // 저장 공간 자체를 날려라 => NullpointerException이 발생 가능
        System.out.println("clear 후: " + list);
        System.out.println("isEmpty: " + list.isEmpty());
    }
}
