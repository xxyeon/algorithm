import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int max = Integer.MIN_VALUE;
		int n = input[0];
		int d = input[1];
		int k = input[2];
		int c = input[3];

		int[] arr = new int[n*2];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		for(int i = n; i < n*2; i++) {
			arr[i] = arr[i-n];
		}

		int start = 0;
		int end = 0;
		int kind = 0;

		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 1; i < d+1; i++) {
			map.put(i, 0);
		}
		map.put(c, 1);
		while (start < n) {
			if(kind == k) {
				// System.out.println(set.toString());
				//map에서 0이 아닌 것들 세기
				int cnt = 0;
				for(int value : map.values()) {
					if (value != 0) {
						cnt++;
					}
				}
				max = Math.max(max, cnt);
				// max = set.contains(c) ? Math.max(max, set.size()) : Math.max(max, set.size() + 1);
				// set.remove(arr[start++]);
				map.put(arr[start], map.get(arr[start]) - 1);
				start++;
				kind--;
			} else {
				map.put(arr[end], map.get(arr[end]) + 1);
				end++;
				kind++;
			}
		}
		System.out.println(max);
	}

}
