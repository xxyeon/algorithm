import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bf.readLine());
		int[] calender = new int[366];
		for(int i =0;i<n;i++) {
			String[] input = bf.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);

			for(int k = start; k < end+1; k++) {
				calender[k] += 1;
			}
		}
		int height = 0;
		int width = 0;
		int answer = 0;

		for (int i = 1; i < 366; i++) {
			if (calender[i] == 0) {
				answer += height * width;
				height = 0;
				width = 0;
			} else {
				width += 1;
				height = Math.max(height, calender[i]);
			}
		}

		//마지막날에(365) 일정이 있는 경우
		if (height !=0) {
			answer += height * width;
		}
		System.out.print(answer);
	}

}

