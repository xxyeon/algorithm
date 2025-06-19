import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	private static int[] visited = new int[100];
	private static Set<Long> set = new HashSet<>();
	private static int[] card;
	private static int n, k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		card = new int[n];
		k = Integer.parseInt(br.readLine());
		for(int i=0; i <n;i++){
			int num = Integer.parseInt(br.readLine());
			card[i] = num;
			visited[num]++;
		}
		dfs("", 0);
		System.out.print(set.size());
	}

	private static void dfs(String result, int count) {
		if(count == k) {
			set.add(Long.parseLong(result));
			return;
		}

		for(int num : card) {
			if(visited[num] ==0) continue;
			visited[num]--;
			dfs(result + num, count + 1);
			visited[num]++;
		}
	}

}