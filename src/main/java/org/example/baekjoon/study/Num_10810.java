package org.example.baekjoon.study;

import java.io.*;
import java.util.StringTokenizer;

public class Num_10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int [] a = new int[N];
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            for (int j = I - 1; j < J; j++) {
                a[j] = K;
            }
        }

        for (int i = 0; i < a.length; i++) {
            bw.write(a[i] + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
