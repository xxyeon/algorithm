
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        ArrayList<Integer> result = new ArrayList<>();
        int[] indegree = new int[N];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] num = br.readLine().split(" ");
            graph.get(Integer.parseInt(num[0]) - 1).add(Integer.parseInt(num[1]) - 1);
            indegree[Integer.parseInt(num[1])-1]++;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<N;i++) {
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
            int now = q.poll();
            result.add(now+1);
            for(int i=0;i<graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)]--;
                if(indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }
        for(int a : result) {
            System.out.print(a + " ");
        }
    }
}