import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] gap = new int[N - 1];
        String[] sen = br.readLine().split(" ");

        int[] pos = new int[N];
        for(int i=0;i<N;i++) {
            pos[i] = Integer.parseInt(sen[i]);
        }
        Arrays.sort(pos); //asc

        for(int i=0; i<N-1; i++) {
            if(pos[i+1] - pos[i] >0) gap[i] = pos[i+1] - pos[i];

        }
        Arrays.sort(gap);
        int answer = 0;

        //k-1개 구간을 끊기
        for(int i=0;i<gap.length - (K-1); i++) {
            answer += gap[i];
        }

        System.out.print(answer);

    }

}
