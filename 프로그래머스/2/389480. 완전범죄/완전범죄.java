import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = n;
        //a도둑이 남기는 흔적의 누적개수 최댓값 n
        //a도둑이 남기는 흔적의 누적 개수 최소 => A도둑이 훔치는 경우를 최소한으로
        //b도둑 먼저 훔치고, m이 넘어가면 A도둑이 훔친다. 물건 개수만큼 반복, a의 누적, B의 누적 변수 선언
        //모든 물건을 훔쳐야함. 물건에 대한 흔적의 정보는 이미 알고 있음. n,m 내에서 훔쳐야함.
        //조합으로 하면 2^40 시간초과
        //b낮은 순, a낮은 순 정렬
        //a가 훔치는 경우의 수 n, b가 훔치는 경우의 수 m, 각 단계에서 발생할 수 있는 최대 조합의 수는 n*m
        //info 의 길이 최대 40 -> 40 * 120 * 120 = 96,000 -> 이전 단계에서 발생하는 조합에 a가 훔치는 경우, b가 훔치는 경우 2가지가 존재
        //이전에 발생하는 조합을 재활용 -> 메모제이션
        //1차 메모리초과
        int len = info.length;
        boolean[][][] dp = new boolean[len][n][m]; //a의 누적 흔적의 최대는 n, b는 m
        
        //a가 훔친경우
        if(info[0][0] < n) dp[0][info[0][0]][0] = true;
        //b가 훔친경우
        if(info[0][1] < m) dp[0][0][info[0][1]] = true;
        
        for(int i=1;i<len;i++) { //최대 40
            int currA = info[i][0];
            int currB = info[i][1];
            
            for(int a = 0; a < n; a++) {
                for(int b = 0; b < m; b++) {
                    if(dp[i-1][a][b]) {
                        //이전 조합에서 누적흔적이 유효하다면
                        int nextA = currA + a;
                        int nextB = currB + b;
                        
                        if(nextA < n) dp[i][nextA][b] = true;
                        if(nextB < m) dp[i][a][nextB] = true;
                    }
                }
            }
        }
        //dp[len-1] 중에서 a의 누적 흔적이 제일 적은 적은 것을 고르기
        for(int a=0;a<n;a++) {
            for(int b=0;b<m;b++) {
                if(dp[len-1][a][b]) {
                    answer= Math.min(answer, a);
                }
            }
        }
        if(answer == n) {
            answer = -1;
        }
        
        return answer;
    }
    
    
}
