import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// StringBuffer sb = new StringBuffer();
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> map = new HashMap<>();

		int n = Integer.parseInt(bf.readLine());
		for (int i = 0; i < n; i++) {
			String[] file = bf.readLine().split("\\.");

			// System.out.println(file[1]);
			map.put(file[1], map.getOrDefault(file[1], 0) + 1);

		}
		TreeSet<String> sortedSet = new TreeSet(map.keySet());
		for (String exe : sortedSet) {
			sb.append(exe).append(" ").append(map.get(exe)).append('\n');
		}
		System.out.print(sb.toString());


	}


}

