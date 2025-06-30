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

    static String[][] input = new String[5][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String[] data = br.readLine().split("");
            for (int j = 0; j < data.length; j++) {
                input[i][j] = data[j];
            }
        }

        printString(); // 결과 출력 함수
    }

    public static void printString() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (input[j][i] != null) { // null이 아닐 때만 출력
                    System.out.print(input[j][i]);
                }
            }
        }
    }
}
