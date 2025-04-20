import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] a = bf.readLine().split(" ");
        String[] b = bf.readLine().split(" ");

        int[] aInt = Arrays.stream(a).mapToInt(Integer::parseInt).toArray();
        int[] bInt = Arrays.stream(b).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(aInt);
        Arrays.sort(bInt);
        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += aInt[i] * bInt[n-1-i];
        }
        System.out.print(answer);

    }

}

// Scanner sc = new Scanner(new InputStreamReader(System.in));
// BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
