package org.example.baekjoon.study;

import java.util.Scanner;

public class No_2847 { // 오름차순으로 만들기

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 레벨의 수
        sc.nextLine();
        int[] score = new int[N]; // 점수를 담을 배열 만들고
        int cnt = 0; // 총 몇번 내렸는지 카운트

        for (int i = 0; i < N; i++) { // 값 입력 받아서 배열에 담기
            score[i] = sc.nextInt();
            sc.nextLine();
        }
        for (int i = N - 1; i > 0; i--) { // 뒤에서부터 시작
            if (score[i - 1] >= score[i]) { // 만약에 가장 큰 수보다 크거나 같으면?
                while (!(score[i - 1] < score[i])) { // while로 가장 큰 수 score[i]보다 작게끔 점수 수정
                    score[i - 1]--; // 1 감소해주고
                    cnt++; // 감소시킨 횟수 수정
                }
            }
        }
        System.out.println(cnt); // 총 감소시킨 횟수 출력
    }
}
