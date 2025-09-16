import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();

        StringBuilder maxNum = new StringBuilder();
        StringBuilder minNum = new StringBuilder();

        int mCount = 0; // 연속된 M 개수

        for (char c : ch) {
            if (c == 'M') {
                mCount++;
            } else { // 'K'
                // 최대값: M들 + K → "5" + "0".repeat(mCount)
                maxNum.append("5");
                for (int i = 0; i < mCount; i++) maxNum.append("0");

                // 최소값: M들을 따로따로 → "1" + "0".repeat(mCount-1) + "5"
                if (mCount > 0) {
                    minNum.append("1");
                    for (int i = 0; i < mCount - 1; i++) minNum.append("0");
                }
                minNum.append("5");

                mCount = 0;
            }
        }

        // 남은 M 처리
        if (mCount > 0) {
            // 최대값: M이 남으면 그냥 "1" 반복
            for (int i = 0; i < mCount; i++) maxNum.append("1");

            // 최소값: M 묶어서 "1" + "0".repeat(mCount-1)
            minNum.append("1");
            for (int i = 0; i < mCount - 1; i++) minNum.append("0");
        }

        System.out.println(maxNum);
        System.out.println(minNum);
    }
}
