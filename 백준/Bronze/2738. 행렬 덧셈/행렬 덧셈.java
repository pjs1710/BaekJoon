import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arrFirst = new int[N][M];
        int[][] arrSecond = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            int[] values = new int[data.length];
            for (int j = 0; j < data.length; j++) {
                values[j] = Integer.parseInt(data[j]);
            }

            for (int j = 0; j < M; j++) {
                arrFirst[i][j] = values[j];
            }
        }

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            int[] values = new int[data.length];
            for (int j = 0; j < data.length; j++) {
                values[j] = Integer.parseInt(data[j]);
            }

            for (int j = 0; j < M; j++) {
                arrSecond[i][j] = values[j];
            }
        }

        arrSum(arrFirst, arrSecond);
    }

    public static void arrSum(int[][] arrFirst, int[][] arrSecond) {
        int[][] sumArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sumArr[i][j] = arrFirst[i][j] + arrSecond[i][j];
                System.out.print(sumArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
