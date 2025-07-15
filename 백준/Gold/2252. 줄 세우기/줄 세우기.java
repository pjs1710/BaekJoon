import java.io.*;
import java.util.*;

/**
 * 백준 2252번 : 줄 세우기
 */

public class Main {

    static int N; // 1 ~ 32,000
    static int M; // 1 ~ 100,000
    static List<List<Integer>> graph;
    static int[] front_count; // 앞에 있는 사람의 수
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        front_count = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B); // A가 B 앞에 서야 함. A -> B
            front_count[B]++; // 현재 B 앞에 1명 추가됨
        }

        /**
         * 1 3, 2 3 예시의 경우 front_count가 0 0 2이므로 1 2 3 혹은 2 1 3 출력
         * front_cnt가 0인 데이터만 아무렇게나 출력한 뒤 0이 되면 그 때 출력
         * -> queue 사용 -> queue, BFS 사용
         */

        topologicalSort();
    }

    public static void topologicalSort() {
        queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (front_count[i] == 0) { // 0인 데이터면
                queue.offer(i); // 큐에 추가
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll(); // 0인 데이터 꺼내서
            sb.append(cur).append(" "); // 추가
            for (int next : graph.get(cur)) {
                // cur 데이터를 앞에 뒀기 때문에 front_count는 -1 해줘야 함
                front_count[next]--;
                if (front_count[next] == 0) { // 제거 후 0이라면
                    queue.offer(next); // 큐에 추가
                }
            }

        }
        System.out.println(sb.toString().trim());
    }
}
