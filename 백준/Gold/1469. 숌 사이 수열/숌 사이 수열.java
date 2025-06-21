import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static boolean[] visited;
	private static int[] arr, num;
	private static int n;
	private static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[2*n];
		Arrays.fill(num, -1); //0부터 16까지이므로
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		visited = new boolean[n];
		Arrays.sort(arr);
		dfs(0);
		if(sb.length() == 0)
			sb.append(-1);
		System.out.println(sb.toString());
	}

	private static void dfs(int depth) {

		if(sb.length() != 0) {
			//이조건을 안걸어주면 모든 숌 사이의 수열이 sb에 들어감. 따라서 맨 처음에 만들어진 수열만 출력되도록
			return;
		}

		if(depth == 2*n) {
			for(int n : num) {
				sb.append(n).append(" ");
			}
			return;
		}

		if(num[depth] != -1) {
			dfs(depth+1);//숌사이의 수열을 만족한 값이 들어가 있음
			return;
		}
		for(int i=0; i<n; i++) {
			int next =  arr[i];
			if(!visited[i] && depth + next + 1 < 2*n && num[depth] == -1 && num[depth + next + 1] == -1) {
				num[depth] = next;
				num[depth + next + 1] = next;
				visited[i] = true; //arr[i]: i번째 visited
				dfs(depth+1);
				num[depth] = -1;
				num[depth + next + 1] = -1;
				visited[i] = false;
			}
		}
	}

}