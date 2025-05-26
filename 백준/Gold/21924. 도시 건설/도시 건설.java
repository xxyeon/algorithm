import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
	int a, b;
	long cost;
	public int compareTo(Edge o) {
		return (int) (cost - o.cost);
	}

	Edge(int a, int b,int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}
}
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int e = Integer.parseInt(input[1]);
		Edge[] graph = new Edge[e];
		int[] parent = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		long total = 0;
		for (int i = 0; i < e; i++) {
			String[] edges = br.readLine().split(" ");
			int a = Integer.parseInt(edges[0]);
			int b = Integer.parseInt(edges[1]);
			int c = Integer.parseInt(edges[2]);
			graph[i] = new Edge(a-1, b-1, c);

			total += c;
		}
		Arrays.sort(graph);
		int ed = 0;
		long cost = 0;
		for (Edge edge : graph) {
			if (find(parent, edge.a) != find(parent, edge.b)) {
				union(edge.a, edge.b, parent);
				cost += edge.cost;
				ed += 1;
			}
		}

		long answer = 0;
		if(ed != n-1){
			answer = -1;
		} else {
			answer = total - cost;
		}
		System.out.print(answer);

	}

	private static int find(int[] parent, int x) {
		if (parent[x] != x) {
			parent[x] = find(parent, parent[x]);
		}
		return parent[x];
	}

	private static void union(int a, int b, int[] parent) {
		a = find(parent, a);
		b = find(parent, b);
		if (a < b) {
			parent[b] =a;
		} else {
			parent[a] = b;
		}
	}

}

