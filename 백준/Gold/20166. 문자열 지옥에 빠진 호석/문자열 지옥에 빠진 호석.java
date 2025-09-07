import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Position {
    int  x, y;
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static char[][] graph;
    static int K;
    static int N, M;
    static TreeMap<String, Integer> count = new TreeMap<>();
    static char[][] init;
    static int[][] direction = {
        {0, 1}, {0,-1},{1, 0},{-1,0}, {-1,-1}, {-1,1}, {1,-1}, {1,1}
    };



    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        init = new char[N][M];
        for(int i=0; i<N; i++) {
            char[] t = br.readLine().toCharArray();
            for(int j=0; j <M;j++) {
                init[i][j] = t[j];
            }
        }

        makeStr();

        for(int i=0; i<K;i++) {
            String str = br.readLine();
            int num = count.getOrDefault(str,0);
            sb.append(num).append('\n');
        }
        System.out.print(sb.toString());
    }

    public static void makeStr() {
        for(int i=1; i<=5; i++) {
            for(int x=0;x<N;x++) {
                for(int y=0; y<M; y++) {
                    permutation(x, y, 1, i, String.valueOf(init[x][y]));
                }
            }
        }
    }

    public static void permutation(int x, int y, int idx, int len, String str) {
        if(len == idx) {
            count.put(str, count.getOrDefault(str, 0) + 1);
            return;
        }
        for (int[] dir : direction) {
            int nx = (x + dir[0] + N) % N;
            int ny = (y + dir[1] + M) % M;


            permutation(nx, ny, idx + 1, len, str + init[nx][ny]);
        }
    }
}
