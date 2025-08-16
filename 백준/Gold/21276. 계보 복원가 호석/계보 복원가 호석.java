
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static HashMap<String, Integer> indegree = new HashMap<>();
    static HashMap<String, ArrayList<String>> graph = new HashMap<>();
    static HashMap<String, ArrayList<String>> result = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] name = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        for (String s : name) {
            graph.put(s, new ArrayList<>());
            indegree.put(s, 0);
            result.put(s, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] info = br.readLine().split(" ");
            graph.get(info[1]).add(info[0]);
            indegree.replace(info[0], indegree.get(info[0])+1);
        }

        Queue<String> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        ArrayList<String> root = new ArrayList<>();
        for (String key : name) {
            if(indegree.get(key) == 0){ //가문별로 위상 정렬 수행
                root.add(key);
                q.offer(key);
            }
        }

        while (!q.isEmpty()) {
            String now = q.poll();
            for (String child : graph.get(now)) {
                int in = indegree.get(child) - 1;
                indegree.replace(child, in);
                if(in == 0) {
                    q.offer(child);
                    result.get(now).add(child);
                }
            }
        }

        root.sort(Comparator.naturalOrder());
        sb.append(root.size()).append('\n');
        for(String r : root){
            sb.append(r).append(" ");
        }
        sb.append('\n');
        //이름의 사전순서대로 ..
        Arrays.sort(name);
        for (String s : name) {
            sb.append(s).append(" ");
            sb.append(result.get(s).size()).append(" ");
            for(String child : result.get(s)) {
                sb.append(child).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());

    }
}
