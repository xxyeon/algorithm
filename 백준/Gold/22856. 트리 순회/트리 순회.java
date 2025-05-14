import java.io.*;

public class Main {
	private static int move = 0;
	private static Node[] tree;
	private static int n;
	private static int lastNode;
	private static boolean arrived = false;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		tree = new Node[n + 1];
		for (int i = 0; i < n; i++) {
			String[] nodes = bf.readLine().split(" ");
			int a = Integer.parseInt(nodes[0]);
			int b = Integer.parseInt(nodes[1]);
			int c = Integer.parseInt(nodes[2]);
			tree[a] = new Node(b, c);
		}

		//맨 오른쪽에 있는 노드가 마지막 노드임
		findLastNode(1);
		inorder(1);
		System.out.println(move);
	}

	private static void inorder(int current) {
		if (arrived || current == -1) return;

		// 왼쪽 자식 방문
		if (tree[current].left != -1) {
			move++; // 왼쪽으로 이동
			inorder(tree[current].left);
			if (arrived) return;
			move++; // 다시 현재 노드로 이동
		}

		// 현재 노드 방문
		if (current == lastNode) {
			arrived = true;
			return;
		}

		// 오른쪽 자식 방문
		if (tree[current].right != -1) {
			move++; // 오른쪽으로 이동
			inorder(tree[current].right);
			if (arrived) return;
			move++; // 다시 현재 노드로 이동
		}
	}

	private static int findLastNode(int currentNode) {
		Node node = tree[currentNode];
		if (node.right == -1) {
			lastNode = currentNode;
		} else {
			findLastNode(node.right);
		}
		return lastNode;
	}
}

class Node {
	int left, right;
	Node(int left, int right) {
		this.left = left;
		this.right = right;
	}
}
