import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int  N,Q;
    static TreeSet<Integer> tree = new TreeSet<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        int[] place = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<N;i++) {
            if (place[i] == 1) {
                tree.add(i);
            }
        }

        int curr = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if(op == 1) {
                int p = Integer.parseInt(st.nextToken());
                if(!tree.contains(p-1)) {
                    tree.add(p-1);
                } else {
                    tree.remove(p-1);
                }
            } else if(op == 2) {
                curr = (curr +Integer.parseInt(st.nextToken())) % N;
            } else if(op == 3) {
                Integer next = 0;
                if(tree.isEmpty()) sb.append(-1).append('\n');
                else{
                    if (tree.contains(curr)) sb.append(0).append('\n');
                    else {
                        next = tree.higher(curr);
                        if(next == null) {
                            next = tree.first();
                            next += N;
                        }
                        int answer = Math.abs(next - curr);
                        sb.append(answer).append('\n');
                    }
                }

            }
        }
        System.out.print(sb.toString());
    }

}
