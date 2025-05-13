import java.io.*;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sb = new StringBuilder();
		//graph: n개 노드의 연결 정보
		String[] input = bf.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int x = Integer.parseInt(input[2]);

		ArrayList<Node>[] graph = new ArrayList[n];
		ArrayList<Node>[] reverseGraph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<Node>();
			reverseGraph[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < m; i++) {
			String[] edge = bf.readLine().split(" ");
			int a = Integer.parseInt(edge[0]);
			int b = Integer.parseInt(edge[1]);
			int c = Integer.parseInt(edge[2]);
			graph[a-1].add(new Node(b-1, c));
			reverseGraph[b - 1].add(new Node(a - 1, c));
		}


		int[] d1 = dijkstra(x-1, graph, n);
		int[] d2 = dijkstra(x-1, reverseGraph, n);
		//distance중에서 최대
		int max = 0;

		for(int i=0; i<n; i++) {
			max = Math.max(d1[i] + d2[i], max);
		}
		System.out.print(max);
	}

	private static int[] dijkstra(int start, ArrayList<Node>[] graph, int n) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		//distance 초기화해주기
		int[] distance = new int[n];
		Arrays.fill(distance, 987654321);
		distance[start] = 0;
		q.offer(new Node(start, 0));
		while(!q.isEmpty()) {
			Node node = q.poll();

			//노드가 큐에 들어갔다가 최단경로로 갱신 된적이 있다면 해당 노드와 연결된 노드가 이미 큐에 들어 있으므로 큐에 연결된 노드 저장하는 과정 생략
			if (distance[node.getIndex()] < node.getDistance()) continue;
			for(int i=0; i < graph[node.getIndex()].size(); i++) {
				Node next = graph[node.getIndex()].get(i);
				//현재 노드를 거치는 비용
				//d[i] = 특정 노드에서 i까지의 최소 비용
				int cost = distance[node.getIndex()] + next.getDistance();
				if(distance[next.getIndex()] > cost) {
					distance[next.getIndex()] = cost;
					q.offer(new Node(next.getIndex(), cost)); //cost가 갱신된 새로운 node생성해서 넣어준다.
				}
			}
		}
		return distance;
	}

}

class Node implements Comparable<Node> {
	private int index;
	private int distance;

	public int getIndex() {
		return index;
	}
	public int getDistance() {
		return distance;
	}
	Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	@Override
	public int compareTo(Node other) {
		if (distance < other.getDistance()) {
			return -1;
		} else return 1;
	}
}
