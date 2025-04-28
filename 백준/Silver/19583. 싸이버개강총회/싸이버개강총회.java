import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //시작시간에 들어왔는지, 끝나는 시간에 남았는지,
        //시작시간에 들어왔는지: 스트리밍 시작~ 총회 시작포함하여확인, 세트에 넣기
        //끝나는 시간에 나갔는지: 총회 종료 포함 ~ 스트리밍 종료, 세트에서 빼기 -> 출석
        Set<String> set = new HashSet<>();
        Set<String> attendance = new HashSet<>();
        String[] times = bf.readLine().split(" ");
        String[] start = times[0].split(":");
        String[] end = times[1].split(":");
        String[] endStreaming = times[2].split(":");

        int startTime = Integer.parseInt(start[0] + start[1]);
        int endTime = Integer.parseInt(end[0] + end[1]);
        int endSt = Integer.parseInt(endStreaming[0] + endStreaming[1]);

        String input;
        int cnt = 0;
        while ((input = bf.readLine()) != null) {
            if (input.isEmpty()) break;
            String[] chat = input.split(" ");
            String[] time = chat[0].split(":");

            int timeInt = Integer.parseInt(time[0] + time[1]);
            String name = chat[1];
            if (startTime >= timeInt) {
                //시작시간에 들어옴: 출석
                set.add(name);
            } else if(set.contains(name)){
                //출석한 사람이 나가는 시간확인 여러번 나가는 경우도 있음 set로 동일한 이름이 나가면 한번만 출석되도록
                if(endTime <= timeInt && timeInt <= endSt) {
                    attendance.add(name);
                }
            }
        }
        System.out.print(attendance.size());

        bf.close();
    }
}
