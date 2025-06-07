import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Node {
	int x, y, move;
	Node(int x, int y, int move) {
		this.x = x;
		this.y = y;
		this.move = move;
	}
}
public class Main {
	private static boolean[][] visited;
	private static Set<Integer>[] climb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int t = Integer.parseInt(input[1]);

		int maxX = 0;
		climb = new HashSet[t+1];
		for(int i=0; i<t+1; i++) {
			climb[i] = new HashSet<>();
		}
		for(int i=0; i<n; i++) {
			String[] node = br.readLine().split(" ");
			int x = Integer.parseInt(node[0]);
			int y = Integer.parseInt(node[1]);
			climb[y].add(x);
			maxX = Math.max(maxX, x);
		}

		visited = new boolean[maxX+1][t+1];

		int answer = -1;
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0,0,0));
		visited[0][0] = true;
		// visited[0][0] = true;
		while(!q.isEmpty()) {
			Node node = q.poll();
			int x = node.x;
			int y = node.y;

			if (y == t) {
				answer = node.move;
				break;
			}

			//홈이 있다면

			for(int xp=-2; xp < 3; xp++){
				for(int yp = -2; yp<3; yp++) {
					int nx = x + xp;
					int ny = y + yp;
					if (nx < 0 || nx > maxX || ny < 0 || ny > t) {
						continue;
					}
					if (climb[ny].contains(nx) && !visited[nx][ny]) {
						//방문했다면 1 보다 클것임
						// System.out.println(nx + " " + ny);
						q.offer(new Node(nx, ny, node.move+1));
						visited[nx][ny] = true;
						// visited[nx][ny] = true;
					}
				}
			}
			// for(int i=0; i<4;i++) {
			// 	int nx = x + move[i][0];
			// 	int ny = y + move[i][1];
			// 	if (nx < 0 || nx > 1000001 || ny < 0 || ny > t+1) {
			// 		continue;
			// 	}
			// 	System.out.println(nx + " " + ny);
			// 	if (clim[nx][ny] == 1 && !visited[nx][ny]) {
			// 		q.offer(new Node(nx, ny, node.move+1));
			// 		visited[nx][ny] = true;
			// 	}
			//
			// }
		}
		System.out.print(answer);
	}

}