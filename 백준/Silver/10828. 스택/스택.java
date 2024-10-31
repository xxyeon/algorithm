import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<String> stackInt = new Stack<>();
        int num = Integer.parseInt(bf.readLine());
        for (int i = 0; i < num; i++) {
            String[] ins = bf.readLine().split(" ");
            String instruction = ins[0];
            if (instruction.equals ("push")) {
                stackInt.push(ins[1]);
            } else if (instruction.equals("top")){
                sb.append(stackInt.empty() ? "-1": stackInt.peek()).append("\n");
            } else if (instruction.equals("size")) {
                sb.append(stackInt.size()).append("\n");
            } else if (instruction.equals("empty")) {
                sb.append(stackInt.empty() ? "1":"0").append("\n");
            } else if (instruction.equals("pop")) {
                sb.append(stackInt.empty() ? "-1": stackInt.pop()).append("\n");
            }
        }
        System.out.print(sb);
    }
}