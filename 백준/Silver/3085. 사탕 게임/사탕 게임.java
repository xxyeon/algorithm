import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] candy;
    static char[] colors = {'C', 'D', 'Z', 'Y'};
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        candy = new char[n][n];
        for(int i=0; i<n; i++) {
            candy[i] = br.readLine().toCharArray();
        }
        LinkedList<Character> deque = new LinkedList<>();
        int max = 1;
        for(int i=0; i<n;i++) {
            for(int j=0; j<n; j++) {

                for(int d=0; d<4; d++) { //동서남북 인접한 칸 swap 해보기
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    //swap
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    char temp = candy[i][j];
                    candy[i][j] = candy[nx][ny];
                    candy[nx][ny] = temp;
                    //핼,열 검사
                    int cnt = 1; //처음 시작 사탕 포함
                    for (int c = 0; c<n-1; c++) {
                        //행 검사(i, j를 기준으로)
                        //인접한 사탕 바꾸고 행검사해서 제일 큰 수로 갱신
                        if (candy[c][j] == candy[c+1][j]) {
                            cnt++;
                        } else {
                            cnt = 1;
                        }
                        max = Math.max(max, cnt);

                    }


                    cnt = 1;
                    for (int c = 0; c<n-1; c++) {
    
                        if (candy[i][c] == candy[i][c+1]) {
                            cnt++;
                        } else {
                            cnt = 1;
                        }
                        max = Math.max(max, cnt);

                    }


                    //원상 복귀
                    char temp2 = candy[i][j];
                    candy[i][j] = candy[nx][ny];
                    candy[nx][ny] = temp2;
                }
            }
        }
        System.out.print(max);

    }


}
