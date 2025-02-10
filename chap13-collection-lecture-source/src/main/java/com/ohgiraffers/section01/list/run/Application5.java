package com.ohgiraffers.section01.list.run;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Application5 {
    public static void main(String[] args) {

        /* 수업목표. Queue에 대해 이해하고 할용할 수 있다. */
        /* 설명.
        *   Queue?
        *   선형 메모리 공간에 데이터를 저장하여 순서를 유지하기 위한 FIFO 방식의 자료구조
        *   대부분 LinkedList를 많이 사용한다. */
//        Queue queue = new Queue(); // Queue의 구현체는 하위 타입으로 만들어야 한다.
//        Queue<String> que = new LinkedList<String>();

        /* 설명. PriorityQueue(우선순위 큐)를 활용하면 FIFO + 정렬 가능 */
//        Queue<String> que = new PriorityQueue<>();
        Queue<String> que = new PriorityQueue<>(Collections.reverseOrder());

        que.offer("a");
        que.offer("b");
        que.offer("c");
        que.offer("d");
        que.offer("e");
        que.offer("f");
        System.out.println("queue: " + que);
        System.out.println("poll: " + que.poll());
        System.out.println("queue: " + que);
        System.out.println("poll: " + que.poll());
        System.out.println("queue: " + que);
        System.out.println("poll: " + que.poll());
        System.out.println("queue: " + que);
        System.out.println("poll: " + que.poll());
        System.out.println("queue: " + que);
    }
}
