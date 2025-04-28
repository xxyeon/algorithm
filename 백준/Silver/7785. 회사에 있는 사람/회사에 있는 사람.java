import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> company = new HashMap<>();
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            String[] info = bf.readLine().split(" ");
            if (info[1].equals("enter") && !company.containsKey(info[0])) {
                company.put(info[0], info[1]);
            } else if (info[1].equals("leave")) {
                company.remove(info[0]);
            }
        }
        Set<String> names = company.keySet();
        String[] nameArray = names.toArray(new String[names.size()]);
        Arrays.sort(nameArray, Collections.reverseOrder());
        for (String name : nameArray) {
            System.out.println(name);
        }
        bf.close();
    }
}
