import javax.swing.plaf.BorderUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] status;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int start, link;
    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        status = new int[n][n];
        visited = new boolean[n];
        for(int i=0; i < n; i++) {
            status[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for(int i=0;i<n;i++) {
            for(int j=0; j<n;j++) {
                total += status[i][j];
            }
        }
        dfs(0, 0);
        System.out.print(min);

    }

    private static void dfs(int depth, int idx) {
        if (depth == n / 2) {
            //능력치 계산
            start = 0;
            link = 0;
            //O(N^2) -> 이게 조합 수 만큼 반복 -> 20C10 = 대략 20만
            for(int i=0;i<n;i++) {
                for(int j=0; j<n; j++) {
                    if (visited[i] && visited[j]) {
                        start += status[i][j];
                    } else if(!visited[i] && !visited[j]) {
                        link += status[i][j];
                    }
                }
            }
            min = Math.min(min, Math.abs(link - start));

            return;
        }
        for(int i=idx; i<n;i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth+1, i + 1);
                visited[i] = false;

            }
        }
    }

}
