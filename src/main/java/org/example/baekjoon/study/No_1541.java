package org.example.baekjoon.study;

import java.io.*;
import java.util.*;

/**
 * 백준 1541 : 잃어버린 괄호
 */

public class No_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split("-");
        int result = sum(data[0]);
        /**
         * 만약에 data가 "-"가 없는 데이터라면 ex. 10+20+30
         * 해당 전체 문자열이 data[0]이고 이를 sum 메서드 실행에 사용되는 파라미터로 받아짐
         * 10, 20, 30이 splitNumbers로 들어가게 되고 이 값을 sum후 return
         */
        for (int i = 1; i < data.length; i++) {
            result -= sum(data[i]);
        }

        System.out.println(result);
    }

    public static int sum(String numData) {
        String[] splitNumbers = numData.split("\\+");
        int total = 0;
        for (String number : splitNumbers) {
            total += Integer.parseInt(number);
        }
        return total;
    }
}
