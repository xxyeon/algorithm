import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
    int classNumber, status;
    Student(int classNumber, int status) {
        this.classNumber = classNumber;
        this.status = status;
    }
    public int compareTo(Student s) {
        return this.status - s.status;
    }
}

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<Student> lst = new ArrayList<>(N * M);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lst.add(new Student(i, Integer.parseInt(st.nextToken())));
            }
        }

        // status 기준 정렬
        Collections.sort(lst);

        int[] cnt = new int[N]; // 반별 학생 수 카운트
        int included = 0;       // 현재 몇 개 반이 포함됐는지
        int answer = Integer.MAX_VALUE;

        int start = 0;
        for (int end = 0; end < lst.size(); end++) {
            Student e = lst.get(end);
            if (cnt[e.classNumber] == 0) included++;
            cnt[e.classNumber]++;

            // 모든 반이 포함되면 start 줄이기
            while (included == N) {
                Student s = lst.get(start);
                answer = Math.min(answer, e.status - s.status);

                cnt[s.classNumber]--;
                if (cnt[s.classNumber] == 0) included--;
                start++;
            }
        }

        System.out.println(answer);
    }
}
