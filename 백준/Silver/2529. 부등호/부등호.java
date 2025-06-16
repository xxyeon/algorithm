import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int k;
	private static boolean[] visited = new boolean[10];
	private static String[] op;
	private static String min = "9999999999"; // 초기값: 가장 큰 값
	private static String max = "0";          // 초기값: 가장 작은 값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		op = br.readLine().split(" ");

		dfs(0, "");

		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int depth, String result) {
		if (depth == k + 1) {
			if (min.compareTo(result) > 0) min = result;
			if (max.compareTo(result) < 0) max = result;
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (!visited[i]) {
				if (depth == 0 || isValid(result.charAt(depth - 1) - '0', i, op[depth - 1])) {
					visited[i] = true;
					dfs(depth + 1, result + i);
					visited[i] = false;
				}
			}
		}
	}

	private static boolean isValid(int a, int b, String oper) {
		if (oper.equals("<")) return a < b;
		if (oper.equals(">")) return a > b;
		return false;
	}
}
