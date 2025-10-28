import java.io.*;
import java.util.*;

class Lecture implements Comparable<Lecture>{
    long start, end;
    Lecture(long start, long end) {
        this.start = start;
        this.end = end;
    }
    public int compareTo(Lecture l) {
        if(start == l.start) return (int)(end - l.end);
        return (int)(start - l.start);
    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Lecture> lectures = new ArrayList<>();
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            lectures.add(new Lecture(start, end));
        }
        lectures.sort(Comparator.naturalOrder());
//        ArrayList<Long> endTime = new ArrayList<>();
//        endTime.add(lectures.get(0).end);
        //끝나는 시간을 우선순위큐로
        PriorityQueue<Long> q = new PriorityQueue<>();
        for(int i=0;i<N;i++) {

            if(q.isEmpty()) {
                q.offer(lectures.get(i).end);
            }
            //제일 빨리 끝나는 강의 > 그 다음 강의 시작시간 이면 새로운 강의실 사용해야함
            else if(q.peek() > lectures.get(i).start) {
                q.offer(lectures.get(i).end);
            } else {
                q.poll();
                q.offer(lectures.get(i).end);
            }

        }
        System.out.print(q.size());
    }


}