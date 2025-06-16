import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static boolean[] visited = new boolean[26];
	private static int r;
	private static int c;
	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1,-1,0,0};
	private static char[][] board;
	private static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		r = Integer.parseInt(input[0]);
		c = Integer.parseInt(input[1]);
		board = new char[r][c];
		for(int i=0; i<r; i++) {
			board[i] = br.readLine().toCharArray();
		}
		visited[board[0][0] - 'A'] = true;
		dfs(0, 0, 1);

		System.out.print(max);
	}

	private static void dfs(int x, int y, int count) {
		//주변에 더이상 갈 곳이 없을 경우 종료
		//매번 갱신해주기
		max = Math.max(max, count);
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
			int idx = board[nx][ny] - 'A';
			if(!visited[idx]){
				visited[idx] = true;
				dfs(nx, ny, count + 1);
				visited[idx] = false;
			}
		}
	}

}