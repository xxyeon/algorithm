import java.io.*;
import java.util.Stack;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            char[] ch = bf.readLine().toCharArray();
            for (char c : ch) {
                if (c == '<') {
                    if (left.isEmpty()) {
                        continue;
                    }
                    right.push(left.pop());
                } else if (c == '>') {
                    if (right.isEmpty()) {
                        continue;
                    }
                    left.push(right.pop());
                } else if (c == '-') {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                } else {
                    left.push(c);
                }
                
            }
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            sb.append('\n');
            left.clear();
            right.clear();
        }
        System.out.print(sb.toString());
        bf.close();

    }
}
