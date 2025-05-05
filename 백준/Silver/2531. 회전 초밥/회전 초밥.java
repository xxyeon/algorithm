import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] sushi = new int[n];
		for (int i = 0; i < n; i++) {
			sushi[i] = Integer.parseInt(bf.readLine());
		}

		int[] count = new int[d + 1]; // 초밥 종류 카운트
		int kind = 0;

		// 초기 윈도우 설정
		for (int i = 0; i < k; i++) {
			if (count[sushi[i]]++ == 0) kind++;
		}

		int max = (count[c] == 0) ? kind + 1 : kind;

		// 슬라이딩 윈도우
		for (int i = 1; i < n; i++) {
			// remove the leftmost sushi
			if (--count[sushi[i - 1]] == 0) kind--;

			// add the next sushi
			int next = sushi[(i + k - 1) % n];
			if (count[next]++ == 0) kind++;

			int total = (count[c] == 0) ? kind + 1 : kind;
			max = Math.max(max, total);
		}

		System.out.println(max);
	}
}
