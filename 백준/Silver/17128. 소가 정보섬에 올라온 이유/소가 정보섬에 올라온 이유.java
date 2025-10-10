import java.io.*;
import java.util.*;

public class Main {
    static int[] cow;
    static int[] number;
    static int[] memo;
    static int n;
    static int q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        cow = new int[n];
        for(int i=0;i<n;i++) {
            cow[i] = Integer.parseInt(st.nextToken());
        }
        number = new int[q];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<q;i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        memo = new int[n];
        calS();
        int answer = 0;
        for(int n : memo) {
            answer += n;
        }

        StringBuilder sb =new StringBuilder();
        for(int num : number) {
            //욱제가 장난친 스티커 번호가 S를 계산하는 것에 영향을 주지 않으면 이전에 계산한 값 사용
            int idx = num - 1;
            cow[idx] *= -1;
            //+-4
            for (int i = -3; i <= 3; i++) {
                int pos = (idx + i + n) % n;
                answer -= memo[pos];
                memo[pos] = calS(pos);
                answer += memo[pos];
            }


            sb.append(answer).append('\n');
        }
        System.out.print(sb.toString());
    }

    public static void calS() {
        for(int i=0;i<n;i++) {
            int temp=1;
            for(int j = 0;j<4;j++) {
                temp *= cow[(i+j)%n];
            }
            memo[i] = temp;
        }
    }
    public static int calS(int number) {
        //number ~ number +4
        int result = 1;
        for(int i = number; i< number +4; i++) {
            result *= cow[i % n];
        }
        return result;
    }

}
