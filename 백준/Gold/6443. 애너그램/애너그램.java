import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	private static int n;
	private static char[] arr;
	private static ArrayList<String> set = new ArrayList<>();
	private static boolean[] visited = new boolean[27];
	private static char[] alphabet;
	// Array도 인덱스 접근은 O(1)
	private static ArrayList<Character>[] hash;
	//n*10만 -> 4*10만 * n, 128 * 1024 * 1024 -> 대략 억 -> n이 5자리만 되어도 메모리 초과? -> 모두 저장할 수 없을 듯
	public static void main(String[] args) throws IOException {
		//모든 문자를 가지고 문자 만들기 -> 순열 -> dfs내 For문 visited 사용 애너그램의 수 <= 10만개
		//단어길이 20 -> 전체 경우의 수 20! -> 시간 부족 -> 중복되는거는 dfs돌리면 안됨됨
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();

		for(int i=0 ; i<n; i++) {
			arr = br.readLine().toCharArray();
			Arrays.sort(arr);
			visited = new  boolean[arr.length];
			dfs("", arr.length, 0);
			// for(char a : arr) {
			// 	visited[a-'a'] = false;
			// }
		}
		//aba' a'ba -> 이렇되지 않도록 for
		for(String str : set) {
			sb.append(str).append('\n');
		}

		System.out.print(sb.toString());
	}
	private static void dfs(String result, int length, int depth) {

		if(depth == length) {
			set.add(result);
				// System.out.println(length);
			return;
		}
		for(int i=0; i < length; i++) {
			if(visited[i]) continue;
			if (i > 0 && arr[i] == arr[i-1] && !visited[i-1]) continue; //visited[i-1] 을 이미 방문했다면
			visited[i] = true;
			dfs(result +  arr[i], length, depth + 1);
			visited[i] = false;
		}
	}
}

