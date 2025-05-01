import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        //우선순위큐에서 pop한게 k보다 작으면 공식 적용
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i : scoville) {
            q.add(i);
        }
        
        while (q.size() >= 2) {

            int check = q.peek();
            
            if (check >= K) break;
            int first = q.poll();
            int second = q.poll();
            q.add(first + second * 2);
            answer++;
            
        }
        if (q.peek() < K) answer = -1;
        

        return answer;
    }
}