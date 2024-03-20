package org.example.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Num_10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int [] a = new int[N];
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            a[i] = i + 1;
        } // 바구니 순서대로 번호 지정 1 - 1 , 2 - 2 , ...
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken()); // 왼쪽부터 I번째 바구니 선택
            int J = Integer.parseInt(st.nextToken()); // J번째 바구니 선택
            change(a, I, J); // change 함수로 a배열의 I번째 바구니부터 J번째 바구니까지의 순서를 역순으로 변환
        }
        for (int i = 0; i < N; i++){
            System.out.print(a[i] + " "); // 배열 출력
        }
        br.close();
    }
    public static void change(int arr[], int start, int end) {
        int tmp, size = ((end - start) + 1) / 2; // tmp는 순서를 바꿀 때 필요한 빈 공간, size는 순서를 바꿀 횟수 ex) end : 4번째 바구니 , start : 1번째 바구니 > 4 - 1 + 1 / 2 = 2번 반복 (1,4),(2,3) 교환
        for (int i = 0; i < size; i++) {
            tmp = arr[start - 1 + i]; // tmp에 순서를 바꿀 배열 값 담기
            arr[start - 1 + i] = arr[end - 1 - i]; // 두 배열의 순서 바꾸기
            arr[end - 1 - i] = tmp; // a[1] = a[4] , a[2] = a[3] 이런 식으로 i가 증가할 때마다 start는 +, end는 -
        }
    }
}
