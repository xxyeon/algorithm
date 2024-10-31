import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<String> q = new LinkedList<>();
        int num = Integer.parseInt(br.readLine());
        String last = "";
        for (int i = 0; i < num; i++) {
            String[] ins = br.readLine().split(" ");
            String instruction = ins[0];

            if (instruction.equals("push")) {
                last = ins[1];
                q.add(ins[1]);
            } else if (instruction.equals("front")) {
                sb.append(q.isEmpty() ? "-1":q.peek()).append("\n");
            } else if (instruction.equals("back")) {
                sb.append(q.isEmpty() ? "-1": last).append("\n");
            } else if (instruction.equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (instruction.equals("empty")) {
                sb.append(q.isEmpty() ? "1" : "0").append("\n");

            } else if (instruction.equals("pop")) {
                sb.append(q.isEmpty() ? "-1":q.poll()).append("\n");
            }
        }
        System.out.print(sb);
    }
}