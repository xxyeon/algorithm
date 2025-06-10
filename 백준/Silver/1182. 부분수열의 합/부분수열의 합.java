import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int[] arr;
	private static int num;
	private static int answer = 0;
	private static int s;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		s = Integer.parseInt(input[1]);
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		recursion(0,0);
		if(s==0) answer-=1;
		System.out.print(answer);
	}

	public static void recursion(int sum, int index) {

		if(index == n) {
			if(sum == s) {
				answer++;
			}
			return;

		}
		recursion(sum + arr[index], index+1); //다음거 선택
		recursion(sum, index+1); //다음꺼 패스

	}


}