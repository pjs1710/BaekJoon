package org.example.baekjoon.study;

import java.util.Scanner;

public class Num_10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int [] a = new int[n]; // 만들 배열의 수를 정하고 해당 수만큼 배열 할당해주기
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt(); // 배열에 들어갈 수 입력
            a[i] = num; // Index 순서대로 배열에 수 넣기
        }
        int v = sc.nextInt();
        int sum = 0;
        for(int i = 0; i < n; i++){
            if (a[i] == v) sum++;
        }
        System.out.println(sum);
    }
}
