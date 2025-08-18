
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[] visited;

    static int dis = 0;
    static int count = 0;
    static int number = -1;
    static int[] distance;
    static boolean answer = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<K;i++){
            String[] input  = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int n = 0; n < N; n++) {
                graph.add(new ArrayList<>());
            }
            visited = new int[N];
            for (int j = 0; j < M; j++) {
                String[] edge = br.readLine().split(" ");
                int a = Integer.parseInt(edge[0]);
                int b = Integer.parseInt(edge[1]);
                graph.get(a - 1).add(b - 1);
                graph.get(b - 1).add(a - 1);
            }
            answer = true;
            for(int k=0;k<N;k++){
                if(visited[k] == 0) {
                    bfs(graph, k);
                }
            }

            if(!answer) {
                sb.append("NO").append('\n');
            }else {
                sb.append("YES").append('\n');
            }
        }

        System.out.print(sb.toString());
    }
   static void bfs(ArrayList<ArrayList<Integer>> graph, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 1; //빨 //파란색은 -1
       while(!q.isEmpty()) {
           int cur = q.poll();
           int color = visited[cur] == -1 ? 1 : -1;
           for(int i=0;i<graph.get(cur).size();i++) {
               if(visited[graph.get(cur).get(i)] == 0){
                   visited[graph.get(cur).get(i)] = color;
                   q.offer(graph.get(cur).get(i));
               }
               else if(visited[graph.get(cur).get(i)] != color) {
                   answer = false;
                   return;
               }

           }
       }

   }
}
