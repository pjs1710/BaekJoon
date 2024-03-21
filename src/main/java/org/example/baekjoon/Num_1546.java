package org.example.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Num_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int [] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int max = a[0];
        for (int i = 0; i < N; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += ((double)a[i] / max) * 100;
        }
        double avg = sum / N;
        System.out.println(avg);
    }
}
