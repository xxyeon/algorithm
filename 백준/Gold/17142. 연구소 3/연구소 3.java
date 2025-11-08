import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static ArrayList<ArrayList<int[]>> combinations = new ArrayList<>();
    static int N, M;
    static int[][] lab;
    static int[][] pos;
    static boolean[] isSelected;
    static boolean[][] visited;
    static ArrayList<int[]> virus = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][N];

        pos = new int[M][2];

        visited = new boolean[N][N];
        int cnt = 0;

        for(int i=0; i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N;j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if(lab[i][j] == 2) {
                    //바이러스 위치 저장
                    virus.add(new int[]{i, j});
                }
            }
        }
        isSelected = new boolean[virus.size()];
        combination(0, new ArrayList<>());
        //바이러스 위치에 대한 조합을 만들어 놓았으므로 바이러스 위치는 0으로 바꿔주기
        int answer = Integer.MAX_VALUE;

        for(ArrayList<int[]> comb : combinations) {

            answer =  Math.min(bfs(comb), answer);
        }
        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.print(answer);

    }
    private static void combination(int start, ArrayList<int[]> arr) {
        if (arr.size() == M) {
            combinations.add(new ArrayList<>(arr));
            return;
        }
        for (int i = start; i < virus.size(); i++) {
            arr.add(virus.get(i));
            combination(i + 1, arr);
            arr.remove(arr.size() - 1);
        }
    }

    private static int bfs(ArrayList<int[]> arr) {
        int max = 0;
        int[][] time = new int[N][N];
        for(int i=0;i<N; i++) {
            Arrays.fill(time[i], -1);
        }
        Queue<int[]> q = new LinkedList<>();
        for(int[] a : arr) {
            //바이러스위치
            q.offer(a);
            time[a[0]][a[1]] = 0;
        }
        while(!q.isEmpty()) {
            int[] now = q.poll();
            for(int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >=N) {
                    continue;
                }
                if(time[nx][ny] == -1 && lab[nx][ny] != 1) {
                    //제일 처음에 전파한 바이러스가 선점
                    time[nx][ny] = time[now[0]][now[1]] + 1;

                    q.offer(new int[]{nx, ny});
                }
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(lab[i][j] == 0 && time[i][j] == -1) {
                    //빈칸인데 바이러스가 퍼지지 않았다면
                    return Integer.MAX_VALUE;
                }
                if(lab[i][j] == 0) {
                    max = Math.max(max,time[i][j]);
                }
            }
        }
        return max;
    }

}
