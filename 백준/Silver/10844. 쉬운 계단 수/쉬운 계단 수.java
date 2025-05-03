import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        int[][] dp = new int[n+1][10];
        // dp[1][0] = 1; //1자리 에서 0으로 시작하는 거 1로해주는 이유는 중간에 0이 들어갈 수 있으니까

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int k=2; k<n+1; k++) {
            for (int i = 0; i < 10; i++) {
                if (i > 0) dp[k][i] = (dp[k][i] + dp[k - 1][i - 1]) % 1000000000;
                if (i < 9) dp[k][i] = (dp[k][i] + dp[k - 1][i + 1]) % 1000000000;
            }
        }
        int answer = 0;
        for (int num:dp[n]) {
             answer = (answer + num) %1000000000;
        }
        // if (n == 1) {
        //     answer -= 1;
        // }
        System.out.print(answer);
        bf.close();
    }

}