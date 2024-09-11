package org.example.baekjoon.study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No_13335 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("트럭의 수, 다리의 길이, 최대 하중을 입력하세요 : ");
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int truckNum = Integer.parseInt(s1[0]); // 트럭의 수
        int bridgeLength = Integer.parseInt(s1[1]); // 다리의 길이
        int maxWeight = Integer.parseInt(s1[2]); // 최대 하중
        int[] truck = new int[truckNum]; // 트럭 무게를 저장할 int형 배열

        System.out.print("트럭의 무게를 입력하세요 : ");
        String truckWeight = sc.nextLine();
        String[] split = truckWeight.split(" ");

        for (int i = 0; i < truckNum; i++) {
            truck[i] = Integer.parseInt(split[i]); // 트럭의 무게를 truck 배열에 입력 순서대로 저장
        }

        Queue<Integer> bridge = new LinkedList<>(); // 다리 지나는 걸 Queue로 나타내기
        int bridgeWeight = 0; int timeCnt = 0; int truckIndex = 0; // 현재 다리에 가해지는 무게 : bridgeWeight, 단위시간 count : timeCnt, 지나가는 트럭의 index : truckIndex

        for (int i = 0; i < bridgeLength; i++) { // 큐에 0으로 채우기
            bridge.add(0);
        }

        while (!bridge.isEmpty() || truckIndex < truckNum) { // 큐가 끝날 때까지
            timeCnt++; // 처음에 시간 추가
            bridgeWeight -= bridge.poll(); // 정상적으로 로직 성공할 때마다 큐에서 하나 빼기

            if (truckIndex < truckNum) { // 다리에 올린 트럭이 아직 안 지나감
                if (bridgeWeight + truck[truckIndex] <= maxWeight) { // 다리 위에 있는 무게 + 다음에 들어올 트럭의 무게 합이 최대 하중을 견디면?
                    bridge.add(truck[truckIndex]); // 큐에 다음에 들어올 트럭도 추가해주기
                    bridgeWeight += truck[truckIndex]; // 합 계산
                    truckIndex++; // 다음에 들어올 트럭 대기
                } else {
                    bridge.add(0); // 최대 하중을 못 견디면 0을 추가해서 다리 위에 트럭이 지나갈 때까지 대기
                }
            }
        }

        System.out.println("최단 시간 : " + timeCnt);
    }
}
