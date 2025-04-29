import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //이중 for문으로
        int test = Integer.parseInt(bf.readLine());
        for (int i = 0; i < test; i++) {
            int cnt = 0;
            int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] a = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] b = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(b);
            for (int n1 : a) {
                cnt += binarySearch(n1, 0, b.length, b);
            }
            sb.append(cnt).append('\n');

        }
        System.out.print(sb.toString());

        bf.close();
    }

    public static int binarySearch(int target, int start, int end, int[] arr) {

        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}