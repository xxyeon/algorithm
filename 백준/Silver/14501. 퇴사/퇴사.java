import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        int[][] schedule = new int[n][2];
       for (int i=0; i < n; i++) {
           int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
           schedule[i][0] = input[0];
           schedule[i][1] = input[1];
       }

       int[] dp = new int[n];

       if (schedule[n-1][0] > 1) dp[n-1] = 0;
       else if (schedule[n-1][0] == 1) dp[n-1] = schedule[n-1][1];

       for (int i=n-2; i >= 0; i--) {
           if (i + schedule[i][0] > n) { //상담이 끝나는 날이 퇴사날 이후라면
               dp[i] = dp[i + 1];
               continue;
           }
           if (i + schedule[i][0] == n) {
               dp[i] = Math.max(schedule[i][1], dp[i+1]);
               continue;
           }
           dp[i] = Math.max(schedule[i][1] + dp[i+schedule[i][0]], dp[i+1]);
       }
        System.out.print(dp[0]);

        bf.close();
    }

}