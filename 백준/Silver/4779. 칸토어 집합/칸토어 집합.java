import java.io.*;
import java.util.*;

/**
 * 백준 4779번 : 칸토어 집합
 */

public class Main {

    /**
     * 핵심 재귀 로직
     * @param arr : 문자 배열
     * @param start : 시작 인덱스 위치
     * @param size : 구간 길이
     */
    public static void getCantor(char[] arr, int start, int size) {
        if (size == 1) {
            return;
        }
        int part = size / 3;

        for (int i = start + part; i < start + part * 2; i++) { // 가운데 1/3은 공백으로 바꿔야함 -> 사이즈가 9라면 4 ~ 6은 공백
            arr[i] = ' '; // 해당 부분엔 공백으로
        }

        getCantor(arr, start, part); // 왼쪽 1/3 칸토어 재귀 -> 9라면 1 ~ 3
        getCantor(arr, start + part * 2, part); // 오른쪽 -> 9라면 7 ~ 9
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {
            if (input.equals("")) {
                continue;
            }

            int N = Integer.parseInt(input);
            int size = (int) Math.pow(3, N);

            char[] arr = new char[size];
            Arrays.fill(arr, '-');

            getCantor(arr, 0, size);

            System.out.println(new String(arr));
        }
    }
}
