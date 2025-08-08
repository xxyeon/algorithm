
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] point;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        point = new int[n];
        parent = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++) {
            //i의 직속 상사가 parent[i]
            if(parent[i] != -1) {
                adj.get(parent[i] - 1).add(i);
            }
        }

        for(int i=0;i<m;i++) {
            String[] info = br.readLine().split(" ");
            int index = Integer.parseInt(info[0])-1; //칭찬받은 직원 인덱스
            int score = Integer.parseInt(info[1]);
            point[index] += score;
//            dfs(index, score);
        }
        dfs(0, 0);

        for(int result : point) {
            System.out.print(result + " ");
        }

    }

    private static void dfs(int curr, int score) {
        int totalScore = score + point[curr]; //curr가 직접적으로 받은 칭찬
        point[curr] = totalScore;
        for(int next : adj.get(curr)) {
            dfs(next, totalScore);
        }
    }


}

