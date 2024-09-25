package org.example.baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_20055 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 컨베이어 벨트의 길이
        int K = Integer.parseInt(st.nextToken()); // 내구도 0인 칸의 개수의 상한선
        int kCnt = 0; // 내구도 0인 칸의 개수를 추적하는 값
        int fullLength = N * 2; // 컨베이어 벨트 전체 길이
        int processStep = 0; // 단계 수
        int[] durability = new int[fullLength]; // 내구도를 저장할 배열
        int[] dup = new int[fullLength]; // 내구도 회전시 새로운 상태를 저장할 배열
        boolean[] robot = new boolean[fullLength]; // 로봇의 위치를 저장할 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < fullLength; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }
        while (kCnt < K) {
            processStep++;
            // 벨트 회전하는 메서드
            processRotation(durability, robot, dup, N, fullLength);
            // 로봇 이동하는 메서드
            moveRobots(durability, robot, N);
            // 로봇을 올리는 위치에 올리기
            if (durability[0] > 0 && !robot[0]) {
                robot[0] = true; // 로봇을 올리는 위치에 올림
                durability[0]--;
                if (durability[0] == 0) kCnt++;
            }
            // 내구도 0인 칸 체크
            kCnt = checkDurabilityCount(durability, kCnt, K);
            if (kCnt >= K) break;
        }
        System.out.println(processStep);
    }

    private static void processRotation(int[] durability, boolean[] robot, int[] dup, int N, int fullLength) {
        // 내구도 회전 (dup에 저장 후 복사)
        dup[0] = durability[fullLength - 1];
        for (int i = 1; i < fullLength; i++) {
            dup[i] = durability[i - 1];
        }
        for (int i = 0; i < fullLength; i++) {
            durability[i] = dup[i];
        }
        // 로봇 회전
        for (int i = N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false; // 올리는 위치는 로봇이 없으므로 false로 초기화
        robot[N - 1] = false; // 내리는 위치에 도달한 로봇은 내려야 함
    }

    private static void moveRobots(int[] durability, boolean[] robot, int N) {
        // 뒤에서부터 로봇을 이동
        for (int i = N - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && durability[i + 1] > 0) { // 로봇이 다음 칸으로 이동할 수 있으면
                robot[i] = false;
                robot[i + 1] = true;
                durability[i + 1]--;
            }
        }
        // 내리는 위치에 도달한 로봇은 내림
        robot[N - 1] = false;
    }

    // 내구도 0인 값 체크하는 메서드
    private static int checkDurabilityCount(int[] durability, int kCnt, int K) {
        kCnt = 0;
        for (int d : durability) {
            if (d == 0) {
                kCnt++;
            }
        }
        return kCnt;
    }
}
