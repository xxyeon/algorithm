import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// StringBuffer sb = new StringBuffer();
		String[] input = bf.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		int[]train = new int[n];
		for (int i =0; i < m; i++) {
			int[] order = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			if (order[0] == 1 || order[0] == 2) {
				orderProcess(order[1], order[2], train, order[0]);
			} else {
				orderProcess(order[1], train, order[0]);
			}

		}
		Set<Integer> set = new HashSet<>();

		for(int i = 0; i < n; i++) {
			set.add(train[i]);
		}

		System.out.print(set.size());


	}

	private static void orderProcess(int trainNum, int chairNum, int[] train, int order) {
		switch (order){
			case 1 : {
				train[trainNum-1] |= (1 << (chairNum-1));
				break;
			}


			case 2: {
				train[trainNum - 1] &= ~(1 << (chairNum - 1));
				break;
			}


		}
	}
	private static void orderProcess(int trainNum, int[] train, int order) {
		switch (order) {
			case 3 : {
				train[trainNum-1] <<= 1; //뒤로 한칸 옮기고 작은 번호 -> 큰 번호
				train[trainNum-1] &= (1 << 20) - 1; //20자리로 끊기
				break;
			}
			case 4: {
				train[trainNum - 1] >>= 1; //앞으로
				break;
			}
		}

	}
}

