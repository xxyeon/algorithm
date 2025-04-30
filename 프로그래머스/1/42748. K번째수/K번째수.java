import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int index = 0;
        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
            int[] subArr = new int[j-i+1];
            
            for (int idx = 0; idx < subArr.length; idx++) {
                subArr[idx] = array[idx+i-1];
            }
            Arrays.sort(subArr);
            answer[index++] = subArr[k-1];
        }
        return answer;
    }
}