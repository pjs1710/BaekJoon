import java.io.*;
import java.util.*;

/**
 * 백준 23900 : 알고리즘 수업 - 선택 정렬 6
 */

public class Main {

    static int N;
    /**
     * A, B : 원본 배열
     */
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(canReachTarget(A, B, N));
    }

    // 핵심 로직 메서드
    public static int canReachTarget(int[] A, int[] B, int N) {
        if (Arrays.equals(A, B)) { // 초기 상태부터 같다면 1 return
            return 1;
        }

        /**
         * A 배열의 값의 위치를 추적하는 Map
         */
        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i < N; i++) {
            position.put(A[i], i);
        }

        // A를 정렬하여 각 단계에서 가장 큰 값을 미리 계산
        int[] sortedA = A.clone();
        Arrays.sort(sortedA);

        // 선택 정렬 시작
        for (int last = N - 1; last > 0; last--) {
            int maxValue = sortedA[last];  // 마지막 인덱스부터 시작이니까 정렬된 sortedA[last]는 배열의 최댓값
            int maxPosition = position.get(maxValue);  // 최댓값의 현재 위치

            // swap이 필요한 경우
            if (last != maxPosition) {
                // swap 해주기
                int temp = A[last];
                A[last] = A[maxPosition];
                A[maxPosition] = temp;

                // swap 했으니 바뀐 위치를 추적하기 위해 Map 업데이트
                position.put(A[maxPosition], maxPosition);
                position.put(A[last], last);

                // 업데이트 후 A와 B가 같은지 확인
                if (Arrays.equals(A, B)) {
                    return 1;
                }
            }
        }

        // for-loop을 빠져나와도 return이 되지 않았으면 같아질 수 없는 배열임
        return 0;
    }
}