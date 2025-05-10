import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test = Integer.parseInt(bf.readLine());
		for(int i = 0; i < test; i++) {
			String[] input = bf.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int d = Integer.parseInt(input[1]);
			int[][] map = new int[n][n];
			for (int j=0; j < n; j++) {
				map[j] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			if (d > 0) {
				for(int k = 0; k<d/45; k++) {
					rotate(map, n);
				}



			} else {
				for(int k=0; k < (-d)/45; k++) {
					rotateReverse(map, n);

				}


			}
			for(int[] l : map) {
				for(int num : l) {
					sb.append(num).append(" ");
				}
				sb.append('\n');
			}
		}
		System.out.print(sb.toString());

	}
	private static int[][] rotate(int[][] map, int n) {
		int[][] copy = new int[n][n];
		for(int i = 0; i < n; i++) {
			for (int j = 0; j<n; j++) {
				copy[i][j] = map[i][j];
			}
		}
		for(int i = 0; i < n; i++) {
			map[i][n/2] = copy[i][i];
			map[i][n - 1 - i] = copy[i][n / 2];
			map[n/2][n-1-i] = copy[i][n-1-i];
			map[i][i] = copy[n/2][i];
		}
		return map;
	}

	private static int[][] rotateReverse(int[][] map, int n) {
		int[][] copy = new int[n][n];
		for(int i = 0; i < n; i++) {
			for (int j = 0; j<n; j++) {
				copy[i][j] = map[i][j];
			}
		}
		for(int i = 0; i < n; i++) {
			map[i][i] = copy[i][n/2];
			map[i][n / 2] = copy[i][n - 1 - i];
			map[i][n-1-i] = copy[n/2][n-1-i];
			map[n/2][i] = copy[i][i];
		}
		return map;
	}
}

