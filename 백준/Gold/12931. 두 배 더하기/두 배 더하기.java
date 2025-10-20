import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        boolean b = false;
        int zero = 0;
        int answer = 0;
        while(zero != N) {
            zero = 0;
            b = false;
            for(int i=0; i<N;i++) {
                if(B[i] == 0) {
                    zero++;
                }
            }
            if(zero == N) {
                break;
            }

            for(int i=0; i<N;i++) {
                if(B[i] % 2 == 1) {
                    answer++;
                    B[i] -= 1;
                }
            }
            for(int i=0;i<N;i++) {
                if(!b && B[i] != 0 && B[i] % 2 == 0) {
                    b = true;
                    answer++;
                }
                B[i] /= 2;
            }
        }
        System.out.print(answer);

    }

}