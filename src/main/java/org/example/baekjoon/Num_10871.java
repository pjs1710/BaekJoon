package org.example.baekjoon;

import java.util.Scanner;

public class Num_10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int [] a = new int[n];
        int x = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            a[i] = num;
        }
        for (int i = 0; i < n; i++) {
            if(a[i] < x){
                System.out.print(a[i] + " ");
            }
        }
    }
}
