import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int[][] skill = new int[11][11];
	private static boolean[] player = new boolean[11];
	private static boolean[] position = new boolean[11];
	private static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int test = Integer.parseInt(br.readLine());
		for(int k=0;k<test; k++) {
			max = 0;
			for(int i=0; i < 11; i++) {
				skill[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			dfs(max, 0);
			sb.append(max).append('\n');

		}
		System.out.print(sb.toString());
	}

	private static void dfs(int result, int index) {
		if(index == 11) max = Math.max(max, result);
		for(int i=0; i<11; i++) { //선수와 포지션

			if (player[i] || skill[i][index] == 0 || position[index]) continue;

			player[i] =  true;
			position[index] = true; //포지션 할당
			dfs(result + skill[i][index], index+1);
			position[index] = false;
			player[i] =  false;
			}

		}


}