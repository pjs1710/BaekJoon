package org.example.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Num_10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int [] a = new int [N];
        int M = Integer.parseInt(st.nextToken());
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            a[i] = i + 1;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());

            tmp = a[J - 1];
            a[J - 1] = a[I - 1];
            a[I - 1] = tmp;
        }
        for (int i = 0; i < a.length; i++) {
            bw.write(a[i] + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
