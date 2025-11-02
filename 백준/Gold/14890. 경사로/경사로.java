import java.io.*;
import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static boolean[][] visited;
    static boolean[][] colBlock;
    static boolean[][] rowBlock;
    static int[][] map;
    static int[] dx = {0, 0, 1,-1};
    static int[] dy = {1, -1, 0, 0};
    static int N, L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][N];
        colBlock = new boolean[N][N];
        rowBlock = new boolean[N][N];

        int cnt = 0;
        //가로
        for (int row = 0; row < N; row++) {
            boolean result = true;
            for (int col = 0; col < N - 1; col++) {
                int diff = map[row][col] - map[row][col + 1];
                if(Math.abs(diff) > 1) {
                    result = false;
                    break;
                }
                if (diff == -1) {
                    //오르막 오른쪽이 더 높음
                    for (int j = col; j > col - L; j--) {
                        if (j < 0 || map[row][j] != map[row][col] || colBlock[row][j]) {
                            result = false;
                            break;
                        }
                    }
                    if(result) {
                        for (int j = col; j > col - L; j--) {
                            colBlock[row][j] = true;
                        }
                    }

                } else if (diff == 1) {
                    //내리막 -> 오른쪽이 더 낮음
                    for (int j = col+1; j <= col + L; j++) {
                        if (j >= N || map[row][j] != map[row][col+1] || colBlock[row][j]) {
                            result = false;
                            break;
                        }
                    }
                    if(result) {
                        for (int j = col+1; j <= col + L; j++) {
                            colBlock[row][j] = true;
                        }
                    }
                }
            }
            if (result) cnt++;


        }
        //세로

        for (int col = 0; col < N; col++) {
            boolean result = true;
            for (int row = 0; row < N - 1; row++) {

                int diff = map[row][col] - map[row+1][col];
                if(Math.abs(diff) > 1) {
                    result = false;
                    break;
                }


                if (diff == -1) {
                    //오르막 -> 아래가 더 높음
                    for (int j = row; j > row - L; j--) {
                        if (j < 0 || map[j][col] != map[row][col] || rowBlock[j][col]) {
                            result = false;
                            break;
                        }
                    }
                    if(result) {
                        for (int j = row; j > row - L; j--) {
                            rowBlock[j][col] = true;
                        }
                    }
                } else if (diff == 1) {
                    //내리막 -> 아래가 더 낮음
                    for (int j = row+1; j <= row + L; j++) {
                        if (j >= N || map[j][col] != map[row+1][col] || rowBlock[j][col]) {
                            result = false;
                            break;
                        }
                    }
                    if(result) {
                        for (int j = row+1; j <= row + L; j++) {
                            rowBlock[j][col] = true;
                        }
                    }
                }
            }
            if (result) cnt++;

        }
        System.out.print(cnt);

    }
}
