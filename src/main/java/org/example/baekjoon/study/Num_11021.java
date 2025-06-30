package org.example.baekjoon.study;

import java.io.*;
import java.util.StringTokenizer;

public class Num_11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // br로 문자열 입력한 것을 정수로 변환.
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 입력한 문자열들을 공백 단위로 분할
            bw.write("Case #" + (i+1) + ": ");
            bw.write((Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()))+ "\n"); // 분할된 문자열들을 정수로 변환한 후 더하기
        }
        bw.close();
    }
}