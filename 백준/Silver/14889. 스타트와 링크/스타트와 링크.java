import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] S;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideTeam(0, 0);
        System.out.println(minDiff);
    }

    public static void divideTeam(int index, int cnt) {
        if (cnt == N / 2) { // 팀 배정이 끝난거니까 차이의 최소를 계산하기 위해 calDiff로!
            calDiff();
            return;
        }

        for (int i = index; i < N; i++) { // 팀 배정을 위한 계산
            if (!visited[i]) {
                visited[i] = true;
                divideTeam(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void calDiff() {
        int startTeam = 0, linkTeam = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += S[i][j] + S[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += S[i][j] + S[j][i];
                }
            }
        }

        int diff = Math.abs(startTeam - linkTeam); // 차이값 계산
        minDiff = Math.min(minDiff, diff);
    }
}
