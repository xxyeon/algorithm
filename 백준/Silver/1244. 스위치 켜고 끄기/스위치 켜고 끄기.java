import java.io.*;
import java.util.Arrays;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String answer = "";
		int n = Integer.parseInt(bf.readLine());
		int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int num = Integer.parseInt(bf.readLine());

		for(int i = 0; i < num; i++) {
			String[] input = bf.readLine().split(" ");
			int gender = Integer.parseInt(input[0]);
			int studentId = Integer.parseInt(input[1]);
			if (gender == 1) {
				//boy
				boy(arr, studentId);
			} else {
				girl(arr, studentId);
			}

		}
		// System.out.println(sb.toString());
		for(int i = 0; i < n; i++) {
			if (i >= 20 && i % 20 == 0) { //20개
				sb.append('\n');
			}
			sb.append(arr[i]).append(" ");
		}
		System.out.print(sb.toString());
	}

	private static void boy(int[] arr, int number) {
		for(int i = 1; i < arr.length+1; i++) {
			if(i%number == 0) {
				arr[i-1] = 1 ^ arr[i-1];
			}
		}
	}

	private static void girl(int[] arr, int number) {
		int x = 1;
		while (number - x-1 >= 0 && number + x-1 < arr.length && arr[number - x-1] == arr[number + x-1]) {
			arr[number-x-1] = arr[number-x-1] ^ 1;
			arr[number+x-1] = arr[number+x-1] ^ 1;
			x++;
		}
		arr[number-1] = arr[number-1] ^ 1;

	}


}
