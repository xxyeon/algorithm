import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int index;
	long distance;
	public int compareTo(Node o) {
		return (int)(distance - o.distance);
	}

	Node(int index, long distance) {
		this.index = index;
		this.distance = distance;
	}
}

public class Main {

	private static List<Node>[] graph;
	private static long[] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] input = bf.readLine().split(" ");
		int n = Integer.parseInt(input[0]);//노드 개수
		int m = Integer.parseInt(input[1]);//간선개수
		int k = Integer.parseInt(input[2]);//면접장개수

		distance = new long[n+1];
		Arrays.fill(distance, Long.MAX_VALUE);
		graph = new ArrayList[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			String[] e = bf.readLine().split(" ");
			int a = Integer.parseInt(e[0]);
			int b = Integer.parseInt(e[1]);
			int c = Integer.parseInt(e[2]);
			// graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c)); // 간선 방향 반대로 저장
		}

		int[] interview = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for (int i : interview) {
			graph[0].add(new Node(i, 0));
		}

		dijkstra(0);
		//distance에서 최대값
		long max = -1;
		int node = n+1;
		for (int i=1; i<n+1; i++) {
			if (max < distance[i]) {
				max = distance[i];
			}
		}
		//만약 그런 도시가 여러 곳이면 가장 작은 번호를 출력한다.
		for(int i=1; i<n+1; i++) {
			if (max == distance[i]) {
				node = i;
				break;
			}
		}
		System.out.println(node);
		System.out.println(max);

	}
	public static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start, 0));
		distance[start] = 0;
		while (!q.isEmpty()){
			Node now = q.poll();
			if (distance[now.index] < now.distance) continue; //특정 노드에서 현재까지의 길이가 최솟값보다 크면

			for(Node node: graph[now.index]) {
				long cost = distance[now.index] + node.distance;
				if(distance[node.index] > cost) {
					q.offer(new Node(node.index, cost));
					distance[node.index] = cost;
				}
			}
		}
	}
}

