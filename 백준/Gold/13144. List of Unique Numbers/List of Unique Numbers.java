import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		long answer = 0;
		int n = Integer.parseInt(bf.readLine());
		int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int start = 0;
		int end = 0;
		Set<Integer> set = new HashSet<>();

		//star ~ end-1까지 포함
		while (end < n) {
			if(!set.contains(arr[end])) {
				set.add(arr[end++]);
				answer += end - start;
			} else {
				set.remove(arr[start++]);
			}
		}
		System.out.print(answer);
		bf.close();
	}




}