import java.io.*;
import java.util.*;

class Lecture implements Comparable<Lecture> {
    int pay;
    int day;
    Lecture(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }
    public int compareTo(Lecture l) {
        if(pay == l.pay) return day -l.day;
        return l.pay -pay;
    }
}
public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[N];
        StringTokenizer st;
        int maxDeadLine = 0;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(pay, day);
            maxDeadLine = Math.max(maxDeadLine, day);
        }
        parent = new int[maxDeadLine+1];
        int answer = 0;
        for(int i=0;i<maxDeadLine+1;i++) {
            parent[i] =i;
        }
        Arrays.sort(lectures);
        for(Lecture l : lectures) {
            int ava = find(l.day);
            if(ava == 0) {
                continue;
            }
            answer += l.pay;
            parent[ava] = find(ava - 1);
        }
        System.out.print(answer);
    }
    public static int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}