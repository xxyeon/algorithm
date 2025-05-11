import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sb = new StringBuilder();

		String[] input = bf.readLine().split(" ");
		int time = Integer.parseInt(input[0]);
		int[] tree = new int[time+1];
		int w = Integer.parseInt(input[1]);

		for(int i =1; i < time+1; i++) {
			tree[i] = Integer.parseInt(bf.readLine());
		}
		int[][] dp = new int[time+1][w+1];
		for(int i =1; i < time+1; i++){
			for (int k = 0; k < w+1; k++) {
				int position = k % 2 == 1 ? 2 : 1; //k가 홀수이면 2번 나무에 있는것
				if(k==0) { //안움직이는 경우
					dp[i][k] = dp[i-1][k] + (tree[i] == position ? 1 : 0);
				} else {
					dp[i][k] = Math.max(dp[i-1][k-1], dp[i-1][k]) + (tree[i] == position ? 1 : 0);
				}
			}
		}
		//dp[time][0~w]중에서 max
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < w+1; i++) {
			max = Math.max(max, dp[time][i]);
		}
		System.out.print(max);
	}
}

