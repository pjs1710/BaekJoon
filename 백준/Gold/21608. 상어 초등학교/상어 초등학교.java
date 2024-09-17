import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[][] map; // 자리 나타내는 배열
    static int[] dx = {-1, 1, 0, 0}; // 가로 세로 위 아래
    static int[] dy = {0, 0, -1, 1};
    static int N; // 3 <= N <= 20
    static HashMap<Integer, List<Integer>> stdPref = new HashMap<>(); // 학생과 해당 학생이 좋아하는 학생들의 번호를 담을 해쉬맵 선언

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N]; // 학생 자리 배열 만들고
        int stdNum = N*N; // 총 학생 수 정의

        for (int i = 0; i < stdNum; i++) { // 중복되지 않는 학생의 번호 입력 받기
            List<Integer> pref = new ArrayList<>(); // i번쨰 학생이 좋아하는 학생의 번호를 담을 ArrList 생성
            int std = sc.nextInt(); // i번째 학생
            for (int j = 0; j < 4; j++) {
                pref.add(sc.nextInt()); // i번째 학생이 좋아하는 학생의 번호를 pref List에 담기
            }
            stdPref.put(std, pref); // 최종적으로 HashMap에 i번째 학생과 해당 학생이 좋아하는 학생의 번호를 등록

            setSeat(std, pref); // 학생을 자리에 앉히기
        }
        System.out.println(totalStdSatisfaction());
    }

    // 자리 앉히는 setSeat 메서드
    private static void setSeat(int std, List<Integer> pref) {
        int X = -1; // 최종적으로 앉힐 자리의 X좌표
        int Y = -1; // Y좌표
        int maxLike = -1;
        int maxEmpty = -1;

        for (int x = 0; x < N; x++) { // 자리 배열 확인하기
            for (int y = 0; y < N; y++) {
                if (map[x][y] != 0) continue; // 해당 자리에 학생이 있으면 다음 단계로
                int likeCnt = 0, emptyCnt = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue; // 위치가 map 밖을 벗어나면 패스
                    if (map[nx][ny] == 0) {
                        emptyCnt++; // 빈 칸 카운트
                    } else if (pref.contains(map[nx][ny])) {
                        likeCnt++; // 좋아하는 학생 카운트
                    }
                }
                // 더 좋은 자리를 찾았는지 판단하는 조건
                // 카운트가 1이랑 2가 있으면 2 자리가 더 좋은 자리니까 2 자리를 선택해야함
                if (likeCnt > maxLike || (likeCnt == maxLike && emptyCnt > maxEmpty) ||
                        (likeCnt == maxLike && emptyCnt == maxEmpty && (x < X || (x == X && y < Y)))) {
                    X = x;
                    Y = y;
                    maxLike = likeCnt;
                    maxEmpty = emptyCnt;
                }
            }
        }
        // 최종적으로 선택된 자리에 학생 배치
        map[X][Y] = std;
    }

    // 학생의 총 만족도를 계산하는 메서드
    static int totalStdSatisfaction() {
        int sum = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int std = map[x][y];
                List<Integer> preferences = stdPref.get(std);
                int likeCnt = 0;
                // 인접한 4방향 탐색
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (preferences.contains(map[nx][ny])) {
                        likeCnt++;
                    }
                }
                // 만족도 계산
                if (likeCnt == 1) sum += 1; // 인접한 칸에 앉은 좋아하는 학생 수 1 -> 1 / 2 -> 10 / 3 -> 100 / 4 -> 1000
                else if (likeCnt == 2) sum += 10;
                else if (likeCnt == 3) sum += 100;
                else if (likeCnt == 4) sum += 1000;
            }
        }
        return sum;
    }
}
