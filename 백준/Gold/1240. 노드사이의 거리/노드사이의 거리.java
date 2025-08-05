import javax.swing.plaf.BorderUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int index, cost;
    Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
}
public class Main {
    static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
    static int start, end;
    static int n, m;
    static int cost;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for(int i=0; i<n+1;i++) {
            tree.add(new ArrayList<>());
        }
        for(int i=0; i<n-1;i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            tree.get(edge[0]).add(new Node(edge[1], edge[2]));
            tree.get(edge[1]).add(new Node(edge[0], edge[2]));
        }
//        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m ;i++){
            int[] nodes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            start = nodes[0];
            end = nodes[1];
            cost = 0;
            dfs(new Node(start, 0), 0, 0);
//            sb.append(cost).append('\n');
        }
        System.out.print(sb.toString());
    }
    public static void dfs(Node curr, int parent, int cost) {
        if(curr.index == end) {
            sb.append(cost).append('\n');
            return ;
        }
        for(Node next : tree.get(curr.index)) {
            if(next.index != parent) {

                dfs(next, curr.index, cost + next.cost);
            }
        }

    }


}
