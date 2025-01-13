import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        long[] lst = new long[3];
        int[] num = new int[10];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            lst[i] = Long.parseLong(bf.readLine().trim());
        }

        long result = 1;
        for (long i : lst) {
            result *= i;
        }

        String str = Long.toString(result); //메모

        for (char digit : str.toCharArray()) {
            num[digit - '0']++;
        }
        for (int i : num) {
            System.out.println(i);
        }

    }
}
