import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {

	int index, distance;

	public int compareTo(Node o) {
		return this.distance - o.distance;
	}

	Node(int index, int distance) {

	this.index =index;
		this.distance = distance;
	}
}
public class Main {

	static int[] distance;
	static ArrayList<Node>[] network;
	static ArrayList<Integer>[] linkedNode;
	static int n, m;
	// static boolean[] visited;
	static ArrayList<int[]> edge;
	static boolean[] visited;
	static int[][] min;
	static int[] previous;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		network = new ArrayList[n];
		distance = new int[n];
		edge = new ArrayList<>();
		Arrays.fill(distance, Integer.MAX_VALUE);
		visited = new boolean[n];
		linkedNode = new ArrayList[n+1];
		for (int i = 0; i < n; i++) {
			network[i] = new ArrayList<>();
			// linkedNode[i] = i;
			linkedNode[i+1] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			String[] edge = br.readLine().split(" ");
			int a = Integer.parseInt(edge[0]);
			int b = Integer.parseInt(edge[1]);
			int cost = Integer.parseInt(edge[2]);
			network[a - 1].add(new Node(b - 1, cost));
			network[b - 1].add(new Node(a - 1, cost));
		}
		min = new int[n][n];
		previous = new int[n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(min[i], Integer.MAX_VALUE);
		}
		dijkstra(0);
		StringBuffer sb = new StringBuffer();
		sb.append(n - 1).append("\n");
		// for (int i = 0; i < n-1; i++) {
		// 	int[] e = edge.get(i);
		// 	sb.append(e[0]).append(" ").append(e[1]).append("\n");
		// }
		// for(int i=0; i<n; i++) {
		//
		// 	int row = -1;
		// 	int m = Integer.MAX_VALUE;
		// 	for (int k = 0; k < n; k++) {
		// 		// System.out.print(min[i][k] + " ");
		// 		if (visited[i] && visited[k]) {
		// 			continue;
		// 		}
		// 		if(m > min[k][i]) {
		// 			row = k;
		// 			m = min[k][i];
		// 		}
		// 	}
		// 	// System.out.println();
		// 	if(row==-1) continue;
		// 	visited[row] = true;
		// 	visited[i] = true;
		// 	sb.append(i+1).append(" ").append(row+1).append("\n");
		// }
		for (int i = 1; i < n; i++) {
			sb.append(i + 1).append(" ").append(previous[i]+1).append("\n");

		}
		System.out.print(sb.toString());

	}
	static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start, 0));
		distance[start] = 0;
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (Node next : network[now.index]) {
				int cost = distance[now.index] + next.distance;
				if (distance[next.index] > cost) {
					//now.index에서 특정 노드까지..
					//모든 edge 저장후 처음 n-1개 출력
					// linkedNode[now.index+1].add(next.index+1);
					// linkedNode[next.index+1].add(now.index+1); //양방향이므로 반대 방향도 추가
					//
					// min[now.index][next.index] = cost;
					// min[next.index][now.index] = cost;
					previous[next.index] = now.index;
					edge.add(new int[] {now.index + 1, next.index + 1});

					q.offer(new Node(next.index, cost));
					distance[next.index] = cost;
				}
			}
		}
	}


}

