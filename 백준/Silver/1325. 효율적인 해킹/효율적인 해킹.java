import java.io.*;
import java.util.*;



public class Main {
	private static List<Integer>[] graph;
	static int[] visited;
	static StringBuilder sb = new StringBuilder();
	static int max = 0;

	public static void main(String[] args) throws IOException {


		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		graph = new ArrayList[n];
		visited = new int[n];
		Arrays.fill(visited, -1);

		for(int i=0;i<n;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<m ;i++){
			String[] edge = bf.readLine().split(" ");
			int a = Integer.parseInt(edge[0]);
			int b = Integer.parseInt(edge[1]);
			graph[b-1].add(a-1);
		}

		for(int k=0; k<n;k++) { //모든노드를 고려하지 하면 시간초과임,
			// bfs(i, n);
			int start = k;
			Queue<Integer> q = new LinkedList<>();
			//visited 여부는 방문했다며 visited를 start로 다 만들것임
			int count = 0;
			q.offer(start);
			visited[start] = start;
			while(!q.isEmpty()) {
				int now = q.poll();
				for(int i=0; i< graph[now].size(); i++) {
					int next = graph[now].get(i);
					if (visited[next] != start) {
						count++;
						q.offer(next);
						visited[next] = start;
					}

				}
			}

			//인덱스 찾는걸 bfs내에서해결하기
			if (count > max) {
				sb = new StringBuilder();
				sb.append(start+1).append(" ");
				max = count;
			} else if(max == count) {
				sb.append(start+1).append(" ");
			}
		}

		System.out.print(sb.toString());

	}

	// static private void bfs(int start, int n) {
	// 	// boolean[] visited = new boolean[n];//배열을 새로 만드는 것도 시간이 걸리는 작업이다.
	// 	Queue<Integer> q = new LinkedList<>();
	// 	//visited 여부는 방문했다며 visited를 start로 다 만들것임
	// 	int count = 0;
	// 	q.offer(start);
	// 	visited[start] = start;
	// 	while(!q.isEmpty()) {
	// 		int now = q.poll();
	// 		for(int i=0; i< graph[now].size(); i++) {
	// 			int next = graph[now].get(i);
	// 			if (visited[next] != start) {
	// 				count++;
	// 				q.offer(next);
	// 				visited[next] = start;
	// 			}
	//
	// 		}
	// 	}
	//
	// 	//인덱스 찾는걸 bfs내에서해결하기
	// 	if (count > max) {
	// 		sb = new StringBuilder();
	// 		sb.append(start+1).append(" ");
	// 		max = count;
	// 	} else if(max == count) {
	// 		sb.append(start+1).append(" ");
	// 	}
	//
	// }

}

