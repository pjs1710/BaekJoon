import java.io.*;
import java.util.*;

/**
 * 백준 11866 : 요세푸스 문제 0
 */

public class Main {

    static Queue<Integer> queue;
    static Queue<Integer> josephus;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) { // 문제에서 제시한 1부터 초기화
            queue.add(i);
        }
        josephus = new LinkedList<>();

        int cnt = 1; // K를 만족할 때까지 cnt를 ++해주기
        while (!queue.isEmpty()) {
            if (cnt == K) {  // K번 째에 도달했다면 queue에 있는 K번째 사람을 제거하고 결과를 도출할 요세푸스 큐에 추가하기
                josephus.offer(queue.poll());
                cnt = 1; // 도달했으니 다시 cnt는 1로 초기화
            } else {
                queue.offer(queue.poll()); // K번 째에 도달하기 전이면 값을 꺼내서 뒤에 넣기
                cnt++; // 다시 넣었으니 cnt ++
            }
        }

        // 결과는 <3, 6, 2, 7, 5, 1, 4> 형태로 출력 -> StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (josephus.size() > 1) { // 사이즈가 1이 되면 마지막 출력문에서 ", "를 빼주고 ">"를 붙여줘야 함
            sb.append(josephus.poll()).append(", ");
        }
        sb.append(josephus.poll()).append(">");

        System.out.println(sb.toString());
    }
}