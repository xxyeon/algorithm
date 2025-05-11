import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().split(" ");
		int h = Integer.parseInt(input[0]);
		int w = Integer.parseInt(input[1]);

		int[] block = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] leftMax = new int[w];
		int[] rightMax = new int[w];

		// 왼쪽 최대값 계산
		leftMax[0] = block[0];
		for (int i = 1; i < w; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], block[i]);
		}

		// 오른쪽 최대값 계산
		rightMax[w - 1] = block[w - 1];
		for (int i = w - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], block[i]);
		}

		// 물 계산
		int answer = 0;
		for (int i = 1; i < w - 1; i++) {
			int height = Math.min(leftMax[i - 1], rightMax[i + 1]);
			if (height > block[i]) {
				answer += height - block[i];
			}
		}

		System.out.println(answer);
	}
}
