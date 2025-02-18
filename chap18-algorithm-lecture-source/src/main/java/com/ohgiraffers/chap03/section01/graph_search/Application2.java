package com.ohgiraffers.chap03.section01.graph_search;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 수업목표. BFS와 x, y 좌표를 활용한 문제를 해결할 수 있다. */
/* 설명.
*   너비 우선 탐색(Breadth-First Search)
*   선입선출 구조의 queue를 활용
*   시작 노드에서 출발해 시작 노드를 기준으로 가까운 노드를 먼저 방문하면서 탐색하는 알고리즘 */
public class Application2 {

    /* 설명. 문자열에서 한 줄씩 읽어들이기 위한 BufferedReader를 반환하는 메소드(readLine()) */
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream((str.getBytes()));
        return new BufferedReader(new InputStreamReader(is));
    }

    /* 설명. BFS로 문제 해결을 하기 위한 Queue */
    static Queue<Node> q = new LinkedList<>();

    /* 설명.  같은 인덱스에 있는 값을 활용해 상하좌우를 의미하는 좌표 배열들 */
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};

    /* 설명. 배추밭 */
    static int[][] map;

    /* 설명. 방문배열 */
    static boolean[][] visit;

    /* 설명. 현재 위치에 대한 좌표 */
    static int cur_x, cur_y;

    /* 설명. 배추밭의 크기(너비/높이), 심어진 배추의 수 */
    static int M, N, K;
    
    /* 설명. 필요한 배추흰지렁이의 수 */
    static int count;

    /* 설명. x, y 좌표를 가지는 static 내부 클래스 */
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

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[y][x] = 1;
        }

        count = 0;

        /* 설명. i, j는 캐릭터의 좌표를 뜻함 */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                /* 설명. 방문 안 한 위치에 배추가 심어져 있으면 지렁이를 뿌리자 */
                if(visit[i][j] == false && map[i][j] == 1) {
                    count++;

                    bfs(j, i);
                }
            }
        }

        return count;
    }

    /* 설명. 배추가 상하좌우를 보고 방문하지 않고 유효한 범위 안에 또 다른 배추가 배추가 있는지 확인 */
    private static void bfs(int x, int y) {
        q.offer(new Node(x, y));
        visit[y][x] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                cur_x = node.x + dirX[i];
                cur_y = node.y + dirY[i];

                /* 설명. 지금 보는 방향이 좌표로 존재, 방문한 적 X, 배추 O */
                if(range_check() && !visit[cur_y][cur_x] && map[cur_y][cur_x] == 1) {
                    q.offer(new Node(cur_x, cur_y));
                    visit[cur_y][cur_x] = true;
                }
            }
        }
    }

    private static boolean range_check() {
        return cur_x >= 0 && cur_x < M && cur_y >= 0 && cur_y < N;
    }
}
