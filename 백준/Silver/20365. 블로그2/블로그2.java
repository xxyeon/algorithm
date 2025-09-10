import java.io.*;
import java.util.*;

public class Main {
    static HashMap<String, Integer> colors = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        colors.put("B", 0);
        colors.put("R", 0);
        int N = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();

        for(int i=0; i<N-1;i++) {
            if(s[i+1] == s[i]) {
                if(i+1 == N-1){
                    colors.put(String.valueOf(s[i]), colors.get(String.valueOf(s[i]))+1);
                    break;
                }
                continue;
            }
            if(i+1 == N-1){
                colors.put(String.valueOf(s[i+1]), colors.get(String.valueOf(s[i+1]))+1);
            }
            colors.put(String.valueOf(s[i]), colors.get(String.valueOf(s[i]))+1);
        }

        int bCount = 1 + colors.get("R");
        int rCount = 1 + colors.get("B");

        System.out.print(Math.min(bCount, rCount));
    }

}
