import java.io.*;
import java.util.*;

public class Main {
    static int R, C, N;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        char[][] init = new char[R][C];
        for (int i = 0; i < R; i++) {
            init[i] = br.readLine().toCharArray();
        }

        if (N == 1) {
            print(init);
            return;
        }
        if (N % 2 == 0) {
            printFull();
            return;
        }

        // t=3 상태 (초기 폭탄들이 3초째에 터질 때의 상태)
        char[][] t3 = detonate(init);
        if (N % 4 == 3) {
            print(t3);
            return;
        }

        // t=5 상태 (t3 상태에서 다시 폭발이 일어난 결과)
        char[][] t5 = detonate(t3);
        print(t5);
    }

    // grid에 있는 폭탄들이 동시에 터질 때, "전체가 폭탄인 상태"에서 제거되는 위치를 표시해 결과 리턴
    static char[][] detonate(char[][] grid) {
        char[][] res = new char[R][C];
        boolean[][] remove = new boolean[R][C];
        for (int i = 0; i < R; i++) Arrays.fill(res[i], 'O');

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 'O') {
                    remove[i][j] = true;
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d], nj = j + dy[d];
                        if (ni >= 0 && ni < R && nj >= 0 && nj < C) remove[ni][nj] = true;
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (remove[i][j]) res[i][j] = '.';
            }
        }
        return res;
    }

    static void print(char[][] g) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(g[i]);
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    static void printFull() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) sb.append('O');
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
