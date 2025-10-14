import java.io.*;
import java.util.*;

class Town implements Comparable<Town>{
    long x;
    long a;
    Town(long x, long a) {
        this.x = x;
        this.a =a;
    }

    @Override
    public int compareTo(Town o) {
        return (int)(x - o.x); //오름차순
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N;
        N = Integer.parseInt(br.readLine());
//        long[] x = new long[N];
//        long[] a = new long[N];
        Town[] towns = new Town[N];
        long num = 0;
        for(int i=0; i<N;i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            num += a;
            towns[i] = new Town(x, a);
        }
        Arrays.sort(towns);
        // 사람이 가장 많은 곳에 우체국 설치
        long cumulate = 0;
        long answer = 0;
        long middle = num % 2 == 0 ? num / 2 : num / 2 + 1;
        for(int i=0; i<N;i++) {
            cumulate += towns[i].a;
             if(cumulate >= middle) {
                 answer = towns[i].x;
                 break;
             }
        }
        System.out.print(answer);

    }
}