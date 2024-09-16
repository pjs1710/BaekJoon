package org.example.baekjoon.study;

import java.util.*;

public class No_17086 {

    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};  // 8방향 가로 세로
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};  // 8방향 위 아래

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int col = Integer.parseInt(split[0]);
        int row = Integer.parseInt(split[1]);
        int[][] map = new int[col][row];
        int[][] dist = new int[col][row];  // 각 칸의 최소 거리를 저장할 배열
        Queue<int[]> queue = new LinkedList<>();

        // 입력 처리 및 상어 위치 큐에 추가
        for (int i = 0; i < col; i++) {
            String s1 = sc.nextLine();
            String[] split1 = s1.split(" ");
            for (int j = 0; j < row; j++) {
                map[i][j] = Integer.parseInt(split1[j]);
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j});  // 아기 상어의 위치를 큐에 저장
                    dist[i][j] = 0;  // 상어가 있는 위치는 거리 0
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // BFS 시작
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 8방향 탐색
            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 유효한 범위 내에서 아직 방문하지 않은 칸에 대해서만 처리
                if (nx >= 0 && ny >= 0 && nx < col && ny < row && dist[nx][ny] == Integer.MAX_VALUE) {
                    dist[nx][ny] = dist[x][y] + 1;  // 현재 칸에서의 거리 +1
                    queue.add(new int[]{nx, ny});  // 새로운 칸을 큐에 추가
                }
            }
        }

        // 가장 큰 최소 거리 찾기
        int maxDist = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                maxDist = Math.max(maxDist, dist[i][j]);
            }
        }

        System.out.println(maxDist);
    }
}
