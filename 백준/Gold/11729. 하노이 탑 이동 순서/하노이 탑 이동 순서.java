import java.io.*;
import java.util.*;

/**
 * 하노이 탑 이동 순서
 */

public class Main {

    static int N;
    static int cnt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 3, 2);
        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    public static void hanoi(int N, int from, int to, int tmp) {
        if (N == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            cnt++;
            return;
        }

        hanoi(N - 1, from, tmp, to);
        sb.append(from).append(" ").append(to).append("\n");
        cnt++;
        hanoi(N - 1, tmp, to, from);
    }
}
