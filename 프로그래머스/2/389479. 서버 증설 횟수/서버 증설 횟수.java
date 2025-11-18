class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        //m명 늘어날때마다 서버 1대 추가
        //n*m이상 (n+1) * m미만 ->최소 n대의 서버 운영, k시간도안 운영가능
        //하루 동안 모든 이용자가 게임을 하기 위한 서버개수(최소) 그리디?
        //서버는 생명주기를 가짐  생명주기가 k 다 하면 없어짐. 하루는 24시간
        //24번 반복하면서 각 시간대 별로 살아있는 서버개수 확인
        //증설횟수, 증설된 서버 수 저장하는 리스트
        //생명주기를 다한 서버를 어떻게 제외? 매번 서버 리스트를 돌면서 검사?
        //각 시간대에 증설된 서버의 수를 기록, 현재 시간 - 증설된 서버의 시간
        //server[i] = i시~i+1시 사이에 증설된 서버
        //if m <= player[i] 이면 서버 한대 증설 serverCnt++(server[i] ~ server[i+k-1] k시간동안 서버는 살아있음)
        //if player[i] / m > 0이면 player[i] / m 대 서버 추가
        //if player[i] / m < 0이면 1 대 서버 추가
        //if player[i] < m은 넘어가기
        
        int[] server = new int[24];
        
        for(int i=0; i<24;i++) {
            int temp = players[i] / m; //증설해야하는 서버 수

            if(temp == 0) continue;
            if(temp > 0) {
                if(server[i] >= temp) {
                    //서버의 개수가 충분하다면 넘어가기
                    continue;
                }else {
                    //i시간에 서버가 부족하다면
                    int curr = server[i]; //현재 i 시간의 서버 수
                    answer += temp - curr; //서버증설횟수 늘리기
                    for(int time = i; time < i+k; time++) {
                        if(time >= 24) break; //하루를 넘어가면 서버는 필요없음
                        server[time] += temp - curr;
                        // System.out.println(server[time]);
                    }
                    // answer+= temp - server[i]; //서버증설횟수 늘리기
                }
                
            }
        
        }
        return answer;
    }
}