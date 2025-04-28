import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] input = bf.readLine().split(" ");
        Set<String> set = new LinkedHashSet<>();
        int k = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);

        for (int i = 0; i < l; i++) {
            String studentId = bf.readLine();
            if (set.contains(studentId)){ //O(1)
                set.remove(studentId);//O(N)
                set.add(studentId);
            } else {
                set.add(studentId);
            }
        }
        int idx = 0;
        for (String s : set) {
            if (idx == k) {
                break;
            }
            idx++;
            sb.append(s).append('\n');
        }
        System.out.print(sb.toString());
        bf.close();
    }
}
