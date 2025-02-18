package com.ohgiraffers.chap03.section01.graph_search;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Application3 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream((str.getBytes()));
        return new BufferedReader(new InputStreamReader(is));
    }

    static boolean[][] visit;
    static int[][] map;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};
    static int N, M;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Integer solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        /* 설명. 입력값이 공백 없이 이어서 들어옴에 따라 한 문자씩 뜯어서 int 배열에 옮겨담는 반복문 */
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            char[] chArr = str.toCharArray();                       // String을 char 배열로 바꾸는 메소드
            for (int j = 0; j < chArr.length; j++) {
                map[i][j] = Character.getNumericValue(chArr[j]);    // 문자를 매칭되는 숫자로 바꾸는 메소드
            }
        }

        /* 설명. 시작과 동시에 첫 번째 칸 방문 체크 */
        visit[0][0] = true;

        bfs(0, 0);              // 도착지(우하단)까지 dfs가 돌며 알고리즘 진행

        return map[N - 1][M - 1];
    }

    private static void bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node n = q.poll();

            for (int i = 0; i < 4; i++) {
                int curX = n.x + dirX[i];
                int curY = n.y + dirY[i];

                if(curX < 0 || curY < 0 || curX >= M || curY >= N) {
                    continue;
                }

                if(visit[curY][curX] || map[curY][curX] == 0) {
                    continue;
                }

                q.offer(new Node(curX, curY));
                map[curY][curX] = map[n.y][n.x] + 1;

//                System.out.println("curX: " + curX);
//                System.out.println("curY: " + curY);
//                System.out.println("map[curY][curX]: " + map[curY][curX]);

                visit[curY][curX] = true;
            }
        }
    }
}
