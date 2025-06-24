import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int index;
	int cost;
	Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}

public class Main {
	private static int n, m;
	private static ArrayList<Node>[] map;
	private static int[] distance;

	//cost = 1000, 길: 5만 -> int는 2^31가지 표현이 가능함(음수 포함 대략 2억) 충분함
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");


		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		map = new ArrayList[n];
		distance = new int[n];
		for(int i = 0; i<n; i++) {
			map[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}



		for(int i =0; i<m; i++) {
			int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			//양방향 고려
			map[edge[0]-1].add(new Node(edge[1]-1, edge[2]));
			map[edge[1]-1].add(new Node(edge[0]-1, edge[2]));
		}
		dijkstra(0);
		System.out.print(distance[n - 1]);
	}
	private static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start, 0));
		distance[start] = 0;
		while(!q.isEmpty()) {
			Node now = q.poll();
			int i = now.index;
			for (Node node : map[i]) {
				int newCost = distance[i] + node.cost;
				if(distance[node.index] > newCost) {
					distance[node.index] = newCost;
					q.offer(new Node(node.index, newCost));
				}
			}
		}
	}

}

