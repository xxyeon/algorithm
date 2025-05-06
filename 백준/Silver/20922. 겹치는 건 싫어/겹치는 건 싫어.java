import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> freq = new HashMap<>();
        int start = 0, end = 0, maxLength = 0;

        while (end < n) {
            int current = arr[end];
            freq.put(current, freq.getOrDefault(current, 0) + 1);

            while (freq.get(current) > k) {
                int left = arr[start];
                freq.put(left, freq.get(left) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }

        System.out.println(maxLength);
    }
}
