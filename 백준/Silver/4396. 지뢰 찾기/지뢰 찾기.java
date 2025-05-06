import java.io.*;
import java.util.Arrays;
public class Main {
	private final static int[][] move = {{1,0}, {-1,0}, {0, 1}, {0,-1}, {-1, 1}, {-1,-1}, {1,1}, {1,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int n = Integer.parseInt(bf.readLine());
		char[][] gameInfo = new char[n][n];
		char[][] playInfo = new char[n][n];
		char[][] answer = new char[n][n];

		for(int i =0; i < n; i++) {
			gameInfo[i] = bf.readLine().toCharArray();
		}

		for(int i =0; i < n; i++) {
			playInfo[i] = bf.readLine().toCharArray();
		}
		boolean isBom = false;
		for (int i =0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (playInfo[i][j] == 'x' && gameInfo[i][j] != '*') {
					int bom = 0;
					for (int[] m : move) {
						int nx = i + m[0];
						int ny = j+m[1];
						if (nx < n && nx >= 0 && ny < n && ny >=0) {
							if (gameInfo[nx][ny] == '*') {
								bom++;
							}
						}
					}
					//int to char
					answer[i][j] = Character.forDigit(bom, 10);
				} else if(playInfo[i][j] == 'x' && gameInfo[i][j] == '*') {
					isBom = true;
					answer[i][j] = '*';
				}
				else {
					answer[i][j] = '.';
				}
			}
		}
		
		if (isBom) { //지리 클릭했다면
			for (int i =0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (gameInfo[i][j] == '*') {
						answer[i][j] = '*';
					}
				}
			}
			
		}
		for (char[] line : answer) {
			for (char ch : line) {
				sb.append(ch);
			}
			sb.append('\n');
		}

		System.out.print(sb.toString());
	}
}
