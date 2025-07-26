import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0}; // 우, 상, 좌, 하
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int d = Integer.parseInt(input[2]);
            int g = Integer.parseInt(input[3]);

            drawDragonCurve(x, y, d, g);
        }

        int count = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(visited[i][j] && visited[i+1][j] && visited[i][j+1] && visited[i+1][j+1]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void drawDragonCurve(int x, int y, int d, int g) {
        ArrayList<Integer> dirs = new ArrayList<>();
        dirs.add(d);

        for(int i = 0; i < g; i++) {
            for(int j = dirs.size() - 1; j >= 0; j--) {
                dirs.add((dirs.get(j) + 1) % 4);
            }
        }

        visited[x][y] = true;
        for(int dir : dirs) {
            x += dx[dir];
            y += dy[dir];
            if(x >= 0 && x <= 100 && y >= 0 && y <= 100)
                visited[x][y] = true;
        }
    }
}
