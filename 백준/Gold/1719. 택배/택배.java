import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
class Node implements Comparable<Node>{
	int index, cost;
	Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	public int compareTo(Node node) {
		return this.cost - node.cost;
	}
}

public class Main {


	static int n, m;
	static int[][] next;
	static ArrayList<Node>[] map;
	static int[][] min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		map = new ArrayList[n];
		next = new int[n][n];
		min = new int[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = new ArrayList<>();
			next[i][i] = -1;
		}

		for (int i = 0; i < m; i++) {
			String[] edge = br.readLine().split(" ");
			int a = Integer.parseInt(edge[0]);
			int b = Integer.parseInt(edge[1]);
			int cost = Integer.parseInt(edge[2]);
			map[a - 1].add(new Node(b - 1, cost));
			map[b - 1].add(new Node(a - 1, cost));
		}
		for(int i=0; i<n; i++) {
			int[] previous = dijkstra(i);

			for (int j=0; j<n; j++) {
				int idx = j;
				if (previous[idx] == -1)continue;
				while(previous[idx] != i+1) { //start에서 가장 먼저 만나는 노드번호 찾기
					idx = previous[idx]-1;
				}
				next[i][j] = idx+1;
			}

		}

		StringBuffer sb = new StringBuffer();
		for(int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if(i==j) sb.append("-");
				else sb.append(next[i][j]);
				sb.append(" ");
			}
			sb.append('\n');
		}

		System.out.print(sb.toString());

	}

	static int[] dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		int[] distance = new int[n];
		Arrays.fill(distance, 987654321);
		distance[start] = 0;
		q.offer(new Node(start, 0));
		int[] previous = new int[n];
		previous[start] = -1;
		while(!q.isEmpty()) {
			Node now  = q.poll();
			for (Node next : map[now.index]) {
				int cost = distance[now.index] + next.cost;
				if(distance[next.index] > cost) {
					q.offer(new Node(next.index, cost));
					distance[next.index] = cost;
					previous[next.index] = now.index+1;
				}
			}
		}
		return previous;
	}



}

