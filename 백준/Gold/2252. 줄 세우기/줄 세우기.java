
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]) -1;
            int b = Integer.parseInt(edge[1]) - 1;
            graph.get(a).add(b);
            indegree[b]++;
            //방향 그래프
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();

        while(!q.isEmpty()) {
            int now = q.poll();
            result.add(now+1);
            for(int i=0; i<graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)]--;
                if (indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}




