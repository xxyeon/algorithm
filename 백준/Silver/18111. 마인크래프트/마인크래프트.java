import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int inventory = Integer.parseInt(input[2]);
        int[][] map = new int[n][m];
        int total = 0;
        for(int i=0; i<n; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int answer = Integer.MAX_VALUE;
        int height = 0;
        for(int avg=0; avg<=256; avg++) {
            //높이 찾기
            int time = 0;
            int used = inventory;
            for(int i=0; i<n; i++) {
                for (int j =0; j<m; j++) {

                    if(avg > map[i][j]){
                        //블록 놓기
                        used -= avg - map[i][j];
                        time += avg - map[i][j];
                    } else if(avg < map[i][j]) {
                        //블록 제거 (2초)
                        time += ((map[i][j] - avg) *2);
                        used += map[i][j] - avg;
                    }
                }
            }
            if(used >= 0) {
                if(answer >= time) {
                    answer = time;
                    height = avg;
                }

            }

        }

        System.out.print(answer + " " + height);
    }
}
