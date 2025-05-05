import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		List<Integer> list = new ArrayList<>();
		int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int n = input[0];
		int k = input[1];

		long[] arr = Arrays.stream(bf.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		int start = 0;
		int end = 0;
		int max = Integer.MIN_VALUE;
		int cnt = 0;
		int position = 0;

		while(end < n) {
			if (arr[end] % 2 != 0) { //end가 홀수를 가리키고
				if (cnt == k) { //이미 정해진 개수만큼 제거했다면 start 옮기기
					// start = position+1;
					//start+1~end-1사이에서 처음 만난 홀수바로 앞에 start위치 시키기

					if (arr[start++] % 2 != 0) {
						cnt--;
					}

				} else if (cnt<k) { //제거할 수 있다면
					cnt++;
					// position = end;
					end++;
					max = Math.max(max, end-start-cnt);
				}
			}else {
				end++;
				max = Math.max(max, end-start-cnt);
			}
		}
		if (end == n && start == 0 && cnt < k) {
			max = n-cnt;
		}

		System.out.println(max);
	}

}
