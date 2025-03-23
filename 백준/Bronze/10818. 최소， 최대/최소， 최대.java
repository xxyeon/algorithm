import java.io.*;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        List<Integer> lst = Arrays.stream(bf.readLine().trim().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        int max = -1000001;
        int min = 1000001;
        for(int num:lst) {
            max = Math.max(max,num);
            min = Math.min(min, num);
        }
        System.out.print(min + " " + max);
    }
}