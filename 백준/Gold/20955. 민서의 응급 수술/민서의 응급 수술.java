
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
    static Set<Integer> visited = new HashSet<>();
    static int delete = 0;
    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        parent = new int[n];
        for(int i=0; i<n;i++) {
            parent[i] = i;
        }
        for(int i=0; i<m; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0])-1;
            int b = Integer.parseInt(edge[1])-1;
//            if(adj.get(a)== null) adj.put(a, new ArrayList<>());
//            if(adj.get(b) == null) adj.put(b, new ArrayList<>());
//            adj.get(a).add(b);
//            adj.get(b).add(a);
            if (findParent(a) != findParent(b)) {
                union(a, b);
            } else if (findParent(a) == findParent(b)) {
                //이미 연결되어 있는 집합인데 또 연겷하는 간선은 사이클 -> 삭제
                delete++;
            }
        }
        //트리 개수 세기
        Set<Integer> roots = new HashSet<>();
        for (int i =0; i<n;i++) {
//            System.out.println(i);
            roots.add(findParent(i));
        }
        int addCnt = roots.size()-1;


        //노드 한개로 구성된 트리는 포함이 안되어 있음
        System.out.print(addCnt + delete);

    }
    private static int findParent(int index) {
       if(index != parent[index]) parent[index] = findParent(parent[index]);
//       parent[index] = index; -> 여기서 갱신해주면 경로 압축을 하지 못함
        return parent[index];
    }
    private static void union(int a, int b) {
        int a1 = findParent(a);
        int b1 = findParent(b);
        if(a1 > b1) parent[a1] = b1;
        else parent[b1] = a1;
    }

}

