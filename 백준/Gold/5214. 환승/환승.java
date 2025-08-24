import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static HashSet<Integer> knownSet = new HashSet<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //graph[i] => i번 역에 연결된 하이버튜프
    static int[][] hypertube;
    static boolean[] visited;
    static boolean[] isHypertube;
    static int answer = 0;
    static int[] dis;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        hypertube = new int[M][K];
        visited = new boolean[N+1];
        isHypertube = new boolean[M];
        dis = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            hypertube[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int num : hypertube[i]) {
                graph.get(num).add(i); //num 번 역으로 갈 수 있는 하이퍼튜브
            }
        }
        bfs();
        System.out.print(dis[N] == 0 ? -1 : dis[N]);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);//1번 역에서 시작
        visited[1] = true;
        dis[1] = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();

            if(curr == N) {
                return;
            }
            //curr에 연결된 하이퍼튜브
            for(int num : graph.get(curr)) {
                if(isHypertube[num]) continue;
                isHypertube[num] = true;
                for (int station : hypertube[num]) { //k번
                    if(!visited[station]){
                        visited[station] = true;
                        dis[station] = dis[curr] + 1;
                        q.offer(station);
                    }

                }
            }
        }
    }


}
