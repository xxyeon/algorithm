
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        parent = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int truthCnt = Integer.parseInt(st.nextToken());
        int[] truth = new int[truthCnt];
        for (int i = 0; i < truthCnt; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<ArrayList<Integer>> party = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int first = -1;
            ArrayList<Integer> people = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int a = Integer.parseInt(st.nextToken());
                people.add(a);
                if (first != -1) {
                    if (find(first) != find(a)) {
                        union(first, a);
                    }
                } else {
                    first = a;
                }
            }
            party.add(people);
        }

        for (int i = 0; i < N + 1; i++) {
            find(i);
        }
        int answer = 0;
        for(ArrayList<Integer> people:party){
            boolean lie = true;
            for (int p : people) {
                for (int t : truth) {
                    if(find(p) == find(t)) {
                        //진실을 아는 사람과 동일한 집합에 속하는가?
                        lie = false;
                        break;
                    }
                }
                if(!lie) break;
            }
            if(lie) {
                answer++;
            }
        }
        System.out.print(answer);

    }

    static int find(int index){
        if(parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa < pb) {
            parent[pb] = pa;
        } else {
            parent[pa] = pb;
        }
    }

}
