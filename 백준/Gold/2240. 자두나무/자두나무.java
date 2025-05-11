import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 총 시간
        int W = sc.nextInt(); // 최대 이동 횟수

        int[] fruits = new int[T + 1]; // 자두 떨어지는 위치 (1 또는 2)
        for (int i = 1; i <= T; i++) {
            fruits[i] = sc.nextInt();
        }

        // dp[i][j]: i초일 때 j번 움직였을 때 최대 자두 개수
        int[][] dp = new int[T + 1][W + 1];

        for (int t = 1; t <= T; t++) {
            for (int w = 0; w <= W; w++) {
                int tree = (w % 2 == 0) ? 1 : 2; // 현재 위치한 나무

                if (w == 0) {
                    // 움직이지 않은 경우, 이전 상태에서 이어받기
                    dp[t][w] = dp[t - 1][w] + (fruits[t] == tree ? 1 : 0);
                } else {
                    // 이전 상태에서 이동하지 않거나, 이동해서 왔을 경우 중 최대 선택
                    dp[t][w] = Math.max(dp[t - 1][w], dp[t - 1][w - 1]) + (fruits[t] == tree ? 1 : 0);
                }
            }
        }

        // 정답: T초일 때, W번까지 이동해서 얻을 수 있는 자두 최대값
        int max = 0;
        for (int w = 0; w <= W; w++) {
            max = Math.max(max, dp[T][w]);
        }

        System.out.println(max);
    }
}
