import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //시계 반대방향 (동북서남)
        //동 : next[row][i+1] = pre[row][i] -> row: n/2 ~ n (
        //북: next[i-1][col] = pre[i][col] -> col: m/2 ~ m
        //서: next[row][i-1] = pre[row][i] -> row: 0~ n/2
        //남: next[i+1][col] = pre[i][col] -> col : 0 ~ m/2
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        r = Integer.parseInt(inputs[2]);
        arr = new int[n][m];
        for(int i=0;i<n;i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        }
//        for(int i=0; i<r; i++) {
//            north()
//            west()
//            south()
//            east()
//            //시계 반대방향으로 돌리고 next값을 pre로 옮기기
//            for(int j=0;i<n;i++) {
//                for (int k=0; k<m;k++) {
//                    pre[j][k] = temp[j][k];
//                }
//            }
//        }

        int count = Math.min(n, m) / 2; // 더 작은 수를 기준으로 회전하는 라인 수 결정 가능
        for(int i=0; i < r; i++) { //회전 수
            for (int j=0; j<count; j++) { // 각 라인별로 회전
                int temp = arr[j][j]; //각 라인 별로 0,0 위치의 값 저장해 놓고 마지막에 swap 하기
                for(int k=j+1; k<m-j; k++) //서
                    arr[j][k-1] = arr[j][k];

                for(int k=j+1; k<n-j; k++) //북
                    arr[k-1][m-1-j] = arr[k][m-1-j];

                for(int k=m-2-j; k>=j; k--) //동 : m -2 , m-1 서로 swap
                    arr[n-1-j][k+1] = arr[n-1-j][k];

                for(int k=n-2-j; k>=j; k--) //남
                    arr[k+1][j] = arr[k][j];

                arr[j+1][j] = temp;

            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n;i++) {
            for(int j=0; j<m;j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }

}
