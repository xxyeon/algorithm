import java.util.*;
class Solution {
    int max = 0;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] visited = new boolean[dungeons.length];
        permutation(k, dungeons, visited, 0);
        return max;
    }
    
    public void permutation(int tired, int[][] dungenons, boolean[] visited, int cnt) { //cnt: 던전 탐험한 수
        
        for (int i = 0; i < dungenons.length; i++) {
            if (tired < dungenons[i][0]) {
                max = Math.max(max, cnt);
            }
            else if (!visited[i]) {
                if (tired >= dungenons[i][0]) {
                    visited[i] = true;
                    permutation(tired-dungenons[i][1], dungenons, visited, cnt + 1);
                    visited[i] = false;
                }   
            }
            
        }
    }
}