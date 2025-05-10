import java.io.*;
import java.util.Arrays;

public class Main {

	private final static int[][] d = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}}; //오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선, 아래

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int answer = 0;
		int[] position = new int[2];
		int[][] map = new int[19][19];
		for (int i =0; i < 19; i ++) {
			map[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		boolean findWinner = false;

		for (int y = 0; y<19; y++) {
			for (int x = 0; x < 19; x++) {
				//왼쪽에서 오른쪽으로, 위에서 아래로
				int winner = 0;
				if (map[x][y] == 1 || map[x][y] == 2) {
					winner = simulation(map[x][y], x, y, map);
				}
				if (winner == 0) {
					continue;
				} else {
					answer = winner;
					position[0] = x+1;
					position[1] = y+1;
					findWinner = true;
					break;
				}
			}
			if (findWinner) {
				break;
			}
		}
		sb = answer == 0 ? sb.append(answer) : sb.append(answer).append('\n').append(position[0]).append(" ").append(position[1]);

		System.out.println(sb.toString());

	}
	private static int simulation(int kind, int x, int y, int[][] map) {
		// int answer = 0;
		int currentX = x;
		int currentY = y;
		for (int j = 0; j< 4; j++) {
			// int black = kind == 1 ? 1:0;//새로운 방향으로 탐색할 때 초기화
			// int white = kind == 2 ? 1:0;;
			int count = 1;
			x = currentX;
			y = currentY;
			for(int i =0; i < 4; i++) {
				int nx = x + d[j][0];
				int ny = y + d[j][1];
				if(nx < 0 || nx >= 19 || ny < 0 || ny >=19 || map[nx][ny] != kind) {
					break;
				}
				// System.out.println("nx: " + nx + " ny: " + ny);
				// if (map[nx][ny] == kind) {
					//검은돌이 한방향으로 연속으로 나오면
				x = nx;
				y = ny;
				count++;
			}

			// }
			if (count == 5) {

				int px = currentX - d[j][0];
				int py = currentY - d[j][1];
				int nx = x + d[j][0];
				int ny = y + d[j][1];

				boolean before = px >= 0 && px < 19 && py >= 0 && py < 19 && map[px][py] == kind;
				boolean after = nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && map[nx][ny] == kind;
				if (!before && !after) return kind;
				break;
			}

			// System.out.println("x: " + x+ " y " + y);
			// System.out.println("black: " + black);
			// System.out.println("white: " + white);
		}
		return 0;
	}
}

