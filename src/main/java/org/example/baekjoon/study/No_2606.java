package org.example.baekjoon.study;

import java.io.*;
import java.util.*;

/**
 * 백준 2606 : 바이러스
 */
public class No_2606 {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int M = Integer.parseInt(br.readLine()); // 컴퓨터 번호 쌍
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a); // 무방향 그래프 연결
        }

        dfs(1);

        System.out.println(cnt);
    }

    public static void dfs(int node) {
        visited[node] = true;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                cnt++;
                dfs(next);
            }
        }
    }
}
