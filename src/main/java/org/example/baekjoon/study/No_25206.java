package org.example.baekjoon.study;

import java.io.IOException;
import java.util.Scanner;

public class No_25206 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] subject = new String[20];
        double[] score = new double[20];
        String[] grade = new String[20];
        double sum = 0;
        double cnt = 0;
        for (int i = 0; i < 20; i++) {
            String[] split = sc.nextLine().split(" ");
            subject[i] = split[0];
            score[i] = Double.parseDouble(split[1]);
            grade[i] = split[2];
        }

        for (int i = 0; i < 20; i++) {
            if (!grade[i].equals("P")) {
                if (grade[i].equals("A+")) {
                    sum += score[i] * 4.5;
                    cnt += score[i];
                } else if (grade[i].equals("A0")) {
                    sum += score[i] * 4.0;
                    cnt += score[i];
                } else if (grade[i].equals("B+")) {
                    sum += score[i] * 3.5;
                    cnt += score[i];
                } else if (grade[i].equals("B0")) {
                    sum += score[i] * 3.0;
                    cnt += score[i];
                } else if (grade[i].equals("C+")) {
                    sum += score[i] * 2.5;
                    cnt += score[i];
                } else if (grade[i].equals("C0")) {
                    sum += score[i] * 2.0;
                    cnt += score[i];
                } else if (grade[i].equals("D+")) {
                    sum += score[i] * 1.5;
                    cnt += score[i];
                } else if (grade[i].equals("D0")) {
                    sum += score[i] * 1.0;
                    cnt += score[i];
                } else {
                    cnt += score[i];
                }
            }
        }
        double result = sum / cnt;
        System.out.println(result);
    }
}
