import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
class Node implements Comparable<Node> {
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
	static int n;
	static int d;
	static int c;


	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			String[] input = br.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			d = Integer.parseInt(input[1]);
			c = Integer.parseInt(input[2]);

			ArrayList<Node>[] map = new ArrayList[n];
			for(int j = 0; j<n;j++){
				map[j] = new ArrayList<>();
			}
			for(int j=0; j<d;j++){
				String[] edge = br.readLine().split(" ");
				int a = Integer.parseInt(edge[0]);
				int b = Integer.parseInt(edge[1]);
				int c = Integer.parseInt(edge[2]);
				map[b - 1].add(new Node(a - 1, c));

			}

			int answer = 0;
			int[] previous = new int[n];
			int time = 0;
			int[] result = dijkstra(c-1, map);

			for (int r : result) {
				if (r != Integer.MAX_VALUE) {
					answer++;
					time = Math.max(time, r);
				}
			}
			sb.append(answer).append(" ").append(time).append('\n');
		}
		System.out.print(sb.toString());


	}

	public static int[] dijkstra(int start, ArrayList<Node>[] map){
		PriorityQueue<Node> q = new PriorityQueue<>();
		int[] distance = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		q.offer(new Node(start, 0));
		distance[start] = 0;
		while(!q.isEmpty()) {

			Node now = q.poll();
			for (Node next : map[now.index]) {
				int cost = distance[now.index] + next.cost;
				if (distance[next.index] > cost) {
					distance[next.index] = cost;
					q.offer(new Node(next.index, cost));
				}
			}
		}

		return distance;
	}



}

