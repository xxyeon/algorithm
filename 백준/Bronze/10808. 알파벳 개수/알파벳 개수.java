import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int[] arr = new int[(int)'z' - (int)'a' + 1];
        String str = bf.readLine();

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - (int) 'a']++;
        }
        for (int i = 0; i < (int)'z' - (int)'a' + 1; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}