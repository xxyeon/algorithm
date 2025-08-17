
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int dis = 0;
    static int count = 0;
    static int number = -1;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input  = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N];
        distance = new int[N];

        for(int i=0;i<M;i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            graph.get(a-1).add(b-1);
            graph.get(b-1).add(a-1);
        }

        bfs();
        
        for(int i = 0; i<N; i++) {
            if (distance[i] == dis) {
                count++;
                if(number == -1) number = i+1;
            }

        }
        System.out.print(number + " " + dis + " " + count);
    }
   static void bfs() {
       Queue<Integer> q = new LinkedList<>();
       q.offer(0);
       visited[0] = true;
       distance[0] = 0;
       while(!q.isEmpty()) {
           int cur = q.poll();
           for(int i=0;i<graph.get(cur).size();i++) {
               if(!visited[graph.get(cur).get(i)]) {
                   q.offer(graph.get(cur).get(i));
                   visited[graph.get(cur).get(i)] = true;
                   distance[graph.get(cur).get(i)] = distance[cur]+1;
                   dis = Math.max(dis, distance[graph.get(cur).get(i)]);
               }
           }
       }
   }

}

