import javax.swing.plaf.BorderUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int q = Integer.parseInt(input[2]);
        for(int i=0; i<n+1; i++) {
            tree.add(new ArrayList<>());
        }
        size = new int[n + 1];
        for(int i=0; i<n-1;i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
            //무방향이므로 양쪽에 넣어주기
        }
        dfs(r, 0);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<q; i++) {
            int query = Integer.parseInt(br.readLine());
            sb.append(size[query]).append('\n');

        }
        System.out.print(sb.toString());
    }
    private static void dfs(int curr, int parent) {
        size[curr] = 1;
        for(int next : tree.get(curr)) {
            if(next != parent) {
                dfs(next, curr);
                size[curr] += size[next];
            }
        }
    }
}
