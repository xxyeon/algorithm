class Solution {
    int cnt = 0;
    int convertCnt = 0;
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")) {
        //0제거
            s = deleted(s);
            s = convertToBinary(s.length());
            s = s.charAt(0) == '0' ? s.substring(1) : s.substring(0);
            convertCnt++;
        }
        
        answer[0] = convertCnt;
        answer[1] = cnt;
        return answer;
    }
    private String convertToBinary(int num) {
        if(num == 0) {
           return "0";
        }
        System.out.println(num);
        return convertToBinary(num / 2) + num % 2;
    }
    
    private String deleted(String str) {
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()) {
            if(ch == '0') {
                cnt++;
                continue;
            }
            sb.append(ch);
        }
        return sb.toString(); //"11111"
    }
}