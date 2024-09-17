import java.util.Scanner;
import java.util.Stack;

public class Main { // 옥상 정원 꾸미기 / for문으로 X (시간 초과) stack으로

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 빌딩의 개수
        long cnt = 0; // 벤치 마킹이 가능한 빌딩의 수 count
        Stack<Integer> stack = new Stack<>(); // 빌딩 높이 저장할 stack 초기화

        for (int i = 0; i < N; i++) {
            int h = sc.nextInt(); // 현재 입력받은 값을 h로 저장
            while (!stack.isEmpty() && stack.peek() <= h) { // 스택이 비어있지 않고, 제일 최근에 들어온 값이랑 현재 입력받은 값이랑 비교해서 h가 크면?
                stack.pop(); // 내가 있는 빌딩보다 다른 오른쪽에 빌딩이 더 크다는 얘기이므로 pop하기
            }
            cnt += stack.size(); // 스택 사이즈만큼 +
            stack.push(h); // h값 스택에 넣어주기
        }
        System.out.println(cnt);
    }
}
