import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[] maxArr = new int[sizes.length];
        int[] minArr = new int[sizes.length];
        for (int i = 0; i < sizes.length; i++) {
            minArr[i] = (int)Math.min(sizes[i][0], sizes[i][1]);
            maxArr[i] = (int)Math.max(sizes[i][0], sizes[i][1]);
        }
        Arrays.sort(minArr);
        Arrays.sort(maxArr);
        
        return minArr[minArr.length-1] * maxArr[maxArr.length-1];
    }
}