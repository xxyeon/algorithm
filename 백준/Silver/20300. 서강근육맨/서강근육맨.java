import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] m = br.readLine().split(" ");
        long[] muscles;
        if(N%2 ==1) {
            N+=1;
            muscles = new long[N];
            muscles[0] = 0;
            for(int i=1;i<N;i++){
                muscles[i] = Long.parseLong(m[i - 1]);
            }
        } else {
            muscles = new long[N];
            for(int i=0;i<N;i++){
                muscles[i] = Long.parseLong(m[i]);
            }
        }

        Arrays.sort(muscles); //오름차순
        long max = 0;
        for(int i=0;i<N/2; i++) {
            max = Math.max(max, muscles[i] + muscles[N - i-1]);
        }

        System.out.print(max);

    }
}