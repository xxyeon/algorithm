
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        indegree = new int[n];
        for (int i = 0; i < m; i++) {
            int[] order = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = order[0];
            for(int j=count;j>1;j--) {
                graph.get(order[j-1]-1).add(order[j]-1);
                indegree[order[j]-1]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n;i++) {
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
            int now = q.poll();
            result.add(now);
            for(int i=0; i<graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)]--;
                if(indegree[graph.get(now).get(i)] ==0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }
        if(result.size() != n) {
            System.out.print(answer);
        } else {
            for (int order : result) {
                System.out.println(order+1);
            }
        }
    }
}