import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
import java.util.ArrayList;
public class Main {
	private static int n;
	private static int m;
	private static boolean[] visited;
	private static Map<String, List<Node>> tree = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input = bf.readLine().split(" ");
		n = Integer.parseInt(input[0]); //폴더 개수
		m = Integer.parseInt(input[1]);//파일 개수


		for (int i=0; i < m+n; i++) {
			String[] files = bf.readLine().split(" ");
			//파일 명 인덱스화
			String parent = files[0].intern();
			String child = files[1].intern();
			int isFolder = Integer.parseInt(files[2]);


			tree.putIfAbsent(parent, new ArrayList<>());
			tree.get(parent).add(new Node(child, isFolder == 1));


		}
		int q = Integer.parseInt(bf.readLine());
		for (int i = 0; i < q; i++) {
			String[] query = bf.readLine().split("/");
			String folder = query[query.length - 1];
			//folder를 기준으로 탐색

			Set<String> fileSet = new HashSet<>();
			int count = dfs(query[query.length-1], 0, fileSet);
			sb.append(fileSet.size()).append(" ").append(count).append('\n');

		}
		System.out.print(sb.toString());
	}

	//dfs해서 자식 중에 file 종류와 개수 세기
	private static int dfs(String start, int count, Set<String> fileSet) {

		Stack<String> stack = new Stack<>();
		stack.push(start);
		while(!stack.isEmpty()) {
			String now = stack.pop();

			if(tree.get(now) == null) continue;

			for(Node child: tree.get(now)) {

				if(!child.isFolder) {
					count++;
					fileSet.add(child.name);
				} else {

					stack.push(child.name); //폴더일 경우에만 stack에 넣어주기
				}

			}
		}
		return count;
	}


}

class Node {
	boolean isFolder; //1이면 folder
	String name;
	Node( String name, boolean isFolder) {
		this.isFolder = isFolder;
		this.name = name;
	}
}
