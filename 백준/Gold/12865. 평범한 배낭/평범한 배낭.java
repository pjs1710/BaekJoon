import java.io.*;
import java.util.*;

/**
 * 평범한 배낭
 *
 */

public class Main {

    static class BackPack {
        int w; // 무게
        int v; // 가치

        public BackPack(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<BackPack> backPackList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken()); // 무게
            int V = Integer.parseInt(st.nextToken()); // 가치

            backPackList.add(new BackPack(W, V));
        }

        int[] dp = new int[K + 1];

        for (BackPack item : backPackList) {
            for (int weight = K; weight >= item.w; weight--) { // 역순으로 조회!
                /**
                 * 현재 무게(weight)에서 가능한 최대 가치를 계산
                 * 1. 현재 item을 넣지 않았을 때의 최대 가치 : dp[weight]
                 * 2. 현재 item을 넣었을 때의 최대 가치 : dp[weight - item.w] + item.v
                 * 두 경우 중 더 큰 값을 선택해서 dp[weight]에 업데이트
                 */
                dp[weight] = Math.max(dp[weight], dp[weight - item.w] + item.v);
            }
        }
        System.out.println(dp[K]);
    }
}