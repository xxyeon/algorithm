import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String number = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            char c = number.charAt(i);
            // 스택의 top보다 큰 수가 나오면 제거 (K번까지)
            while (!stack.isEmpty() && K > 0 && stack.peekLast() < c) {
                stack.pollLast();
                K--;
            }
            stack.addLast(c);
        }

        // 아직 제거 안 했으면 뒤에서 제거
        while (K-- > 0) stack.pollLast();

        // 출력
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        System.out.println(sb);
    }
}
