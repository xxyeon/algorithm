import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
	private static final int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		char[] line = bf.readLine().toCharArray();
		boolean isTag = false;
		List<Character> list = new ArrayList<>();
		for (char ch : line) {
			if (ch == '<') {
				isTag = true;
			} else if (ch == '>') {
				isTag = false;
				sb.append(ch);
				continue;
			}
			if (isTag) {
				if (!list.isEmpty()) {
					String word = flip(list);
					sb.append(word);
					list.clear();
				}
				sb.append(ch);

			} else { //태그가 아니라면
				if (ch == ' ') {
					sb.append(flip(list)).append(' ');
					list.clear();
				} else {
					list.add(ch);
				}
			}

		}
		//마지막 단어(마지막엔 공백이 없으므로 sb에 append안됨
		if (!list.isEmpty()) {
			sb.append(flip(list));
		}


		System.out.println(sb.toString());


	}

	private static String flip(List<Character> list) {
		String word = "";
		for(int i = list.size()-1; i >= 0; i--) {
			// System.out.println(list.get(i));
			word += list.get(i);
		}
		return word;
	}

}

