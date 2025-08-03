import javax.swing.plaf.BorderUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



      //simple path가 아닌 것은 부모를 초기화 했는데 또 다른 부모가 있을 수 있다.
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(true) {
            String[] input = br.readLine().split(" ");
            // 각 테스트 케이스마다 노드와 간선 수 입력 받기
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            if(n == 0 && m == 0) break;
            parent = new int[n+1];
            for(int i=1; i<n+1; i++) {
                parent[i] = i;
            }
            tree = new ArrayList<>();
            for(int i=0;i<n+1;i++) {
                tree.add(new ArrayList<>());
            }
            for(int i=0;i<m;i++) {
                String[] edge = br.readLine().split(" ");
                int a = Integer.parseInt(edge[0]);
                int b = Integer.parseInt(edge[1]);
                tree.get(a).add(b);
                tree.get(b).add(a);
            }
            int count = 0;
            for(int i=1;i<n+1; i++) {
                if (parent[i] == i) {
                    if(isTree(i)) count++;
                }
            }
            String output = "";
            if(count == 0) output = "No trees.";
            else if(count == 1) output = "There is one tree.";
            else output = "A forest of " + count + " trees.";
            sb.append("Case ").append(++index).append(": ").append(output).append('\n');

        }
        System.out.println(sb.toString());
    }

    private static boolean isTree(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int data = q.poll();
            for (int next : tree.get(data)) {
                if(parent[data] == next) {
                    //본인이 부모라면 건너뛰기
                    continue;
                }
                if(parent[next] != next) {
                    //현재 노드와 인접한 노드가 이미 부모가 있다
                    return false;

                }

                //data의 자식을 큐에 넣어준다.
                q.offer(next);
                parent[next] = data;
            }
        }
        return true;
    }



}
