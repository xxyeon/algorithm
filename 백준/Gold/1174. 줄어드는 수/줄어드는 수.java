import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static int[] arr = {9,8,7,6,5,4,3,2,1,0}; //여기서 부분 집합 모두 구하면 됨
	private static ArrayList<Long> set = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dfs(0, 0);
		set.sort((a, b) -> (int)(a - b)); //오름차순
		if (n > set.size()) {
			System.out.print(-1);
		} else {
			System.out.print(set.get(n - 1));
		}


	}

	private static void dfs(long result, int depth) {
		if(!set.contains(result)) { //이렇게하면 8부터 시작하는 건 못들어감
			set.add(result);
		}
		//10개를 모두 고려하였다면 return
		if (depth >= 10) return;

		dfs((result*10) + arr[depth], depth + 1);
		dfs(result, depth + 1);

	}

}