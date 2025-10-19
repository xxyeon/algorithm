import java.io.*;
import java.util.*;

class Job implements Comparable<Job> {
    int time;
    int endTime;
    Job(int time, int endTime) {
        this.time = time;
        this.endTime = endTime;
    }

    public int compareTo(Job job) {
        return job.endTime - endTime;
    }
}

public class Main {
    static int N;
    static int[] height;
    static HashMap<Integer, Integer> arrowH = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Job[] jobs = new Job[N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            jobs[i] = new Job(t, s);
        }
        Arrays.sort(jobs);

        int now = jobs[0].endTime - jobs[0].time;
       for(int i=1;i<N;i++) {
           if(now > jobs[i].endTime) {
               now = jobs[i].endTime - jobs[i].time;
           } else {
               now -= jobs[i].time;
           }
       }
       
       if(now < 0) System.out.print(-1);
       else System.out.print(now);
    }

}