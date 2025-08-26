import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Problem  {
    int level, number;
    Problem(int level, int number) {
        this.level = level;
        this.number =number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, number);
    }
}
public class Main {
    static int  N,K;
    static TreeSet<Problem> lowTree = new TreeSet<>((p1, p2) -> {
        if(p1.level == p2.level) {
            return p1.number - p2.number;
        }
        return p1.level - p2.level;
    });
    static TreeSet<Problem> topTree = new TreeSet<>((p1, p2) -> {
        if(p1.level == p2.level) {
            return p2.number - p1.number;
        }
        return p2.level - p1.level;
    });
    static TreeMap<Integer, Integer> recommand = new TreeMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       for(int i=0;i<N;i++) {
           st = new StringTokenizer(br.readLine());
           int number = Integer.parseInt(st.nextToken());
           int level = Integer.parseInt(st.nextToken());
           Problem p = new Problem(level, number);
           lowTree.add(p);
           topTree.add(p);
           recommand.put(number, level);
       }
       int M = Integer.parseInt(br.readLine());
       StringBuffer sb = new StringBuffer();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("add")){
                int number = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                Problem p = new Problem(level, number);
                lowTree.add(p);
                topTree.add(p);
                recommand.put(number, level);

            }else if(op.equals("recommend")) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) {
                    Problem p = topTree.first();
                    sb.append(p.number).append('\n');
                } else {
                    Problem p = lowTree.first();
                    sb.append(p.number).append('\n');
                }

            } else if(op.equals("solved")) {
                int number = Integer.parseInt(st.nextToken());
                int level = recommand.get(number);
                Problem p = new Problem(level, number);
                lowTree.remove(p);
                topTree.remove(p);
                recommand.remove(number);
            }

        }
        System.out.print(sb.toString());
    }

}
