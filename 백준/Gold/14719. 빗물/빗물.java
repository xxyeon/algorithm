import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input = bf.readLine().split(" ");
		int answer = 0;
		int n = Integer.parseInt(input[0]);
		int w = Integer.parseInt(input[1]); //배열 길이
		int[] block = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		//매번 현재 블록에서 양쪽의 max값을 구해야함.
		for (int i = 1; i < w - 1; i++) {
			//왼쪽 max찾기
			int leftMax = 0;
			for (int k = 0; k < i; k++) {
				leftMax = Math.max(block[k], leftMax);
			}
			//오른쪽 max 찾기
			int rightMax = 0;
			for (int k = i + 1; k < w; k++) {
				rightMax = Math.max(block[k], rightMax);
			}
			int height = Math.min(leftMax, rightMax);
			//height  - 현재 블록 높이
			answer += height - block[i] < 0 ? 0 : height - block[i];


		}
		System.out.print(answer);
	}


}

