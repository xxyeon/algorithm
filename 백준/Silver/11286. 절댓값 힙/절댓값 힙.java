import java.io.*;
import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //o1> o2:+, o1 <o2 :- o1==o2 절댓값 비교
                if (Math.abs(o1) == Math.abs(o2)){ return o1 > o2 ? 1 : -1;}
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        int num = Integer.valueOf(br.readLine());
        for (int i=0; i < num; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0 && q.isEmpty()) {
//                bw.write(0);
                sb.append(number).append("\n");
            } else if (number == 0) {
                sb.append(q.poll()).append("\n");
            } else {
                q.add(number);
            }

        }
        System.out.print(sb);
    }
}