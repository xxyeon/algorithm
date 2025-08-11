
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] arr = new int[n];
        for(int i=-0; i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = 0;
        int result = Integer.MAX_VALUE;
        while(end < n && start <= end) {
            int gap = arr[end] - arr[start];
            if(gap < m) {
                end += 1;
            } else if(gap >= m) {
                start += 1;
                result = Math.min(result, gap);
            }
        }
        System.out.println(result);

    }
}

