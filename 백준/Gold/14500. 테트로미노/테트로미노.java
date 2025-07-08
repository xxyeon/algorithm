import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] map;
	static int n, m;
	static boolean[][] visited;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		visited = new boolean[n][m];
		map = new int[n][m];
		for(int i=0; i<n;i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		for(int i=0; i<n;i++) {
			for(int j=0; j<m; j++) {
				dfs(i, j, 0, 0);
			}
		}
		System.out.print(max);
	}
	private static void dfs(int x, int y, int depth, int sum) {
		if (depth == 4) {
			max = Math.max(sum, max);
			return;
		}
		for(int i =0;i <4 ;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 > nx || nx >= n || ny < 0 || ny >= m) {
				continue;
			}
			if (!visited[nx][ny]) {
				if(depth == 2) {
					visited[nx][ny] = true;
					dfs(x, y, depth + 1, sum + map[nx][ny]);
					visited[nx][ny] = false;
				}
				visited[nx][ny] = true;
				dfs(nx, ny, depth + 1, sum + map[nx][ny]);
				visited[nx][ny] = false;
			}
		}
	}

}

