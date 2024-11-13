import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { //* 연산자 끼워넣기

    static int N;
    static int[] nums;
    static int[] opr;
    static int maxNum;
    static int minNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        opr = new int[4]; // 연산자 개수 담을 배열 0번째 : + / 1번째 : - / 2번째 : * / 3번째 : /
        maxNum = Integer.MIN_VALUE;
        minNum = Integer.MAX_VALUE;

        String[] numSplit = br.readLine().split(" "); // 연산 수행할 수들을 입력받아서 split 진행
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(numSplit[i]); // parsing해서 저장
        }

        String[] oprSplit = br.readLine().split(" "); // 연산자 개수를 입력받아서 split 진행
        for (int i = 0; i < 4; i++) {
            opr[i] = Integer.parseInt(oprSplit[i]); // parsing해서 저장
        }

        dfs(nums[0], 1);

        System.out.println(maxNum);
        System.out.println(minNum);
    }

    public static void dfs(int num, int index) {
        if (index == N) { // 마지막 수까지 다 연산 진행하면
            maxNum = Math.max(maxNum, num); // 최대값
            minNum = Math.min(minNum, num); // 최소값
            return; // 리턴해주기
        }

        for (int i = 0; i < 4; i++) { // 연산 수행 로직
            if (opr[i] > 0) { // 연산자 배열에 수행할 연산자가 1개 이상 있으면 연산 수행하기
                opr[i]--; // 연산자 1개 사용
                switch (i) {
                    case 0: // 인덱스가 덧셈에 해당될 때
                        dfs(num + nums[index], index + 1); break;
                    case 1: // 인덱스가 뺄셈에 해당될 때
                        dfs(num - nums[index], index + 1); break;
                    case 2: // 인덱스가 곱셈에 해당될 때
                        dfs(num * nums[index], index + 1); break;
                    case 3: // 인덱스가 나눗셈에 해당될 때
                        dfs(num / nums[index], index + 1); break;
                }
                opr[i]++; // 연산자 사용한 거 복구
            }
        }
    }
}
