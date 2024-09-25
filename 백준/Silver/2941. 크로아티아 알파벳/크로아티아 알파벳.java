import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] cAlphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String val : cAlphabet) {
            while (s.contains(val)) {
                s = s.replace(val, "A");
            }
        }
        System.out.println(s.length());
    }
}
