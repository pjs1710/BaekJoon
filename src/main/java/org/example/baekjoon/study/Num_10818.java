package org.example.baekjoon.study;

import java.util.Scanner;

public class Num_10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int []a = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            a[i] = num;
        }
        int min = a[0], max = a[0];
        for (int i = 0; i < n; i++) {
            if(a[i] < min) {
                min = a[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }
        System.out.print(min + " " + max);
    }
}
