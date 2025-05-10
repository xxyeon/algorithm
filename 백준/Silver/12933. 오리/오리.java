import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Main {
	private final static char[] cry = "quack".toCharArray();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int answer = 0;
		char[] input = bf.readLine().toCharArray();
		boolean[] visited = new boolean[input.length];

		if (input.length % 5 != 0 || input[0] != 'q' ) {
			System.out.print(-1);
			return;
		}
		
		int idx = 0;
		for (int i = 0; i<input.length; i++) {
			List<Character> list = new ArrayList<>();
			for (int j=0; j< input.length; j++) {
				if (!visited[j] && input[j] == cry[idx]) {//울음소리가 순서대로 녹음되었다면
					idx++; //울음소리 순서
					list.add(input[j]);
					visited[j] = true;
				}
				if(idx == 5) { //울음이 한번 녹음 되었다면 다음 울음 찾기
					idx = 0;
				}
			}
			if(!list.isEmpty()) {
				if(list.size() % 5 != 0) { //울음이 제대로 녹음되지 않았다면
					answer = -1;
					break;
				} else {
					answer += 1;
				}
			}
		}
		System.out.print(answer);
	}
}

