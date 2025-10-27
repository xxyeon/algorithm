import java.io.*;
import java.util.*;

class Carrot implements Comparable<Carrot>{
    int w;
    int p;
    Carrot(int w, int p) {
        this.w = w;
        this.p = p;
    }
    public int compareTo(Carrot c) {
        return p - c.p;
    }

}

public class Main {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long T = Integer.parseInt(st.nextToken());
        int[] w = new int[N];
        int[] p = new int[N];
        Carrot[] arr = new Carrot[N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int wi =Integer.parseInt(st.nextToken());
            int pi =Integer.parseInt(st.nextToken());
            w[i] = wi;
            p[i] = pi;
        }
        visited = new boolean[N];
        for(int i=0;i<N;i++) {
            //누적합

            arr[i] = new Carrot(w[i], p[i]);

        }
        Arrays.sort(arr);
        long answer = 0;
        for(int i=0;i<N;i++) {
           answer += arr[i].w + arr[i].p * (T - N + i);
        }
        System.out.print(answer);
    }


}