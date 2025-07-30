import javax.swing.plaf.BorderUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1,-1,0,0};
    static int n, m, x, y, k;
    static int[][] MAP;
    static int[] orders;

    static int[] dice = new int[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //  dice: 시작은 0,0부터 특정 방향으로 움직이면 바닥에 닿는 면은 x + dx[i] % 3,   y + dy[i] % 4
        // 주사위 평면도에서 비어있는 칸도 다 채우기 -> 변경될때마다 동기화 해주면 됨. (1,0이 변경되면 y=0열 모두 변경, 1,2 변경되면 y=2 모두 변경
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        x = Integer.parseInt(inputs[2]);
        y = Integer.parseInt(inputs[3]);
        k = Integer.parseInt(inputs[4]);
        MAP = new int[n][m];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            MAP[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        orders = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int order : orders) {
            int nx = x + dx[order-1];
            int ny = y + dy[order-1];
            if(nx<0||nx>=n|| ny <0||ny >=m) {
                continue;
            }
            move(order-1);
            //dice[5]가 항상 바닥
            if(MAP[nx][ny] != 0) {
                dice[5] = MAP[nx][ny];
                MAP[nx][ny] = 0;
            }else {
                MAP[nx][ny] = dice[5];
            }
            x = nx;
            y = ny;
            sb.append(dice[0]).append('\n');
        }
        System.out.print(sb.toString());

    }

    private static void move(int direction) {
        if(direction == 0) {
            //동
            int temp = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[5];
            dice[5] = dice[1];
            dice[1] = temp;
        } else if(direction == 1) {
            //서
            int temp = dice[2];
            dice[2] = dice[0];
            dice[0] = dice[1];
            dice[1] = dice[5];
            dice[5] = temp;
        } else if(direction == 2) {
            //남
            int temp = dice[3];
            dice[3] = dice[0];
            dice[0] = dice[4];
            dice[4] = dice[5];
            dice[5] = temp;
        }else if(direction == 3) {
            //북
            int temp = dice[5];
            dice[5] = dice[4];
            dice[4] = dice[0];
            dice[0] = dice[3];
            dice[3] = temp;
        }
    }
}
