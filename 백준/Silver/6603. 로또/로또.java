import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] arr;
    static int K=-1;
    static ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(K!=0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            arr = new int[K];
            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int threshold = K;
            getKNumber(0, new ArrayList<>());
            sb.append('\n');

        }
        System.out.print(sb.toString());
    }
    private static void getKNumber(int idx, ArrayList<Integer> numberLst) {
        if(numberLst.size() == 6) {
            for(int num:numberLst){
                sb.append(num).append(" ");
            }
            sb.append('\n');

            return;
        }
        if(idx >= K) return;

        numberLst.add(arr[idx]);
        getKNumber(idx+1, numberLst);
        numberLst.remove(numberLst.size()-1);
        getKNumber(idx+1, numberLst);
    }
}
