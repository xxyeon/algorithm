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
	static int max = 0;
	static int[][] map;
	static int[] dx = new int[] {1, -1, 0, 0};
	static int[] dy = new int[] {0,0,1,-1};
	static int n, m;
	static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		m = Integer.parseInt(input[0]); //가로y
		n = Integer.parseInt(input[1]);
		map = new int[n][m];
		ArrayList<Node> info = new ArrayList<>();
		for(int i=0;i <n; i++){
			int[] tomato = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int j=0; j<m; j++) {
				if(tomato[j] == 1)
					// info.add(new Node(i, j));
					q.offer(new Node(i, j));
				map[i][j] = tomato[j];
			}
		}
		// for (Node node : info) {
		// 	bfs(node.x, node.y);
		// }
		bfs();
		//map에서 최대값
		for(int[] row : map) {
			for(int cell : row) {
				if (cell == 0) {
					System.out.print(-1);
					return;

				}
				max = Math.max(max, cell);
			}
		}

		System.out.print(max - 1);


    }
	public static void bfs() {
		// Queue<Node> q = new LinkedList<>();
		// q.offer(new Node(x, y));
		while(!q.isEmpty()){
			Node now = q.poll();
			for(int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(nx < 0 || nx >= n || ny <0 || ny >= m) continue;
				if(map[nx][ny] == 0) {
					map[nx][ny] = map[now.x][now.y] + 1;
					q.offer(new Node(nx, ny));
					continue;
				}
				if (map[nx][ny] != -1 && map[nx][ny] != 1 && map[nx][ny] > map[now.x][now.y] + 1 ) {
					map[nx][ny] = map[now.x][now.y] + 1;
					q.offer(new Node(nx, ny));
				}
			}
			//인접한 토마토 큐에 넣은 상태

		}
	}
	//https://www.acmicpc.net/board/view/141637
}
