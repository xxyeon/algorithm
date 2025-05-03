import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int answer = Integer.MAX_VALUE;
        String[] input = bf.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] arr = new int[n];
        for (int i=0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = 0;

        while((start < n && end < n) && start <= end) {
            int gap = arr[end] - arr[start];
            if (gap >= m) {
                answer = Math.min(gap, answer);
                start += 1;

            } else if(gap < m) {
                end += 1;
            }
        }


        System.out.print(answer);
        bf.close();
    }

}