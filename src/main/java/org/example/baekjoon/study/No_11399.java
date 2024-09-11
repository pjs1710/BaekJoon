package org.example.baekjoon.study;

import java.util.Arrays;
import java.util.Scanner;

public class No_11399 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int personNum = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] split1 = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            split1[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(split1);
        int sum = 0;
        for (int i = 0; i < personNum; i++) {
            for (int j = 0; j <= i; j++) {
                sum += split1[j];
            }
        }
        System.out.println(sum);
    }
}
