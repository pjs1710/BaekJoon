import java.io.*;
import java.util.*;

// 가장 효율적인 최종 버전
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] A = new int[N];
        int[] B = new int[N];
        
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        // 해결
        System.out.println(canReachTarget(A, B, N));
    }
    
    static int canReachTarget(int[] A, int[] B, int N) {
        // 초기 상태 확인
        if (isEqual(A, B)) return 1;
        
        // 현재 각 값의 위치를 추적하는 맵
        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i < N; i++) {
            position.put(A[i], i);
        }
        
        // A를 정렬하여 각 단계에서 가장 큰 값을 미리 계산
        int[] sortedValues = A.clone();
        Arrays.sort(sortedValues);
        
        // 선택 정렬 시뮬레이션
        for (int last = N - 1; last > 0; last--) {
            int maxValue = sortedValues[last];  // 현재 단계의 최댓값
            int maxPos = position.get(maxValue);  // 최댓값의 현재 위치
            
            // 교환이 필요한 경우
            if (last != maxPos) {
                // 교환 수행
                int temp = A[last];
                A[last] = A[maxPos];
                A[maxPos] = temp;
                
                // 위치 맵 업데이트
                position.put(A[maxPos], maxPos);
                position.put(A[last], last);
                
                // B와 같은지 확인
                if (isEqual(A, B)) return 1;
            }
        }
        
        return 0;
    }
    
    static boolean isEqual(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}