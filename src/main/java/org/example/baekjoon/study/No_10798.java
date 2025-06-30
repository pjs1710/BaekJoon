package org.example.baekjoon.study;

import java.io.*;
import java.util.*;

/**
 * 세로 읽기
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

        printString();
    }

    public static void printString() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (input[j][i] != null) {
                    System.out.print(input[j][i]);
                }
            }
        }
    }
}
