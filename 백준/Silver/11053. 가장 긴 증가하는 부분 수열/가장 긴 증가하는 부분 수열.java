import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> lst = new ArrayList<>();

        for (int num : arr) {
            if (lst.isEmpty() || lst.get(lst.size() - 1) < num) {
                lst.add(num);
            } else {
                int idx = Collections.binarySearch(lst, num);
                if (idx < 0) {
                    idx = -idx-1;
                    lst.set(idx, num);
                }
            }
        }
        System.out.print(lst.size());

    }

}

// Scanner sc = new Scanner(new InputStreamReader(System.in));
// BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
