package org.example.baekjoon.study;

import java.util.Scanner;

public class Num_2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int []a = new int[9];
        for (int i = 0; i < 9; i++) {
            int n = sc.nextInt();
            a[i] = n;
        }
        int idx = 1, max = a[0];
        for(int i = 0; i < 9; i++) {
            if(a[i] > max) {
                max = a[i];
                idx = i + 1;
            }
        }
        System.out.println(max + "\n" + idx);
    }
}
