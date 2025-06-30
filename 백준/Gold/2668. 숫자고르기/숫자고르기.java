import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
	static Set<Integer> result = new HashSet<>();
	static int n;
	static Map<Integer, Integer> map = new HashMap<>();

	static boolean[] visited;
	static Set<Integer> index;
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		for (int i = 1; i < n+1; i++) {
			map.put(i, Integer.parseInt(br.readLine()));
		}
		for (int i = 1; i < n + 1; i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append('\n');
		Object[] resultArr = result.toArray();
		// int[] intArr = Arrays.stream(resultArr).mapToInt(Integer::).toArray();
		Arrays.sort(resultArr);
		for (Object num : resultArr) {
			sb.append((int)num).append('\n');
		}
		System.out.println(sb.toString());
	}

	static public void dfs(int start, int target) {
		if (!visited[map.get(start)]) { //start의 value를 아직 방문하지 않았다면
			visited[map.get(start)] = true;
			dfs(map.get(start), target);
			visited[map.get(start)] = false;
		}
		if (map.get(start) == target) {
			result.add(target);
		}
	}
}

