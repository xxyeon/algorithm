class Solution {
    final static int INF = 987654321;
    public int solution(int n, int[][] results) {
        int answer = 0;
        //상대방과의 결과를 알면 1 모르면 inf (양방향)
        int[][] graph = new int[n][n];
        
        for (int i=0; i <n; i++) {
            for (int j=0; j< n; j++) {
                if (i == j) {
                    graph[i][i] = 0;
                    continue;
                }
                graph[i][j] = INF;
            }

        }
        for (int[] input : results) {
            int a = input[0];
            int b = input[1];
            
            graph[a-1][b-1] = 1;
            graph[b-1][a-1] = -1;
        
        }

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    //승리전파
                    if(graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                }
            }
        }
        
      
        for(int[] result:graph) {
            int count = 0;
            boolean isKnow = true;
            for(int num:result) {
                count += num;
                if(num == INF) isKnow = false;
                // System.out.print(num + " ");
            }
            if (isKnow) {
                answer++;
            }
            // System.out.println("count: " + count);
            // if (count < INF) answer++;
            // System.out.println();
            
        }

        return answer;
    }
}