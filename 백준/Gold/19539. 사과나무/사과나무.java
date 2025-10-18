import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] height;
    static HashMap<Integer, Integer> arrowH = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String NO = "NO";
        String YES = "YES";
        String answer;
        String[] h = br.readLine().split(" ");
        height = new int[N];
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(h[i]);
        }
        int total = 0;
        int two = 0;
        for (int i = 0; i < N; i++) {
            total += height[i];
            two += height[i] / 2;
        }
        
        // 2 2 2 일 경우 two = 3, total / 3 = 2 -> 크거나 같아야함
        if(total % 3 == 0 && total/3 <= two) {
            answer = YES;
        } else{
            answer = NO;
        }
        System.out.print(answer);
    }

}