import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
	int x, y;
	Node(int x, int y) {
		this.x =x;
		this.y = y;
	}
}
public class Main {
	private static int[][] map;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	private static int n;
	private static List<Integer> answer;
	private static int num = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		answer = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			char[] charArr = br.readLine().toCharArray();
			for (int k = 0; k < n; k++) {
				map[i][k] = charArr[k] - '0';
			}
		}
		Queue<Node> q = new LinkedList<>();
		for(int i=0; i<n;i++) {
			for (int k = 0; k < n; k++) {
				if (map[i][k] == 1) {
					int result = bfs(i, k, q);
					answer.add(result);
					q.clear();
				}
			}
		}
		answer.sort(Comparator.naturalOrder());
		System.out.println(num-1);
		for(int n : answer){
			System.out.println(n);
		}

	}
	private static int bfs(int x, int y, Queue<Node> q) {
		q.offer(new Node(x, y));
		num++;
		map[x][y] = num;
		int cnt = 1;
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i=0;i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}
				if(map[nx][ny] == 1) {
					//아직 방문하지 않다면
					map[nx][ny] = num;
					cnt++;
					q.offer(new Node(nx,ny));
				}
			}
		}
		return cnt;

	}

}