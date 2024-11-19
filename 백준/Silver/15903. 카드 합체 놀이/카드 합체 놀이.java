import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
       //우선순위큐
        PriorityQueue<Long> card = new PriorityQueue<Long>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] cardNum = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            card.offer(Long.valueOf(cardNum[i]));
        }

        for (int i=0; i<m; i++) {
            long num1 = card.poll();
            long num2 = card.poll();
            card.offer(num1 + num2);
            card.offer(num1 + num2);

        }
        long result = 0;
        for(int i=0; i<n; i++) {
            result += card.poll();
        }
        System.out.print(result);
    }
}
