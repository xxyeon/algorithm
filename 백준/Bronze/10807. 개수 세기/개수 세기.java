import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        List<Integer> list = Arrays.stream(bf.readLine().trim().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        int num = Integer.parseInt(bf.readLine());
        int answer = Collections.frequency(list, num);
        System.out.print(answer);

    }
}