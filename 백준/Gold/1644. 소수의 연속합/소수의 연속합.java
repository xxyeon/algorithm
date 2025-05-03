import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

       int answer = 0;

       int n = Integer.parseInt(bf.readLine());
       List<Integer> primes = getPrimes(n);
       // for(int p:primes) {
       //     System.out.println(p);
       // }
       int start = 0;
       int end = 0;
        int sum = 0;
       while(end < primes.size() && start <= end) {
           sum = 0;
           for (int i = start; i < end+1; i++) {
               sum += primes.get(i);
           }
           if (sum == n) {
               answer += 1;
               start = start + 1;
               end = start + 1;

           } else if(sum < n) {
               end += 1;
           } else if (sum > n) {
               start += 1;
           }
       }
        System.out.print(answer);
        bf.close();
    }

    private static List<Integer> getPrimes(int n) {
        boolean[] isPrime = new boolean[n+1];
        List<Integer> primes = new ArrayList<>();
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i=2; i < n+1; i++) {
            isPrime[i] = true;
        }

        for(int i = 2; i<n+1; i++) {
            if(isPrime[i]) {
                primes.add(i); //소수 구해서 넣고
            }
            int j = 0;
            while (i*j <= n) { //넣은 소수에 대해 정수 곱해서 소수 아닌것 false 로 변경
                isPrime[i*j] = false;
                j++;
            }
        }
        return primes;
    }

}