import java.io.*;
import java.util.*;

public class Main {
	private static List<List<Integer>> arr;
	private static int n;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		n = Integer.parseInt(bf.readLine());

		arr = new ArrayList<>();
		map = new int[n][n];
		//map을 다이렉트 연결만 초기화
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==j) map[i][j] = 0;
				else map[i][j] = 987654321;
			}
		}

		for(int i=0; i<n; i++) {
			arr.add(new ArrayList<>());
		}

		while(true) {
			String[] input = bf.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			if (x == -1) {
				break;
			}
			int y = Integer.parseInt(input[1]);

			map[x-1][y-1] = 1;
			map[y-1][x-1] = 1;
		}
		floyd();
		int[] score = new int[n];
		int min = 987654321;
		for(int i=0; i<n; i++) {
			int max = 0;
			for(int num=0; num<n; num++) {
				if(map[i][num] != 987654321) max = Math.max(map[i][num], max);
			}
			score[i] = max;
			min = Math.min(min, max);
		}

		int count=0;
		ArrayList<Integer> candidate = new ArrayList<>();
		for(int num = 0; num<n; num++) {
			if(min == score[num]) {
				count++;
				candidate.add(num+1);
			}

		}
		sb.append(min).append(" ").append(count).append('\n');
		for(int num : candidate) {
			sb.append(num).append(" ");
		}
		System.out.print(sb.toString());

	}

	private static void floyd() {
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
	}
}


