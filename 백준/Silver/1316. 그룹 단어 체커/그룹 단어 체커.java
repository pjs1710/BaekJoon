import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = N;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int prev = 0;
            int[] alphabet = new int[26];
            for (int j = 0; j < str.length(); j++) {
                int now = str.charAt(j);
                if (prev != now) {
                    if (alphabet[now - 'a'] == 0) {
                        alphabet[now - 'a']++;
                        prev = now;
                    } else {
                        cnt--;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
