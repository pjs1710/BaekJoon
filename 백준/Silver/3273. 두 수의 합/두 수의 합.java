import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 수열의 크기
        int[] num = new int[n]; // 수를 담을 배열 == 수열
        int cnt = 0; // 순서쌍의 개수를 계산할 cnt 변수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine()); // 목표한 x값
        Arrays.sort(num); // 배열 정렬 후 투 포인터 시작
        int left = 0, right = n - 1;

        while (left < right) {
            int sum = num[left] + num[right];
            if (sum == x) { // 목표한 값이랑 두 수의 합이랑 동일
                right--;
                left++;
                cnt++;
            } else if (sum < x) { // 오름차순으로 정렬했기 때문에 왼쪽의 값을 ++해줘야함
                left++;
            } else {
                right--;
            }
        }
        System.out.println(cnt);
    }
}
