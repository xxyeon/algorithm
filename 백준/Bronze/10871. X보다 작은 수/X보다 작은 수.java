import java.io.*;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().trim().split(" ");
        String [] arr = bf.readLine().trim().split(" ");
        List<Integer> lst = Arrays.stream(arr).map(Integer::parseInt).filter(num -> Integer.parseInt(inputs[1]) > num).collect(Collectors.toList());
        for(int i = 0; i<lst.size(); i++) {
            System.out.print(lst.get(i) + " ");
        }
    }
}