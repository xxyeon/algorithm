import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
public class Main {
	private static final int[] dx = {0,0,-1,1};
	private static final int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sb = new StringBuilder();

		String[] input = bf.readLine().split(" ");
		int n = Integer.parseInt(input[0]); //x
		int m = Integer.parseInt(input[1]);

		int[][] graph = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			char[] line = bf.readLine().toCharArray();
			// Arrays.fill(visited[i], false);
			for (int j =0; j<m; j++) {
				graph[i][j] = line[j] - '0';
			}
		}

		int[] node = {0,0};
		bfs(node, graph, visited);

		System.out.print(graph[n-1][m-1]);
	}

	private static void bfs(int[] node, int[][] graph, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(node);
		visited[node[0]][node[1]] = true;
		while(!q.isEmpty()) {
			int[] n = q.poll();
			int x = n[0];
			int y = n[1];
			// visited[x][y] = true;

			for (int i=0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 > nx || nx >= graph.length || ny < 0 || ny >= graph[0].length) continue;

				if (graph[nx][ny] != 0 && !visited[nx][ny]) {
					// System.out.println(nx + " " + ny);
					int[] next = {nx, ny};
					graph[nx][ny] = graph[x][y] + 1;
					visited[nx][ny] = true;
					q.offer(next);

				}
			}
		}
	}
}

