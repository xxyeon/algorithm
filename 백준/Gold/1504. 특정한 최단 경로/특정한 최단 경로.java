import java.io.*;
import java.util.*;
//https://testcase.ac/problems/1504
public class Main {
	private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	private static int n;
	private static boolean[] visited;
	private static int[] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String[] input = bf.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		int edge = Integer.parseInt(input[1]);
		distance = new int[n];
		visited = new boolean[n];
		for (int i=0; i<n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i=0; i<edge; i++) {
			String[] cost = bf.readLine().split(" ");
			int a = Integer.parseInt(cost[0]);
			int b = Integer.parseInt(cost[1]);
			int c = Integer.parseInt(cost[2]);
			graph.get(a-1).add(new Node(b-1, c));
			graph.get(b - 1).add(new Node(a - 1, c));
		}
		input = bf.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);

		int cost = 0;
		cost += dijkstra(0, a-1); //1 ->a
		cost += dijkstra(a-1, b-1); //a -> b
		cost += dijkstra(b-1, n-1); // b->n

		int cost2 = 0;
		cost2 += dijkstra(0, b-1); //1 ->a
		cost2 += dijkstra(b-1, a-1); //a -> b
		cost2 += dijkstra(a-1, n-1); // b->n
		int result = Math.min(cost, cost2);
		System.out.print(result >= 200000000 ? -1 : result);

	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> q = new PriorityQueue<>(); //여기서 node는 start와 이어진 index와 최소 cost
		Arrays.fill(distance, 200000000);
		Arrays.fill(visited, false);
		q.offer(new Node(start, 0));
		distance[start] = 0;
		while(!q.isEmpty()) {
			Node now = q.poll();
			// if (visited[now.index]) continue;
			visited[now.index] = true;

			for(int next=0; next<graph.get(now.index).size(); next++) {
				//now까지의 최소비용
				Node node = graph.get(now.index).get(next);
				if (visited[node.index]) continue;
				int cost = distance[now.index] + node.distance;
				if (cost < distance[node.index]) {
					distance[node.index] = cost;
					q.offer(new Node(node.index, cost));
				}
			}

		}
		return distance[end];
	}
}
class Node implements Comparable<Node>{
	int index;
	int distance;

	public int compareTo(Node other) {
		return distance - other.distance;
	}
	Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}

}


