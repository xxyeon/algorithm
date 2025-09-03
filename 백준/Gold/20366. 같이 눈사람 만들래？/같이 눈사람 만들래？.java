import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Snowman {
    int sum, bottom, top;

    Snowman(int bottom, int top, int sum) {
        this.bottom = bottom;
        this.top = top;
        this.sum = sum;
    }
}

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(arr);

        ArrayList<Snowman> snowmens = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N;j++) {
                snowmens.add(new Snowman(i, j, arr[i] + arr[j]));
            }
        }

        snowmens.sort(Comparator.comparingInt(p -> p.sum));
        int answer = Integer.MAX_VALUE;


        for(int i=1;i<snowmens.size(); i++) {
            Snowman s1 = snowmens.get(i);
            Snowman s2 = snowmens.get(i-1);
            if(s1.bottom != s2.bottom && s1.bottom != s2.top && s1.top != s2.top && s1.top != s2.bottom) {
                answer = Math.min(answer, Math.abs(s1.sum - s2.sum));
            }
        }
        System.out.print(answer);
    }
}
