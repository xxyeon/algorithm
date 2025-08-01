import javax.swing.plaf.BorderUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] before = new int[4][8];
    static int[][] after = new int[4][8];
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i< 4; i++) {
            char[] inputs = br.readLine().toCharArray();
            for(int j=0; j<8; j++) {
                before[i][j] = inputs[j] - '0';
            }


        }
        k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++) {
            int number, rotate;
            String[] inputs = br.readLine().split(" ");
            number = Integer.parseInt(inputs[0]);
            rotate = Integer.parseInt(inputs[1]);
            //돌리는 자석의 방향과 양 옆의 자석과 비교,

            //오른쪽
            int start = number-1;
            int startR = rotate;
            rotation(start, startR);
            while(start+1<4) {
                if(before[start][2] != before[start+1][6]) {
                    //number+1 를 number와 반대방향으로
                    startR = startR == -1 ? 1 : -1;
                    rotation(start+1, startR);
                } else {
                    //동일하면 안돌리고 after로 옮기기
                    while(start+1 < 4) {
                        for(int n=0;n<8;n++){
                            after[start+1][n] = before[start+1][n];
                        }
                        start++;
                    }

                    break;
                }
                start++;
            }

            //왼쪽
            start = number-1;
            startR = rotate;
            while(start-1 >= 0) {
                if (before[start][6] != before[start - 1][2]) {
                    startR = startR == -1 ? 1 : -1;
                    rotation(start-1, startR);
                }else {
                    //동일하면 안돌리고 after로 옮기기
                    while(start-1 >= 0) {
                        for(int n=0;n<8;n++){
                            after[start-1][n] = before[start-1][n];
                        }
                        start--;
                    }

                    break;
                }

                start--;
            }
            //돌린 후 다음 돌리는 상태 업데이트
            for(int j=0; j<4; j++) {
                for(int k=0; k<8; k++) {
                    before[j][k] = after[j][k];
                }
            }

        }
        int result = score();
        System.out.print(result);
    }

    private static void rotation(int number, int rotate) {
        //어떤 톱니바퀴(number) 어떤 방향(rotate)
        if(rotate == 1) {
            //시계방향
            for(int i=1; i<8;i++) {
                after[number][i] = before[number][i-1];
            }
            after[number][0] = before[number][7];

        } else {
            //반시계
            for(int i = 7; i>0; i--) {
                after[number][i-1] = before[number][i];
            }
            after[number][7] = before[number][0];
        }

    }

    private static int score() {
        int score = 0;
        for(int j=0; j<4; j++) {
            score += before[j][0] *(int) Math.pow(2, j);
        }
        return score;
    }


}
