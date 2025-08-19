
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Integer>> heavy = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> light = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for (int i = 0; i < N; i++) {
            heavy.add(new ArrayList<>());
            light.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            //A B => B->A 방향 그래프 (무거운 방향)
            // A -> B 가벼운
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            light.get(a-1).add(b-1);
            heavy.get(b - 1).add(a - 1);
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            //본인 포함 구슬 개수 반환
            int h = dfs(i, heavy);
            int l =dfs(i, light);
            if (h > (N + 1) / 2 || l > (N + 1) / 2 || h == 0 || l == 0) {
                answer++;
            }
        }
        System.out.print(answer);
    }

    private static int dfs(int start, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[N];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int i=0;i<graph.get(curr).size(); i++) {
                if (!visited[graph.get(curr).get(i)]) {
                    visited[graph.get(curr).get(i)] = true;
                    q.offer(graph.get(curr).get(i));
                }
            }
        }
        for(boolean b:visited) {
            if(b) count++;
        }
        return count;
    }

}




