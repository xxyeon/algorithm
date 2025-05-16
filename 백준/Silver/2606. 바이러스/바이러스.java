import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		int edge = Integer.parseInt(bf.readLine());

		int[] parent=  new int[n];
		for(int i=0; i < n; i++) {
			parent[i] = i;
		}
		for(int i=0; i < edge; i++) {
			String[] nodes = bf.readLine().split(" ");
			int a = Integer.parseInt(nodes[0]);
			int b = Integer.parseInt(nodes[1]);
			union(a-1, b-1, parent);
		}

		//parent[i] == 0이면 바이러스 감염
		int count = 0;
		for(int i=1; i<n; i++) {
			int p = findParent(parent[i], parent);
			if(p == 0) {
				count++;
			}
			// System.out.print(p + " ");
		}
		// System.out.println();

		System.out.print(count);
	}

	private static int findParent(int a, int[] parent) {
		if(a != parent[a]) {
			parent[a] = findParent(parent[a], parent);
		}
		return parent[a];
	}
	private static void union(int a, int b, int[] parent) {
		a = findParent(a, parent);
		b = findParent(b, parent);
		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}
}

