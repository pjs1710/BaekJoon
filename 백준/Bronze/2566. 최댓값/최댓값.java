import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[9][9];
    static int resultRow = 0;
    static int resultCol = 0;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        printMaxValue(board);
    }

    public static void printMaxValue(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] > max) {
                    max = board[i][j];
                    resultRow = i + 1;
                    resultCol = j + 1;
                }
            }
        }
        System.out.println(max + "\n" + resultRow + " " + resultCol);
    }
}
