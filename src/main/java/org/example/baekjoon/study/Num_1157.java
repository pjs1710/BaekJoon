package org.example.baekjoon.study;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int codeNum = s.charAt(i) - 'A';
            arr[codeNum]++;
        }

        int max = 0;
        char answer = '?';
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                answer = (char) (i + 'A');
            } else if (max == arr[i]) {
                answer = '?';
            }
        }

        System.out.println(answer);
    }
}
