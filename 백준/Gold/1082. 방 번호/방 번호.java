import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int min = 51;

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i!=0) {
                min = Math.min(min, arr[i]);
            }
        }


        int minIdx = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] < arr[minIdx]) minIdx = i;
        }

        int firstIdx = -1;
        for (int i = 1; i < N; i++) {
            if (arr[i] <= M) {
                if (firstIdx == -1 || arr[i] < arr[firstIdx]) firstIdx = i;
            }
        }
        if (firstIdx == -1) {
            System.out.println(0);
            return;
        }

        int rest = M - arr[firstIdx];
        int len = 1 + (rest / arr[minIdx]);

        int[] result = new int[len];
        Arrays.fill(result, minIdx);
        result[0] = firstIdx;
        rest -= (len - 1) * arr[minIdx];

        for (int i = 0; i < len; i++) {
            for (int d = N - 1; d >= 0; d--) {
                int costDiff = arr[d] - arr[result[i]];
                if (costDiff <= rest) {
                    result[i] = d;
                    rest -= costDiff;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) sb.append(num);
        System.out.println(sb);

    }
}