package com.ohgiraffers.section02.set.run;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        /* 설명. Set 자료 구조의 특성을 이해하고 hashSet을 이용할 수 있다. */
        Set<String> hSet = new HashSet<>(); // 타입 은닉
        hSet.add(new String("java"));
        hSet.add(new String("mariaDB"));
        hSet.add(new String("servlet"));
        hSet.add(new String("spring"));
        hSet.add(new String("html"));

        /* 설명. HashSet은 넣은 순서를 보장해 주지 않지만 저장하는 방식은 있다.
        *   즉 저장된 자료는 넣는 순서가 보장되지 않는다. */
        System.out.println("HashSet: " + hSet);

        /* 설명. 동일이 아닌 동등 객체의 중복을 방지하는 것이기에 이것도 안 들어감 */
        hSet.add(new String("mariaDB"));
        System.out.println("HashSet: " + hSet);

        /* 설명. Set은 인덱스 개념이 없어 Iterator(반복자)를 활용해야 한다. */
        Iterator<String> iter = hSet.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println();

        /* 설명. Set을 배열로 바꿀 수는 있다. (권장 X 왜? 다운 캐스팅 필요) */
        Object[] arr = hSet.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println((String)arr[i]);
        }

        System.out.println("size(): " + hSet.size());
        hSet.clear();
        System.out.println("size(): " + hSet.size());
        System.out.println("isEmpty(): " + hSet.isEmpty());

    }
}
