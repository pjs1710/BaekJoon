package org.example.baekjoon.study;

import java.io.*;
import java.util.StringTokenizer;

public class Num_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int [] a = new int [30];

        for (int i = 0; i < 28; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            a[n - 1] = n;
        }
        for (int i = 0; i < 30; i++) {
            if (a[i] == 0) {
                bw.write((i + 1) + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
