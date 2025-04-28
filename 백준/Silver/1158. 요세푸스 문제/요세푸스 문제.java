import java.io.*;
import java.util.*;
import java.util.ListIterator;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        String[] array = bf.readLine().split(" ");
        int n = Integer.parseInt(array[0]);
        int k = Integer.parseInt(array[1]);
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lst.add(i + 1);
        }
        int idx = 0;
        while (!lst.isEmpty()) {
            idx += k-1;
            idx = idx % lst.size();
            if (lst.size() == 1) {
                sb.append(lst.remove(idx));
                break;
            }
            sb.append(lst.remove(idx)).append(", ");

        }
        sb.append('>');
        System.out.print(sb.toString());



        bf.close();

    }
}
