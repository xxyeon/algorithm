import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        String start = "";
        for (int i = 0; i < k; i++) start += (char) ('A' + i);
        char[] result = br.readLine().toCharArray();

        String[] ladder = new String[n];
        int unknown = 0;

        for (int i = 0; i < n; i++) {
            ladder[i] = br.readLine();
            if (ladder[i].charAt(0) == '?') unknown = i;
        }

        char[] top = start.toCharArray();
        char[] bottom = result.clone();

        // 1️⃣ 위쪽에서 ? 전까지
        for (int i = 0; i < unknown; i++) {
            for (int j = 0; j < k - 1; j++) {
                if (ladder[i].charAt(j) == '-') {
                    char tmp = top[j];
                    top[j] = top[j + 1];
                    top[j + 1] = tmp;
                }
            }
        }

        // 2️⃣ 아래쪽에서 ? 이후 거꾸로
        for (int i = n - 1; i > unknown; i--) {
            for (int j = 0; j < k - 1; j++) {
                if (ladder[i].charAt(j) == '-') {
                    char tmp = bottom[j];
                    bottom[j] = bottom[j + 1];
                    bottom[j + 1] = tmp;
                }
            }
        }

        // 3️⃣ ? 채우기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            if (top[i] == bottom[i]) sb.append('*');
            else if (top[i] == bottom[i + 1] && top[i + 1] == bottom[i]) {
                sb.append('-');
                // swap
                char tmp = top[i];
                top[i] = top[i + 1];
                top[i + 1] = tmp;
            } else {
                // 불가능한 경우
                for (int j = 0; j < k - 1; j++) sb.append('x');
                System.out.println(sb);
                return;
            }
        }

        System.out.println(sb);
    }
}
