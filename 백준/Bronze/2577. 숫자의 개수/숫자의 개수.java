import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        long[] lst = new long[3];
        int[] num = new int[10];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 입력받기
        for (int i = 0; i < 3; i++) {
            lst[i] = Long.parseLong(bf.readLine().trim());
        }

        // 곱셈 결과 계산
        long result = 1;
        for (long i : lst) {
            result *= i;
        }

        // 결과 숫자 카운팅
        String str = Long.toString(result);
        for (char digit : str.toCharArray()) {
            num[digit - '0']++;
        }

        // 결과 출력
        for (int count : num) {
            System.out.println(count);
        }
    }
}
