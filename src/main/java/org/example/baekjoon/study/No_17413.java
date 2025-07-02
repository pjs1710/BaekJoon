package org.example.baekjoon.study;

import java.io.*;
import java.util.*;

/**
 * 단어 뒤집기 2
 */

public class No_17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        reverseString(S);
    }

    public static void reverseString(String S) {
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean tag = false;

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (ch == '<') {
                result.append(word.reverse()); // 단어 뒤집어서 추가 -> 이 전에 단어가 그냥 나왔을 수도 있으니 먼저 처리해주기
                word.setLength(0);
                tag = true; // '<'를 만났기 때문에 해당 tag 안에서는 단어를 뒤집으면 안됨.
                result.append(ch);
            } else if (ch == '>') {
                tag = false; // '>' 빠져나왔기 때문에 이제 단어 나오면 뒤집어야 함.
                result.append(ch);
            } else if (tag) { // tag 인데 '<'나 '>'를 만나지 않았다는 것은 단어를 만난 거임
                result.append(ch); // tag 안이므로 그대로 추가해주기!
            } else { // 태그 밖에서 단어는 reverse
                if (ch == ' ') {
                    result.append(word.reverse()).append(' ');
                    word.setLength(0);
                } else {
                    word.append(ch); // word에 담아놓기
                }
            }
        }
        result.append(word.reverse()); // 마지막에 문자 처리
        System.out.println(result);
    }
}
