import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
   static ArrayList<Integer> drink = new ArrayList<>();
   static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       N = Integer.parseInt(br.readLine());
        String[] amount = br.readLine().split(" ");
        for(String a : amount) {
            drink.add(Integer.parseInt(a));
        }
        drink.sort(Comparator.naturalOrder());
        double answer = drink.get(N-1);
        for(int i=0; i<N-1;i++) {
            answer += drink.get(i)/2.0;
        }
        System.out.printf("%.5f", answer);
    }

}