package org.example.baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_17615 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 공의 총 개수
        String ballColor = br.readLine(); // 공의 색깔
        int result = N; // 공의 총 개수를 result로 담아놓고 이따 비교할 때 쓰기
        int redCnt = 0, blueCnt = 0;

        // 총 공에서 빨간색과 파란색 공이 몇 개 있는지 확인하는 로직
        for (int i = 0; i < N; i++) { // 볼 순회했을 때
            if (ballColor.charAt(i) == 'R') { // 빨간색이면 redCnt +1
                redCnt++;
            } else { // 아니면 파란색이니까 blueCnt +1
                blueCnt++;
            }
        }

        int cnt = 0; // 파란 공 빨간 공 나온 횟수 저장할 cnt 변수를 경우에 따라 0으로 초기화
        // 빨간 공을 왼쪽으로 움직이는 경우
        for (int i = 0; i < N; i++) {
            if (ballColor.charAt(i) == 'R') {
                cnt++;
            } else break;
        }
        result = Math.min(result, redCnt - cnt);

        cnt = 0;
        // 파란 공을 왼쪽으로 움직이는 경우
        for (int i = 0; i < N; i++) {
            if (ballColor.charAt(i) == 'B') {
                cnt++;
            } else break;
        }
        result = Math.min(result, blueCnt - cnt);

        cnt = 0;
        // 빨간 공을 오른쪽으로 움직이는 경우
        for (int i = N - 1; i >= 0; i--) {
            if (ballColor.charAt(i) == 'R') {
                cnt++;
            }
            else break;
        }
        result = Math.min(result, redCnt - cnt);

        cnt = 0;
        // 파란 공을 오른쪽으로 움직이는 경우
        for (int i = N - 1; i >= 0; i--) {
            if (ballColor.charAt(i) == 'B') {
                cnt++;
            } else break;
        }
        result = Math.min(result, blueCnt - cnt);

        System.out.println(result);

    }
}
