class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[25];
        for (int i=0; i<players.length; i++) {
   
            if(server[i] < players[i]/m) { //i~i+1 동안 증설된 서버 개수가 모자르면 k동안 사용할 수 있는 서버 증설
                int initServer = server[i];
                //k동안 서버 사용가능하도록 증설
                answer += players[i]/m - server[i];
                for(int j=0; j < k; j++) {

                    if (i+j >= 25) break;
                    server[i+j] += players[i]/m - initServer;
                }
            }
        }
        return answer;
    }
}