package org.example.baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num_3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int King = 1;
        int Queen = 1;
        int Rook = 2;
        int Bishop = 2;
        int Knight = 2;
        int Pawn = 8; // 기본 체스 세팅

        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 공백을 기준으로 토큰 나누기

        King = King - Integer.parseInt(st.nextToken());
        Queen = Queen - Integer.parseInt(st.nextToken());
        Rook = Rook - Integer.parseInt(st.nextToken());
        Bishop = Bishop - Integer.parseInt(st.nextToken());
        Knight = Knight - Integer.parseInt(st.nextToken());
        Pawn = Pawn - Integer.parseInt(st.nextToken());

        System.out.println(King + " " + Queen + " " + Rook + " " + Bishop + " " + Knight + " " + Pawn + " ");
    }
}
