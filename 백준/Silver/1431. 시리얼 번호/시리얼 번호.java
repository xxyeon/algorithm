import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = bf.readLine();
        }
        Arrays.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }
                int sum1 = getSum(o1);
                int sum2 = getSum(o2);
                if (sum1 != sum2) {
                    return sum1 - sum2;
                }
                return o1.compareTo(o2);
            }
        });

        for (String s : numbers) {
            sb.append(s).append('\n');
        }

        System.out.print(sb.toString());

        bf.close();
    }
    private static int getSum(String s) {
        int num = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num += ch - '0';
            }
        }
        return num;
    }
}
