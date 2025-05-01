import java.util.*;

class Solution {

    public int solution(int n, int[][] wires) {
        int min = n;
        int answer = -1;
        
        for (int j = 0; j < wires.length; j++) {
            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
            }
            boolean[] visited = new boolean[n];
            
            for (int i = 0; i< wires.length; i++){
                //간선하나 제외하고 인접리스트 만들기
                if (i == j) continue; //j번째 간선 제거
                int a = wires[i][0] - 1;
                int b = wires[i][1] - 1;
                list.get(a).add(b);
                list.get(b).add(a);
            }
            visited[0] = true;
            int cnt = dfs(0, list, visited);
            min = Math.min(min, Math.abs(cnt - (n-cnt)));
        }
        return min;
    }
    private int dfs(int start, List<List<Integer>> list, boolean[] visited) {
        int cnt = 1;
        for (int next : list.get(start)) {
            if (!visited[next]) {
                visited[next] = true;
                cnt += dfs(next, list, visited);
            }
        }
        return cnt;
        
    }
    
    
}