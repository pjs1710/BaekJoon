import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { //* 수 찾기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder(); // 결과 저장
        int N = Integer.parseInt(br.readLine());
        int[] arr_N = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr_N[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr_N); // Binary Search를 위해서 오름차순 정렬

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int k = Integer.parseInt(st.nextToken()); // 비교할 숫자를 담을 변수
            int i1 = Arrays.binarySearch(arr_N, k); // 이진 탐색으로 arr_N 배열에 k가 존재하는 지 검색한 결과를 i1
            // binarySearch func은 찾으면 0이상 정수 못찾으면 음수 반환!

            if (i1 >= 0) {
                sb.append(1 + "\n"); // 존재하는 경우
            } else {
                sb.append(0 + "\n"); // 존재하지 않는 경우
            }
        }
        System.out.println(sb); // StringBuilder에 담긴 내용 한번에 출력
    }
}
