import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] height;
    static HashMap<Integer, Integer> arrowH = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = new int[N];
        for(int i=0;i<N;i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        int temp = 0;
        for(int h : height) {
            if(arrowH.containsKey(h)&&arrowH.get(h) >= 1) {

                arrowH.replace(h, arrowH.get(h) - 1);

                if(h-1 >0 && arrowH.containsKey(h-1)) arrowH.replace(h - 1, arrowH.get(h - 1) + 1);
                else if(h-1>0) arrowH.put(h - 1, 1);
            }
            else if(h-1 >=0) {
                if (arrowH.containsKey(h - 1)) arrowH.replace(h - 1, arrowH.get(h - 1) + 1);
                else arrowH.put(h - 1, 1);
                temp++;            }
        }

        System.out.print(temp);
    }
}