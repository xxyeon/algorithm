import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[] parent = new int[n+1];
		for(int i=0; i<n+1; i++) {
			parent[i] = i;
		}

		Edge[] edges = new Edge[m+1];
		for(int i=0;i<m+1;i++) {
			String[] info = br.readLine().split(" ");
			int a = Integer.parseInt(info[0]);
			int b = Integer.parseInt(info[1]);
			int c = Integer.parseInt(info[2]);
			edges[i] = new Edge(a, b, c);
		}
		Arrays.sort(edges, (a, b) -> a.distance - b.distance); //오름차순; 오르막이 0 -> 최대신장트리
		
		int max = 0;
		for (int i=0; i<edges.length; i++) {
			Edge e = edges[i];
			if(findParent(e.a, parent) != findParent(e.b, parent)) {
				union(e.a, e.b, parent);
				if (e.distance == 0){
					max++;
				}
			}
		}

		for(int i=0; i<n+1; i++) {
			parent[i] = i;
		}

		int min = 0;
		for (int i=edges.length-1; i>=0; i--) {
			Edge e = edges[i];
			if(findParent(e.a, parent) != findParent(e.b, parent)) {
				union(e.a, e.b, parent);
				if (e.distance == 0){
					min++;
				}
			}
		}
		
		System.out.println(max * max - min * min);

	}
	private static int findParent(int x, int[] parent) {
		if(parent[x] != x) {
			parent[x] = findParent(parent[x], parent);
		}
		return parent[x];
	}

	private static void union(int a, int b, int[] parent) {
		a = findParent(a, parent);
		b = findParent(b, parent);
		if(a < b) {
			parent[b] =a;
		} else {
			parent[a] = b;
		}
	}
}
class Edge {
	int a, b, distance;

	Edge(int a, int b, int distance) {
		this.a = a;
		this.b = b;
		this.distance = distance;
	}
}
