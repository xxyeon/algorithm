
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //연속적인 비어있지 않은 시퀀스 제일 작은 길이 target보다 크거나 같은 길이, 없으면 0리턴
        //정렬하면 안, 연속된 데이터
        //길이가 1부터 nums.length 까지

        int[] len = new int[nums.length];
        for(int i = 1;i<=nums.length; i++) {
            len[i-1] = i;
        }
        int start = 0;
        int end = nums.length-1;
        int answer = Integer.MAX_VALUE;

        while(start <= end) {
            //이분탐색으로 길이 탐색 -> O(logN)
            int middle = (start + end) / 2 ;
            int k = len[middle];
            if(find(k, nums, target)) {
                answer = Math.min(answer, k);
                //target보다 크거나 같다 -> 길이가 줄어들어도 된다.
                //최소길이를 찾아야하므로
                end = middle - 1;
            } else {
                //target보다 작다 -> 길이가 더 길어져야한다
                start = middle + 1;
            }       
        }
        answer = answer >= Integer.MAX_VALUE ? 0 : answer;
        
        return answer;
    }
    private boolean find(int k, int[] nums, int target) {
        int result = 0;
        //첫번째윈도우
        for(int i=0;i<k;i++) {
            result += nums[i];
        }
        if(result >= target) {
            return true;
        } 
        //두번째윈도우
        for(int i=k;i<nums.length;i++){
            result += nums[i] - nums[i-k];
            if (result >= target) {
                return true;
            }
        }
        return false;
    }
}