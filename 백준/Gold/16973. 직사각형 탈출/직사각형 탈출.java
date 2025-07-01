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
	static int N, M;
	static int[][] map;
	static int H, W, fx, fy, sx,sy;
	static int[] dx = new int[] {0, 0, 1, -1};
	static int[] dy = new int[] {1,-1,0,0};
	static HashSet<Node> one = new HashSet<>();
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int idx = 0; idx < M; idx++) {
				if (map[i][idx] == 1) {
					one.add(new Node(i, idx));
				}
			}
		}
		String[] last = br.readLine().split(" ");
		H = Integer.parseInt(last[0]);
		W = Integer.parseInt(last[1]);
		sx = Integer.parseInt(last[2]);
		sy = Integer.parseInt(last[3]);
		fx = Integer.parseInt(last[4]);
		fy = Integer.parseInt(last[5]);

		bfs(sx - 1, sy - 1);
		int answer = map[fx - 1][fy - 1] == 0 ? -1 : map[fx - 1][fy - 1]-1;
		System.out.print(answer);


    }
	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		map[x][y] = 1;
		while (!q.isEmpty()) {
			Node now = q.poll();
			for(int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx == fx - 1 && ny == fy - 1) {
					map[nx][ny] = map[now.x][now.y] + 1;
					return;
				}
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || nx + H-1 >= N || ny + W-1 >= M) {
					continue;
				}
				if(map[nx][ny] == 0) { //시작점을 옮길 수 있다면
					boolean contain = false;
					for (Node node : one) { //1의 자표가 직사각형 내부에 존재하는지 확인
						if((nx <= node.x && node.x <= nx + H-1) && (ny <= node.y && node.y <= ny + W-1)) {
							contain = true;
							break;
						}
					}
					if (!contain) {//1을 포함하지 않는다면
						map[nx][ny] = map[now.x][now.y] + 1;
						q.offer(new Node(nx, ny));
					}
				}

			}
		}
	}
}
