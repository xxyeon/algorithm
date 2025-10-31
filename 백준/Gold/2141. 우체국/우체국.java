import java.io.*;
import java.util.*;

class Town implements Comparable<Town> {
    long x, a;
    Town(long x, long a) {
        this.x=x;
        this.a=a;
    }
    public int compareTo(Town t) {
        return (int)(x - t.x);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       //모든 거리를 거처야하는 상황 -> 최소한의 이동거리로 이동할 수 있도록
        //누적합이 전체 인구수의 절반이 되는 지점
        int N = Integer.parseInt(br.readLine());

        Town[] arr = new Town[N];

        long total = 0;
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Town(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

            total += arr[i].a;
        }
        long sum = 0;
        long answer = 0;
        Arrays.sort(arr);
        for(int i=0;i<N;i++){
            sum += arr[i].a;
            if(sum >= (total+1)/2) {
                answer = arr[i].x;
                break;
            }
        }
        System.out.print(answer);
    }


}