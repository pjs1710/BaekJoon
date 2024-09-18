import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main { // 오름차순으로 만들기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(br.readLine());
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