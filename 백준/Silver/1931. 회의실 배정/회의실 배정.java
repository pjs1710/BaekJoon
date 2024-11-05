import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] time = new int[N][2]; // N은 크기 , 2는 시작시간과 종료시간

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간 저장할 배열
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간 저장할 배열
        }
        Arrays.sort(time, (o1, o2) -> { // 시간 배열 정렬해주기 (종료 시간 기준으로)
            if (o1[1] == o2[1]) { // 종료 시간이 같은 두 배열에 대한 람다 표현식 처리
                return o1[0] - o2[0]; // 시작 시간을 기준으로 오름차순 => (1,5)랑 (0,5)가 있으면 리턴값은 (0,5), (1,5)
            }
            return o1[1] - o2[1]; // 종료 시간을 기준으로 오름차순 => (같지 않은 경우니까 종료시간이 낮은 순서부터 높은 순서까지 정렬) => (1,2), (1,4), (2,6) ... 겹쳐도 상관 X
        });

        int cnt = 0; // 겹치지 않게끔 최대 회의의 개수를 담을 변수
        int end = 0; // 종료 시간 값을 담을 변수

        for (int i = 0; i < N; i++) {
            if (end <= time[i][0]) { // 종료시간보다 시작시간이 더 큰 경우 => 시간의 비교에서는 이미 종료되었고 다음 회의를 시작할 수 있다는 뜻임.
                end = time[i][1]; cnt++; // i번째에 해당하는 종료 시간을 end로 설정
            }
        }
        System.out.println(cnt);
    }
}
