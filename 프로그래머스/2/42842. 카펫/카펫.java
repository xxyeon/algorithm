class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];


        if (yellow == 1) {
            answer[0] = 3;
            answer[1] = 3;
            return answer;
        } 
        if (yellow == 2) {
            answer[0] = 4;
            answer[1] = 3;
            return answer;
        }

        
       
        
        for (int height = 1; height <= (int)Math.sqrt(yellow); height++) {
            if (yellow%height != 0) continue;
            int width = yellow/height;
            
            if (width * 2 + height * 2 + 4 == brown) {
                answer[0] = width+2;
                answer[1] = height+2;
                break;
            }
        }
       
        return answer;
    }
}