package org.example.baekjoon.study;

import java.io.*;
import java.util.*;

/**
 * 백준 1475번 : 방 번호
 */

public class No_1475 {

    static String[] numData;
    static int[] numSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numData = br.readLine().split("");
        numSet = new int[10];

        for (int i = 0; i < numData.length; i++) {
            if (numData[i].equals("9") || numData[i].equals("6")) {
                numSet[6]++;
            } else {
                numSet[Integer.parseInt(numData[i])]++;
            }
        }

        numSet[6] = (numSet[6] + 1) / 2; // 9961 -> numSet[6] = 3 , numSet[6] = 3 + 1 / 2 = 2
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++) {
            if (numSet[i] > maxValue) {
                maxValue = numSet[i];
            }
        }

        System.out.println(maxValue);
    }
}
