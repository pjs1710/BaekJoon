package org.example.baekjoon.study;

import java.util.Scanner;

public class Num_2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N; N = sc.nextInt();
        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < N - i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
