import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] line = bf.readLine().toCharArray();
		boolean isTag = false;
		List<Character> list = new ArrayList<>();

		for (char ch : line) {
			if (ch == '<') {
				// 단어가 끝났다면 뒤집어 추가
				if (!list.isEmpty()) {
					sb.append(flip(list));
					list.clear();
				}
				isTag = true;
				sb.append(ch);
			} else if (ch == '>') {
				isTag = false;
				sb.append(ch);
			} else if (isTag) {
				sb.append(ch);
			} else {
				if (ch == ' ') {
					sb.append(flip(list)).append(' ');
					list.clear();
				} else {
					list.add(ch);
				}
			}
		}

		// 마지막 단어 처리
		if (!list.isEmpty()) {
			sb.append(flip(list));
		}

		System.out.println(sb.toString());
	}

	private static String flip(List<Character> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = list.size() - 1; i >= 0; i--) {
			sb.append(list.get(i));
		}
		return sb.toString();
	}
}
