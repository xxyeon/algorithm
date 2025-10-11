import java.io.*;
import java.util.*;

class Building {
    int number, time;
    public Building(int number, int time) {
        this.number = number;
        this.time = time;
    }
}

public class Main {

    static int n;
    static int k;
    static int t;
    static int[] time;
    static int[] indegree;
    static int[] buildTime;
    static ArrayList<ArrayList<Building>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while(t > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            time = new int[n];
            indegree = new int[n];
            buildTime = new int[n];
            String[] times = br.readLine().split(" ");
            for(int i=0;i<n;i++) {
                time[i] = Integer.parseInt(times[i]);
                graph.add(new ArrayList<>());

            }

            for(int i=0; i<k;i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph.get(x - 1).add(new Building(y - 1, time[y - 1]));
                indegree[y-1]++;
            }
            int targetNumber = Integer.parseInt(br.readLine());
            bfs();
            sb.append(buildTime[targetNumber - 1]).append('\n');

            t--;
        }
        System.out.print(sb.toString());

    }
    private static void bfs() {

        Queue<Building> q = new LinkedList<>();
        for(int number=0;number<n;number++) {
            if(indegree[number] == 0) {
                q.offer(new Building(number, time[number]));
                buildTime[number] = time[number];
            }
        }

        while(!q.isEmpty()) {
            Building now = q.poll();
            for(Building b : graph.get(now.number)) {
                indegree[b.number]--;
                if (buildTime[now.number] + b.time > buildTime[b.number]) {
                    buildTime[b.number] = buildTime[now.number] + b.time;
                }
                if(indegree[b.number] == 0) {
                    q.offer(b);
                }
            }
        }
    }


}
