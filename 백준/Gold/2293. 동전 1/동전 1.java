import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sb = new StringBuilder();

		String[] input = bf.readLine().split(" ");
		int kind = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int[] coins = new int[kind];
		int[] dp = new int[k+1];
		dp[0] = 1;

		for (int i = 0; i < kind; i++) {
			coins[i] = Integer.parseInt(bf.readLine());
		}
		for(int coin : coins) {
			for (int i = coin; i < k+1; i++) {
				dp[i] += dp[i-coin];
			}
		}
		// for (int num : dp[k]) {
		// 	System.out.println(num);
		// }
		System.out.print(dp[k]);
	}
}

