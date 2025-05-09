import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = bf.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] s = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] d = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] p = new int[n];

        for (int i = 0; i < k; i++) {
            shuffleReverse(d, s, p);
            System.arraycopy(p, 0, s, 0, n);
        }

        for (int i : p) {
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static void shuffleReverse(int[] d, int[] s, int[] p) {
        for (int i = 0; i < d.length; i++) {
            p[d[i] - 1] = s[i];
        }
    }
}
