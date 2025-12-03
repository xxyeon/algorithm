class Solution {
    public int lengthOfLongestSubstring(String s) {
        //연속된 문자 중 중복이 안되는 substring
        //문자열 길이 최대 5만
        int[] visited = new int[128]; //ansii code 총 128
        
        int len = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            char now = s.charAt(right);
            left = Math.max(visited[now], left); //중복된 값에 들어잇는 값을 left에 할당 -> 새로운 시작점, -> 새로운 시작점은 무엇을 기준으로?  중복된 값 위치 + 1 -> visited[now] = right+1
            //left 어떻게 설정? 중복된 값이 나온다면 visited[now]가 되어야함.
            len = Math.max(len, right - left + 1);
            visited[now] = right + 1;

        }
        return len;
    }
}