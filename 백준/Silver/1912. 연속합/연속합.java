import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
       int n = Integer.parseInt(bf.readLine());

       String[] input = bf.readLine().split(" ");
       int[] numbers = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

       int[] dp = new int[n];
       dp[0] = numbers[0];
       for (int i=1; i < n; i++) {
           dp[i] = Math.max(dp[i-1] + numbers[i], numbers[i]);
       }

       int max = Integer.MIN_VALUE;
       for (int num : dp) {
           max = Math.max(max, num);
       }

        System.out.print(max);

        bf.close();
    }

}