package com.ohgiraffers.section03.map.run;

import com.ohgiraffers.section01.list.dto.BookDTO;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. Map의 자료구조에 대해 이해하고 HashMap을 이용할 수 있다. */
        /* 설명. 주로 key는 String으로 쓴다. */
        Map<Object, Object> hMap = new HashMap<>();
        hMap.put("one", new java.util.Date());
        hMap.put(12, "red apple");
        hMap.put(33, 123);

        /* 설명. Map은 key를 통해 value를 뽑는 것이 기본적이며 key는 객체의 동등 비교(e, h)를 통해 확인된다. */
//        System.out.println("키가 \"one\"인 value 값: " + hMap.get(new String("one")));
        System.out.println("키가 \"one\"인 value 값: " + hMap.get("one"));
        /* 설명. Map에 있는 각 객체의 toString()이 모두 호출되는 것 */
        System.out.println(hMap);

        /* 목차. 1. key 중복 */
        /* 설명. 우리가 만든 객체도 key로 사용 가능하지만 hashCode(), equals()가 재정의되지 않으면 키가 중복될 수 있다. */
        hMap.put(new BookDTO(1, "홍길동전", "허균", 50000), 1);
        /* 설명. 키가 중복되면 put() 시 value가 덮어씌워진다. */
        hMap.put(new BookDTO(2, "홍길동전", "허균", 50000), 2);
        System.out.println(hMap);

        /* 목차. 2. value 중복 */
        hMap.put(44, 123);
        System.out.println(hMap);

        /* 설명. Map 활용
        *   key는 Set 계열임 */
        Map<String, String> hMap2 = new HashMap<>();
        hMap2.put("one", "java 17");
        hMap2.put("two", "mariaDB 10");
        hMap2.put("three", "servlet/jsp");
        hMap2.put("four", "springboot 3.0");
        hMap2.put("five", "vue");

        System.out.println("hMape2: " + hMap2);

        /* 설명. 순회1. key를 Set으로 바꿔서 Iterator를 사용 */
        Set<String> keys = hMap2.keySet();
        Iterator<String> iter = keys.iterator();
        while(iter.hasNext()) {
            String key = iter.next();
            System.out.println("key: " + key + ", value: " + hMap2.get(key));
        }
        System.out.println();

        /* 설명. 순회2. entrySet()을 사용 */
        /* 설명. key, value를 동시에 set으로 묶어서(이 묶은 걸 entry라 함) Iterator로 순회
        *   key 필요없이 value를 가져올 수 있다. key만 set으로 바꾼 것보다 value를 조회할 때 성능이 좋다. */
        /* 설명. Map.Entry라 쓴 이유? Entry가 Map 안에 중첩 인터페이스로 있기 때문 */
        Set<Map.Entry<String, String>> set = hMap2.entrySet();
        Iterator<Map.Entry<String, String>> iter2 = set.iterator();
        while(iter2.hasNext()) {
            Map.Entry<String, String> entry = iter2.next();
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }
}
