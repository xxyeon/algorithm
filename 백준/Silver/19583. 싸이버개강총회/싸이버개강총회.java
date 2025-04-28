import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] times = br.readLine().split(" ");
        String S = times[0]; // 개강 총회 시작 시간
        String E = times[1]; // 개강 총회 종료 시간
        String Q = times[2]; // 스트리밍 종료 시간

        Set<String> attendance = new HashSet<>();
        Set<String> leave = new HashSet<>();

        String input;
        while ((input = br.readLine()) != null) {
            String[] log = input.split(" ");
            String time = log[0];
            String name = log[1];

            if (time.compareTo(S) <= 0) { 
                attendance.add(name);
            } else if (time.compareTo(E) >= 0 && time.compareTo(Q) <= 0) {
                leave.add(name);
            }
        }

        int count = 0;
        for (String name : attendance) {
            if (leave.contains(name)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
