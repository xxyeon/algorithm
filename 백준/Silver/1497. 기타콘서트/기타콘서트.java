import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

	private static Map<String, char[]> info = new LinkedHashMap<>();
	private static Map<String, Boolean> isUsed = new HashMap<>();
	private static int[] possible;
	private static int answer;
	private static int n;
	private static int m;
	private static int use;
	private static int songAns = 0;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		possible = new int[m];


		for(int i=0; i<n; i++) {
			String[] guitar = br.readLine().split(" ");
			char[] song = guitar[1].toCharArray();
			String name = guitar[0];
			info.put(name, song);
			isUsed.put(name, false);
		}

		answer = n;
		dfs();
		if(songAns == 0) answer = -1;
		System.out.print(answer);

	}

	private static void dfs() {
		// if (use == n && songAns == 0) {
		// 	//기타 모두 사용했는데
		//
		// 	answer = -1;
		// 	return;
		// }
		int sum = 0; //기타 하나라도 사용했을 경우에만.. 안그러면 초기에 songAns = 0, sum = 0으로 answer = 0으로 된다.
		for (int i : possible) {
			if(i>0) {
				sum++;
			}
		}
		if (use >= 1 && sum >= 1) {//연주할 수 있는 곡이 1개라도 있다면

			if (songAns < sum) {
				//더 많은 곡을 연주할 수 있다면
				answer = use; //기타 개수 업데이트
				songAns = sum;

			} else if (songAns == sum) { //기타를 사용했지만 songAns=0인 경우는 제외
				//동일한 개수 연주할 수 있으면
				answer = Math.min(answer, use);

			}
		}


		for (String name : info.keySet()) {//각 기타가 연주할 수 있는 곡
			if (isUsed.get(name)) { //이미 사용한 기타라면
				continue;
			}
			char[] songs = info.get(name);
			isUsed.put(name, true);
			use++;
			for (int i = 0; i < songs.length; i++) {

				if (songs[i] == 'N') {
					continue;
				}
				possible[i]++; //연주 가능한 곡에만 1 표시, 만일 중복 해서 연주할 수 있는 곡이라면 이전에 사용한 기타로 연주할 수 있는 곡이더라도 못한다고 표시됨.
			}
			dfs();
			for (int i = 0; i < songs.length; i++) {

				if (songs[i] == 'N') {
					continue;
				}
				possible[i]--; //연주 가능한 곡 다시 원래대로 돌려놓기 표시
			}
			use--;
			isUsed.put(name, false);
		}
	}
	//최대한 많은 곡을 제대로 연주... 최소개수

}