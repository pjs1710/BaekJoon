package org.example.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Num_11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = A + B;
            bw.write("Case #" + (i+1) + ": ");
            bw.write(A + " + " + B + " = " + C + "\n");
        }
        bw.close();
    }
}
