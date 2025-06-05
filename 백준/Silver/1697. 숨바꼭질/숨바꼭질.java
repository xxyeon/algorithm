import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


class Move {
	int position;
	int sec;
	Move(int position, int sec) {
		this.position = position;
		this.sec = sec;
	}
}
public class Main {
	static private int[] move = new int[3];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int x = position[0];
		int k = position[1];


		//1차원 배열을 k 또는 n큰걸로 크기 설정
		//움직일 때마다 해당 요소에 시간 기록, 현재 요소 기록된 시간보다 크면 패스, 작으면 기록 후 큐에 넣기
		int[] second;
		if (k < x) {
			second = new int[x*2+1];
			Arrays.fill(second, x+1);
		} else {
			second = new int[k*2+1];
			Arrays.fill(second, k+1);
		}

		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		second[x] = 0;
		while(!q.isEmpty()) {
			int n = q.poll();
			if (n == k) {
				System.out.print(second[n]);
				break;
			}
			//3가지 방향
			move[0] = n-1;
			move[1] = n+1;
			move[2] = n*2;
			for(int i=0; i<3; i++) {
				if (0 > move[i] || second.length <= move[i]) continue;
				if(second[move[i]] > second[n] + 1) {
					second[move[i]] = second[n] + 1;
					q.offer(move[i]);
				}
			}
		}
	}

}