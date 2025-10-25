import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        int len = 2;

        int answer = 0;
        while(idx < N && len <= N) {
            int temp = 1;
            boolean isPalidrom = true;
            for(int i=idx; i<idx+len/2; i++) {
                if(idx+len-temp < N && arr[i] != arr[idx+len-temp]){
                    isPalidrom = false;
                    break;
                }
                temp++;
            }
            if(!isPalidrom) {
                len += 2;

            } else {
                idx += len;
                len = 2;
                answer++;
            }
        }
        if(answer == 0||len>N) {
            System.out.print(-1);
            return;
        } else {
            System.out.print(answer);
        }

    }
}