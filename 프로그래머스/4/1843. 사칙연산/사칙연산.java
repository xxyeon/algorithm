import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        
        int[] numbers = new int[arr.length/2+1];
        String[] op = new String[arr.length/2];
        int idx = 0;
        int idx2 = 0;
        for (String s : arr) {
            if (Character.isDigit(s.charAt(0))) {
                numbers[idx++] = Integer.parseInt(s);
            } else {
                op[idx2++] = s;
            }
        }
        
        int[][] max = new int[arr.length/2+1][arr.length/2+1];
        int[][] min = new int[arr.length/2+1][arr.length/2+1];
       
        for (int i=0; i<arr.length/2+1; i++) {
            for (int j=0; j<arr.length/2+1; j++) {
                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int step = 0; step < arr.length/2+1; step++){
            for(int i =0; i < arr.length/2+1 - step; i++){
                int j = i + step;
                if (step == 0) {
                    min[i][j] = numbers[i];
                    max[i][j] = numbers[i];
                }
                
                for (int k = i; k < j; k++) {
                    
                    if (op[k].equals("+")) {
                        max[i][j] = Math.max(max[i][j], max[i][k] + max[k+1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] + min[k+1][j]);
                    } else if(op[k].equals("-")) {
                        max[i][j] = Math.max(max[i][j], max[i][k] - min[k+1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] - max[k+1][j]);
                    }
                }
            }
        }
        return max[0][arr.length/2];
    }
}