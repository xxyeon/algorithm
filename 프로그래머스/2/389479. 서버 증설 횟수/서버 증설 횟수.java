class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int active = 0;
        int[] install = new int[24];
        for(int i=0; i<24; i++) {

            if (i >= k) {//i~i+1
                //서버 사용 시간이 지났다면
                active -= install[i-k]; //i-k시간에 증설한 서버 개수 제거
            }
            
            int req = players[i] / m;
            if (req > active) {
                install[i] = req - active; //i시간에 증설한 서버 갯수
                answer += req - active;
                active += req - active;
            }
        }
        return answer;
    }
}