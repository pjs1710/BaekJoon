package org.example.baekjoon.study;

import java.io.*;
import java.util.*;

/**
 * 백준 1325 : 효율적인 해킹
 */

public class No_1325 {

    static int N;
    static int M;
    static List<List<Integer>> graph;
    static List<Integer> result;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(B).add(A);
        }

        result = new ArrayList<>();
        int maxValue = 0;
        for (int computer = 1; computer <= N; computer++) {
            int count = bfs(computer); // 1번 컴퓨터 ~ N번 컴퓨터 bfs 수행해서 해킹 가능한 컴퓨터 수 계산하기

            // 최대 해킹 가능한 컴퓨터 수 계산 및 갱신하고 result에 컴퓨터 번호도 넣기
            if (count > maxValue) {
                maxValue = count;
                result.clear();
                result.add(computer);
            } else if (count == maxValue) {
                result.add(computer);
            }
        }

        // 정렬 후 출력해야 함
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static int bfs(int start) {
        visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        cnt = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            cnt++;

            for (int next : graph.get(cur)) { // A가 B를 신뢰 A -> B, 3이 1을 신뢰, 1번 해킹하면 3번 해킹 -> graph.get(1) = 3 (해킹 가능한 컴퓨터)
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return cnt;
    }
}
