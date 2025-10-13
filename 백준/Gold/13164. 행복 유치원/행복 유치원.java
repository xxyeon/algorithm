import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, K;
        int answer = 0;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] tall = new int[N];
        int[] gap = new int[N-1];
        String[] temp = br.readLine().split(" ");
        for(int i=0;i<N;i++) {
            tall[i] = Integer.parseInt(temp[i]);
        }
        if (K!=N) {
            for(int i=0;i<N-1;i++) {
                gap[i] = tall[i+1] - tall[i];
            }
            Arrays.sort(gap);
            //k-1 개 제외하고 누적합
            for(int i=0;i<gap.length -(K-1);i++) {
                answer += gap[i];
            }
        }
        System.out.print(answer);
    }

}
