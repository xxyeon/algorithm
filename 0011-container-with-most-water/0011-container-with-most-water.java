class Solution {
    public int maxArea(int[] height) {
        // n = 10만 -> 완탐 하면 억을 넘어가므로 시간초과, 높이 최대 1만 -> 컨테이너 너비 최대  10억 int 약 21억 감당가능
        //막대기의 위치가 변하면 안됨
        //i=0에서 최대가 되는 막대 위치 저장 및 최댓값 저장 두 막대 중 높이(height)가 작은 것을 기준으로 계산 포인터로 두 막대의 거리 확인 가능
        //i=1에서 이전에 구한 최댓값보다 크면 갱신,-> 최대가 되는 end위치 포인터에 저장되어 있음.
        //중복답안이 나올 수 있는가?
        int max = 0;
        int start = 0;
        int end = height.length-1;
        
        while(start <= end && end < height.length) {
            //현재 너비가 더 작으면 end -= 1
            //현재 너비가 더 크면 start += 1
            //최초 가로 너비는 가장 긺
            int w = end - start;
            int h = Math.min(height[start], height[end]); //두 막대기 중 짧은걸 기준으로 높이 설정
            int volumn = h * w;
            max = Math.max(max, volumn);
            if(height[start] <= height[end]) {
                start += 1;
            } else {
                end -= 1;
            }
        }
        return max;
    }
    
}