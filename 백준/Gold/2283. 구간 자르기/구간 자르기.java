import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    static int MAX = 1000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        //a, b 를 정해서 a ~ b 구간에 포함되지 않은 부분을 잘래내고 A~b사이에 있 있는 부분의 합이 k가 되도록하는 a,b 구간을 구하여라
        //a:start, b: end
        //n <= 1000, 매번 1000번 검사
        //입력을 하나의 배열로 두면

        int[] arr = new int[MAX];
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i=0; i<N;i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            for(int idx = a;idx < b;idx++) {
                arr[idx]++;
            }
        }
        int A = 0;
        int B = 0;
        int start = 0;
        int end = 0;
        int include = 0;
        while (start <= end && end <=MAX) {
            if(include == K) {
                A = start;
                B = end;
                break;
            } else if(include < K) {
                if(end<MAX) {
                    include += arr[end];
                }
                end++;

            } else if(include > K) {
                include-=arr[start];
                start++;

            }
        }

        System.out.print(A + " " + B);
    }
}
