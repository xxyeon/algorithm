import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static char[][] graph;
    static String[] words;
    static int[][] direction = {
            {0, 1}, {0,-1},{1, 0},{-1,0}, {-1,-1}, {-1,1}, {1,-1}, {1,1}
    };

    // dp[x][y][len] : (x,y)에서 시작해서 길이가 len인 문자열을 만들 수 있는 경우의 수
    static HashMap<String, Integer> cache = new HashMap<>();
    static HashMap<String, Integer> result = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        words = new String[K];
        for (int i = 0; i < K; i++) {
            words[i] = br.readLine();
            result.put(words[i], 0);
        }

        // 각 단어마다 모든 시작점에서 DFS 시도
        for (String word : words) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == word.charAt(0)) {
                        result.put(word, result.get(word) + dfs(i, j, 1, word));
                    }
                }
            }
        }

        // 결과 출력
        for (String word : words) {
            System.out.println(result.get(word));
        }
    }

    // DFS + 메모이제이션
    static int dfs(int x, int y, int idx, String word) {
        if (idx == word.length()) {
            return 1;
        }

        String key = x + "," + y + "," + idx + "," + word;
        if (cache.containsKey(key)) return cache.get(key);

        int count = 0;
        for (int[] dir : direction) {
            int nx = (x + dir[0] + N) % N; // 토러스 구조
            int ny = (y + dir[1] + M) % M;

            if (graph[nx][ny] == word.charAt(idx)) {
                count += dfs(nx, ny, idx + 1, word);
            }
        }

        cache.put(key, count);
        return count;
    }
}
