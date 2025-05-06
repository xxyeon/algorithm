import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int max = Integer.MIN_VALUE;
		Map<Integer, Integer> map = new HashMap<>();

		for(int num : arr) {
			map.put(num, 0);
		}

		int start = 0;
		int end = 0;
		while(end < n) {
			// System.out.println("end: " +  end );
			if (map.get(arr[end]) + 1 > k) {
				// System.out.println("start: " + start);
				while (true) {
					if(arr[start] == arr[end]) { //end를 옮길 수 있게 start가 가리키는 정수가 k개 안넘도록
						// System.out.println("map.get(arr[end]): " + map.get(arr[end]));
						// System.out.println("map.get(arr[start]): " + map.get(arr[start]));
						map.put(arr[start], map.get(arr[start]) - 1);
						start++;
						break;
					}
					map.put(arr[start], map.get(arr[start]) - 1);
					start++;
				}
			}
			map.put(arr[end], map.get(arr[end]) + 1);
			end++;
			max = Math.max(max, end - start); //start 포함 ~ end-1 포함

			// System.out.println(map.toString());
		}


		System.out.println(max);
	}

}
