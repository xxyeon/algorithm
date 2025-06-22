import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Node implements Comparable<Node> {
	int x,y,cost;

	public int compareTo(Node o1) {
		return this.cost - o1.cost;
	}
	public Node(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}
public class Main {
	private static int n;
	private static int[][] cave;
	private static int[][] distance;
	private static int[] dx = {0,0,-1,1};
	private static int[] dy = {-1,1,0,0};
	private static Queue<Node> q = new PriorityQueue<>();
	private static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int num=0;
		while(n != 0) {
			cave = new int[n][n];
			distance = new int[n][n];
			for(int i=0; i<n;i++) {
				cave[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				Arrays.fill(distance[i], 987654321);
			}
			int cost = dijkstra(0, 0);
			q.clear();
			sb.append("Problem ").append(++num).append(": ").append(cost).append('\n');
			n = Integer.parseInt(br.readLine());
		}
		System.out.print(sb.toString());
	}
	static int dijkstra(int x, int y) {
		q.offer(new Node(x, y, cave[x][y]));
		distance[x][y] = cave[x][y];
		while (!q.isEmpty()) {
			Node now = q.poll();
			for(int i=0; i< 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(nx < 0 || nx >= n || ny < 0|| ny >=n) {
					continue;
				}
				int cost = distance[now.x][now.y] + cave[nx][ny];
				if(distance[nx][ny] > cost) {
					distance[nx][ny] = cost;
					q.offer(new Node(nx, ny, cost));
				}
			}
		}
		return distance[n-1][n-1];
	}

}

