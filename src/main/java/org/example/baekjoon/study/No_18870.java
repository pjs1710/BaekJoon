package org.example.baekjoon.study;

import java.io.*;
import java.util.*;

/**
 * 백준 18870 : 좌표 압축
 */

public class No_18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] X = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        /**
         * 입력 받은 값 배열에 저장하기
         */
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }

        int[] copyX = X.clone(); // 최종적으로 좌표 압축 후 출력할 배열 선언
        Arrays.sort(copyX);

        List<Integer> uniqueList = new ArrayList<>();
        /**
         * 핵심 로직 :
         * 중복된 데이터들을 골라내는 과정 -> 정렬된 배열이므로 중복된 데이터들을 골라내면 작은 값부터 순서대로 인덱싱이 되어있음.
         * ex) [-10, -9, 2, 4, 4] -> [-10, -9, 2, 4] 이렇게 uniqueList에 추가될 것.
         * 추가된 후 해당 값이 있는 원본 X 배열에 uniqueList의 인덱스 값을 바꿔주거나 바로 출력하면 된다!
         */
        uniqueList.add(copyX[0]);
        for (int i = 1; i < N; i++) {
            if (copyX[i] != copyX[i - 1]) {
                uniqueList.add(copyX[i]);
            }
        }

        for (int x : X) {
            /**
             * 강의에서 배운 Collections에 있는 메서드를 활용하여 uniqueList와 X 배열에 있는 x 값을 비교하며 해당 값이 있는 지 확인
             */
            int idx = Collections.binarySearch(uniqueList, x);
            sb.append(idx).append(" ");
        }
        System.out.println(sb.toString());
    }
}
