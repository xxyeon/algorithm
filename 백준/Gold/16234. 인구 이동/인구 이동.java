import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Node {
	int x, y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int R,L,N;
	static int[][] city;
	static boolean[][] visited;
	static int cityCnt = 1;
	static long count = 1;
	static int[][] associated;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		L = Integer.parseInt(input[1]);
		R = Integer.parseInt(input[2]);

		city = new int[N][N];
		for(int i=0; i<N;i++) {
			city[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		int day = 0;
		while(true) {

			visited = new boolean[N][N];
			associated = new int[N][N];
			List<Integer> info = new ArrayList<>(); //각 연합국의 전체 인구수
			int number = 0; //연합국 번호
			//각 도시마다 연합국 형성해보기

			for (int i=0; i<N;i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j]) continue;

					number++;
					if (!bfs(i, j, info, number)) {
						number--; //연합국이 아니므로 number-1;
					}
					//i,j 도시에서 연합도시가 있다면
					// if(cityCnt > 1) visited[i][j] = true;

				}
			}

			if(info.isEmpty()) { //연합국이 없다면
				break;
			}

			for(int num = 1; num <= info.size(); num++) {//각 연합국마다 인구이동 시작
				for (int i=0; i<N;i++) {
					for (int j = 0; j < N; j++) {

						if (associated[i][j] == num) {
							city[i][j] = info.get(num - 1); //O(1)
						}
					}
				}
			}
			day++;
		}
		System.out.print(day);
	}


	private static boolean bfs(int x, int y, List<Integer> info, int number) { //국경열고 인구 이동할 수 있는곳 탐색
		// List<Node> associated = new ArrayList<Node>();
		cityCnt = 1;
		count = city[x][y];

		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(x, y));

		// associated.add(node);
		visited[x][y] = true;
		associated[x][y] = number;
		while (!q.isEmpty()) {
			Node now = q.poll();
			for(int i=0;i<4;i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 > nx || N <= nx || 0 > ny || N <= ny)
					continue;
				int gap = Math.abs(city[now.x][now.y] - city[nx][ny]);
				if (!visited[nx][ny] && (L <= gap && gap <= R)) {
					visited[nx][ny] = true;
					Node next = new Node(nx, ny);
					q.offer(next);
					count += city[nx][ny];
					cityCnt += 1;
					associated[nx][ny] = number;
				}
			}
		}
		if (cityCnt == 1) {
			associated[x][y] = 0;
			return false;
		}
		info.add((int)(count/cityCnt));
		return true;

	}

}

