import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
	int x, y;
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int N, M, K;
	static boolean[][] visited;
	static int[][] map;
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			K = Integer.parseInt(input[2]);
			visited = new boolean[N][M];
			map = new int[N][M];
			for (int num = 0; num < K; num++) {
				String[] pos = br.readLine().split(" ");
				int x = Integer.parseInt(pos[0]);
				int y = Integer.parseInt(pos[1]);
				map[x][y] = 1;
			}
			int count = 0;
			for(int row=0; row < N; row++) {
				for(int col=0; col < M; col++) {
					if (!visited[row][col] && map[row][col] == 1) {
						bfs(row, col);
						count++;
					}

				}
			}
			sb.append(count).append('\n');
		}
		System.out.print(sb.toString());
    }
	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		while(!q.isEmpty()) {
			Node now = q.poll();
			for(int i=0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				if (!visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					q.offer(new Node(nx, ny));
				}
			}
		}
	}
}
