package org.example.baekjoon.study;

import java.io.*;
import java.util.*;

/**
 * 세로 읽기
 *
 * 입력 :
 * ABCDE
 * abcde
 * 01234
 * FGHIJ
 * fghij
 *
 * 출력 :
 * Aa0FfBb1GgCc2HhDd3IiEe4Jj
 *
 * 입력 :
 * AABCDD
 * afzz
 * 09121
 * a8EWg6
 * P5h3kx
 *
 * 출력 :
 * Aa0aPAf985Bz1EhCz2W3D1gkD6x
 */

public class No_10798 {

    static String[][] input = new String[5][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxLen = 0;

        for (int i = 0; i < 5; i++) {
            input[i] = br.readLine().split("");
            maxLen = Math.max(maxLen, input[i].length); // 최대 길이 갱신
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < input[j].length) { // 행의 길이보다 열 인덱스가 작을 때만 접근. ex) 행의 길이 : 4, 인덱스는 0, 1, 2, 3만 접근
                    sb.append(input[j][i]);
                }
            }
        }
        System.out.println(sb); // 한번에 결과 출력
    }
}
