package org.example.baekjoon.study;

import java.io.*;
import java.util.*;

/**
 * 백준 34033 : 공금 횡령
 *
 */

public class No_34033 {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 물품 수
        M = Integer.parseInt(st.nextToken()); // 거래 내역 수

        Map<String, Integer> priceHashMap = new HashMap<>();

        // 물품이랑 정가 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String itemName = st.nextToken();
            int price = Integer.parseInt(st.nextToken());
            priceHashMap.put(itemName, price);
        }

        int suspiciousCnt = getSuspiciousCnt(br, priceHashMap);

        System.out.println(suspiciousCnt);
    }

    public static int getSuspiciousCnt(BufferedReader br, Map<String, Integer> priceHashMap) throws IOException {
        StringTokenizer st;
        int suspiciousCnt = 0; // 횡령이 의심되는 수 => 결과로 출력할 값

        // 검사하는 로직
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String itemName = st.nextToken();
            int transactionPrice = Integer.parseInt(st.nextToken()); // 거래할 가격

            int officialPrice = priceHashMap.get(itemName); // 물품에 해당하는 정가를 HashMap에서 가져옴

            // 105% 초과 체크
            if (transactionPrice > officialPrice * 105 / 100) { // 비교해서 의심되면 suspiciousCnt + 1
                suspiciousCnt++;
            }
        }
        return suspiciousCnt;
    }
}
