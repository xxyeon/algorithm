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
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static char[][] map;
	static int n;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		char[] color = {'R', 'G', 'B'};
		int count = 0;

		visited = new boolean[n][n];
		for (char c : color) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && map[i][j] == c) {
						//빨 초 파
						count++;
						bfs(i, j, c, false);

					}
				}

			}
		}
		visited = new boolean[n][n];
		int redGreenCount = 0;
		for (char c : color) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						if (c == 'B' && map[i][j] == c){
							redGreenCount++;
							bfs(i, j, c, true);
						} else if(map[i][j] != 'B' && (c =='R' || c=='G')){
							// System.out.println("x: " + i + " y: " + j);
							redGreenCount++;
							bfs(i, j, c, true);
						}
					}

				}
			}
		}
		System.out.print(count + " " + redGreenCount);
	}
	static void bfs ( int x, int y, char color, boolean isRedGreen){

		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		visited[x][y] = true;
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				if(!visited[nx][ny]) {
					if(isRedGreen) {
						if (map[nx][ny] != 'B' && (color == 'R' || color == 'G')) {
							q.offer(new Node(nx, ny));
							visited[nx][ny] = true;
						} else if (map[nx][ny] == color) {
							q.offer(new Node(nx, ny));
							visited[nx][ny] = true;
						}
					} else if(map[nx][ny] == color) {
						q.offer(new Node(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}

		}
	}
}

