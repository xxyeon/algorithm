import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //1. 앞에꺼 pop
        //2. 앞쪽꺼 pop후 뒤에 삽입
        //3. 뒤쪽꺼 pop하고 앞에서 push
        //지민이가 뽑아내려고 하는 원소
        LinkedList<Integer> q = new LinkedList<>();

        String[] inputList = br.readLine().split(" ");
        String[] eleList = br.readLine().split(" ");
        int n = Integer.parseInt(inputList[0]);
        for (int i = 1; i < n+1; i ++) {
            q.add(i);
        }

        int i = 0;
        int cnt = 0;
        while(i < Integer.parseInt(inputList[1])) {
            if (q.get(0) == Integer.parseInt(eleList[i])) {
                q.removeFirst();
                i++;
                continue;
            }

            int idx = q.indexOf(Integer.parseInt(eleList[i]));
            int now;
            if (idx > q.size() / 2) {
                //3번 연산진행
                now = q.removeLast();
                q.addFirst(now);
                cnt++;
            } else {
                now = q.removeFirst();
                q.addLast(now);
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}