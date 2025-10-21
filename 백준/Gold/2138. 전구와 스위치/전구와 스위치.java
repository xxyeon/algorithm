import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //i-1 전구가 목표와 다르다면 i를 누르고 아니면 누르지 않는다. i를 기준으로 정하는 이유:i-1은 i가 아니면 변경할 수 없다.
        char[] now = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();

        boolean[] nowB = new boolean[N];
        boolean[] nowA = new boolean[N];
        boolean[] targetB = new boolean[N];

        for(int i=0;i<N; i++) {
            nowB[i] = now[i] == '1';
            nowA[i] = now[i] == '1';
            targetB[i] = target[i] == '1';
        }

        int answer = 1; // 맨 처음 전구 누르기

        nowA[0] = !nowA[0];
        nowA[1] = !nowA[1];
        for(int i=1;i<N;i++) {
            //첫번재 전구 누른 경우
            if(nowA[i-1] != targetB[i-1]) {
                nowA[i] = !nowA[i];
                nowA[i-1] = !nowA[i-1];
                if(i < N-1) {
                    nowA[i+1] = !nowA[i+1];
                }
                answer++;
            }
        }

        int answer1 = 0;
        for(int i=1;i<N;i++) {
            //첫번째 전구 누르지 않은 경우
            if(nowB[i-1] != targetB[i-1]) {
                nowB[i] = !nowB[i];
                nowB[i-1] = !nowB[i-1];
                if(i < N-1) {
                    nowB[i+1] = !nowB[i+1];
                }
                answer1++;
            }
        }
        int min = 0;
        
        if(nowB[N-1] == targetB[N-1] && nowA[N-1] == targetB[N-1]) {
            min = Math.min(answer, answer1);
        } else if(nowB[N-1] == targetB[N-1]) {
            min = answer1;
        } else if(nowA[N-1] == targetB[N-1]) {
            min = answer;
        } else {
            min = -1;
        }

        System.out.print(min);

    }

}