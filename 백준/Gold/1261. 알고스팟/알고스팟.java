import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] dist;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	static class Node implements Comparable<Node> {
		int x, y, cost;
		Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);

		map = new int[N][M];
		dist = new int[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(0, 0, 0));
		dist[0][0] = 0;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					int newCost = dist[cur.x][cur.y] + map[nx][ny];
					if (dist[nx][ny] > newCost) {
						dist[nx][ny] = newCost;
						q.offer(new Node(nx, ny, newCost));
					}
				}
			}
		}

		System.out.println(dist[N - 1][M - 1]);
	}
}
