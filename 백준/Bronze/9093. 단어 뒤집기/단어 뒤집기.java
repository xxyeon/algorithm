import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //삭제, 추가가 빈번하므로 likedList 사용
        int num = Integer.parseInt(bf.readLine());
        for (int i = 0; i < num; i++) {
            String line = bf.readLine();
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                if (ch != ' ') {
                    stack.push(ch);
                } else {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                }
            }
            //마지막 단어
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            System.out.println(sb.toString());

        }

    }
}

// Scanner sc = new Scanner(new InputStreamReader(System.in));
// BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
