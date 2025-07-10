package org.example.baekjoon.study;

import java.io.*;
import java.util.*;

/**
 * 백준 16437 : 양 구출 작전
 */

public class No_16437 {

    static int N;
    static List<Integer>[] graph;
    static Node[] type;

    static class Node {
        String type;
        long amount;

        public Node(String type, long amount) {
            this.type = type;
            this.amount = amount;
        }
    }

    static long dfs(int node) {
        long rescueSheepCnt = 0;

        for (int next : graph[node]) {
            rescueSheepCnt += dfs(next);
        }

        if (type[node].type.equals("S")) {
            return rescueSheepCnt + type[node].amount;
        } else {
            return Math.max(0, rescueSheepCnt - type[node].amount);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        type = new Node[N + 1];
        type[1] = new Node("S", 0);
        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String T = st.nextToken();
            long A = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            graph[P].add(i);
            type[i] = new Node(T, A);
        }

        System.out.println(dfs(1));
    }
}
