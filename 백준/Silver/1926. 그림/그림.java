import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static int  n;
    static int m;
    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //그림의 개수
                //가장 넓은거
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int[][] draw = new int[n][m];


        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                draw[i][j] = Integer.parseInt(line[j]);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int total = 0;
        int maxCnt = 0;
        //완전탐색 가능 500 * 500

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (draw[i][j] == 0 || draw[i][j] == 2) { //방문했고, 그림이 아니면 continue
                    continue;
                }
                //그림 너비 계산
                total++;
                int[] node = {i, j};
                q.add(node);
                //그림 키기재기
                int cnt = 0;
                while (!q.isEmpty() ) {

                    int[] lst = q.poll();
                    int x = lst[0];
                    int y = lst[1];


                    if (draw[x][y] == 1) { //방문안해다면
                        //칸 개수 세어주고
                        draw[x][y] = 2;
                        cnt++;
                        //주변 돌면서 방문 안곳 찾기
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                                continue;
                            }
                            int[] newLst = {nx, ny};
                            q.add(newLst);
                        }
                    }
                }
                maxCnt = Math.max(cnt, maxCnt);
//                    dfs(i, j, draw, cnt);
            }
        }
        System.out.println(total);
        System.out.println(maxCnt);
    }
}
