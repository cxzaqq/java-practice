package com.ohgiraffers.chap04.section01.greedy;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Application3_2 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream((str.getBytes()));
        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        int max_count = 0;

        BufferedReader br = toBufferedReader(input);
        int N = Integer.parseInt(br.readLine());                    // 회의 수
        ArrayList<Time> timeList = new ArrayList<>();                               // 회의 시간 배열(시작, 종료)

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());          // 시작 시간
            int end = Integer.parseInt(st.nextToken());          // 종료 시간

            timeList.add(new Time(start, end));
        }

        Collections.sort(timeList);

        int endTime = 0;
        for(Time dis: timeList) {
            if(dis.start >= endTime) {
                if(dis.start == dis.end) {
                    max_count++;
                    continue;
                }
                endTime = dis.end;
                max_count++;
            }
        }

        return max_count;
    }
}

class Time implements Comparable<Time> {
    public int start, end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if(this.end == o.end) return o.start - this.start;
        else return this.end - o.end;
    }
}