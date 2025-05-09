import java.io.*;

public class Main {
	private static final int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(bf.readLine());
		int num = Integer.parseInt(bf.readLine());

		int cycle = 1;
		int number = 1;
		int x = n/2;
		int y = n/2;

		int[] answer = new int[2];
		int[][] map = new int[n][n];
		map[x][y] = number;
		if (num == 1) {
			answer[0] = x+1;
			answer[1] = y+1;
		}
		while(n*n >= number) {
			for (int i = 0; i < d.length; i++) {//위 오 아 왼
				for (int k = 0; k < cycle; k++) {
					number++;
					if(number > n*n) break;
					// System.out.println(x + " " + y);
					x += d[i][0]; //i:방향을 가르킴
					y += d[i][1];
					map[x][y] = number;
					// System.out.println(number);
					if (number == num) {
						answer[0] = x + 1;
						answer[1] = y + 1;
					}
				}

				if (i==1 || i ==3) {
					cycle++;
				}
			}
		}
		for (int[] line : map) {
			for (int i : line) {
				sb.append(i).append(" ");
			}
			sb.append('\n');
		}
		System.out.print(sb.toString());
		System.out.print(answer[0] + " " + answer[1]);


	}

}

