import java.io.*;
import java.util.Arrays;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sb = new StringBuilder();

		String[] input = bf.readLine().split(" ");
		int c = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);

		int[] dp = new int[c+101]; // 한번 홍보할 때 얻을 수 있는 고객의 수는 100이 최대, 100명을 한번 유치하는 경우가 있음
		Arrays.fill(dp, 987654321); //Integer.MAX_VALUE로 하면 Integer.MAX_VALUE + cost → 오버플로우 발생!
		dp[0] = 0; //맨처음에 dp[0] + dp[people] 을 하므로 dp[0]은 0으로 초기화해줘야함.
		for(int i = 0; i < n; i++) {
			String[] info = bf.readLine().split(" ");
			int cost = Integer.parseInt(info[0]);
			int people = Integer.parseInt(info[1]);
			for(int j = people; j < c+101; j++) {
				dp[j] = Math.min(dp[j - people] + cost, dp[j]);
			}
		}

		int answer = Integer.MAX_VALUE;
		for(int i = c; i < c+101; i++) {
			answer = Math.min(answer, dp[i]);
		}
		System.out.print(answer);
	}
}

