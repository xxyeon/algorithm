import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        int ones = 0;
        boolean hasZero = false;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bf.readLine());
            if (num > 1) {
                positive.add(num);
            } else if (num == 1) {
                ones++;
            } else if (num == 0) {
                hasZero = true;
            } else {
                negative.add(num);
            }
        }

        // 양수는 내림차순 정렬
        positive.sort(Collections.reverseOrder());
        // 음수는 오름차순 정렬
        Collections.sort(negative);

        // 양수 처리
        for (int i = 0; i < positive.size(); i += 2) {
            if (i + 1 < positive.size()) {
                answer += positive.get(i) * positive.get(i + 1);
            } else {
                answer += positive.get(i);
            }
        }

        // 음수 처리
        for (int i = 0; i < negative.size(); i += 2) {
            if (i + 1 < negative.size()) {
                answer += negative.get(i) * negative.get(i + 1);
            } else {
                // 남은 음수 하나는 0이 있으면 제거, 없으면 더하기
                if (!hasZero) {
                    answer += negative.get(i);
                }
            }
        }

        // 1은 전부 더하기
        answer += ones;

        System.out.println(answer);
    }
}
