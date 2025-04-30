import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        //정렬 후 뒤에서부터 h편 이상 인용되었다면 h가 답
        Arrays.sort(citations);
        
        return binarySearch(citations);
    }
    
    
    private int binarySearch(int[] arr) {
        int start = 0;
        int end = arr.length;
        int answer = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            
            int cnt = 0;
            for (int num : arr) {
                if (num >= mid) {
                    cnt++;
                }
            }
            if(cnt < mid) {
                end = mid - 1;
            } else {
                answer = mid;
                start = mid + 1;
            }
        }
        return answer;
    }
}