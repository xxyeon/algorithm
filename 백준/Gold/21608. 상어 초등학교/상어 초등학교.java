import java.io.*;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};
	private static final Map<Integer, Set> map = new LinkedHashMap<>();
	private static int[][] classroom;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		classroom = new int[n + 1][n + 1];
		// Map<SeatInteger> condition1 = new ArrayList<>();
		// List<Integer> condition2 = new ArrayList<>();
		StringTokenizer st = null;
		for (int i = 0; i < n * n; i++) {
			st = new StringTokenizer(bf.readLine());
			int student = Integer.parseInt(st.nextToken());
			map.put(student, new HashSet<>());
			for (int j = 0; j < 4; j++) {
				map.get(student).add(Integer.parseInt(st.nextToken()));
			}
		}

		//class에 학생이 위치한 자리를 알아내야함.
		// 학생 순서대로 자리 배정
		int satisfied = 0;
		for(int student : map.keySet()) {
			// System.out.println(student);
			Seat seat = findSeat(student);
			classroom[seat.x][seat.y] = student;
		}
		int result = 0;
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				int count = likesStudent(i,j,classroom[i][j]);
				// System.out.println(count);
				if(count>0) {
					result += (int) Math.pow(10, (count-1));
				}
			}

		}
		System.out.print(result);

	}

	private static Seat findSeat(int student) {
		Seat seat = null;
		for (int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if (classroom[i][j] >0) continue;
				Seat current = new Seat(i, j, likesStudent(i, j, student), getEmptySeatCount(i, j));
				if (seat == null) {
					seat = current;
					continue;
				}
				if(seat.compareTo(current) >0) seat = current;
			}

		}
		return seat;
	}


	private static int likesStudent(int x, int y, int student) {
		//현재 좌석(x, y)에서 좋아하는 사람이 인접한 수
		int count = 0;
		for (int i = 0; i < 4; i++) {
			//좋아하는 사람의 번호
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 1 || nx > n || ny < 1 || ny > n) {
				continue;
			}
			if(map.get(student).contains(classroom[nx][ny])) {
				count++;
			}
		}
		return count;

	}

	private static int getEmptySeatCount(int x, int y) {
		int count = 0;
		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 1 || nx > n || ny < 1 || ny > n) {
				continue;
			}
			if(classroom[nx][ny] == 0) count++;
		}
		return count;
	}


}
class Seat implements Comparable<Seat>{
	int x;
	int y;
	int likes;
	int emptySeat;
	Seat(int x, int y, int likes, int emptySeat) {
		this.x = x;
		this.y= y;
		this.likes = likes;
		this.emptySeat = emptySeat;
	}
	@Override
	public int compareTo(Seat other) { //우선순위가 더 높은 경우 >0
		if (this.likes != other.likes) return other.likes - this.likes;//오름
		if(this.emptySeat != other.emptySeat) return other.emptySeat - this.emptySeat;
		if(this.x != other.x) return this.x - other.x;//행의 번호 작은 순
		return this.y - other.y;
	}
}

