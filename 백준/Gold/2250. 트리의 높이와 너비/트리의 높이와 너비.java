
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int left;
    int right;
    Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class Main {
    static int[] min;
    static int[] max;
    static int number;
    static Node[] tree;
    static int n;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new Node[n+1];
        min = new int[n+1];
        max = new int[n + 1];
        parent = new int[n+1];
        for (int i = 0; i < n; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = edge[0];
            int b = edge[1];
//            if(find(a-1) != find(b-1)) {
//                union(a-1, b-1);
//            }
            int c = edge[2];
            if(c!= -1) parent[c] = a;
            if (b != -1) parent[b] = a;
            tree[a] = new Node(b, edge[2]); //tee[i].left: i의 왼쪽 자식
        }
        int root = 0;
        for(int i=1;i<n+1; i++) {
            if(parent[i] == 0) {
                root = i;
            }
        }

        Arrays.fill(min, Integer.MAX_VALUE);
        //부모가 없는 루트 노드를 먼저 찾아야함.
        //union-find로 트리 구성하고


        inOrder(tree[root], 1); //트리의 부모노드가 1이라고 보장하지 않음, 레벨이 1이라고 한거..
        int result = 0;
        int level = 0;
        for(int i=1;i<n+1;i++) {
            int temp = max[i] - min[i] + 1;
            if (result < temp) {
                result = temp;
                level = i;
            }
        }
        System.out.print(level + " " + result);
    }
    public static void inOrder(Node node, int depth) {
        if(node.left != -1) {
            inOrder(tree[node.left], depth + 1);
        }
        min[depth] = Math.min(min[depth], number);
        max[depth] = Math.max(max[depth], number);
        number++;
        if(node.right != -1) {
            inOrder(tree[node.right], depth + 1);
        }
    }

    public static int find(int index) {
        if(parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
    public static void union(int a, int b) {
        int a1 = find(a);
        int b1 = find(b);
        if(a1 > b1) {
            parent[a1] = b1;
        } else {
            parent[b1] = a1;
        }
    }
}

