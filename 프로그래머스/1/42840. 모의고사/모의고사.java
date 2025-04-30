import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        //1, 2, 3, 4, 5
        //2, 1, 2, 3, 2, 4, 2, 5
        //3, 3, 1, 1, 2, 2, 4, 4, 5, 5
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cnt = {0,0,0};
        for(int i = 0; i < answers.length; i++) {
            
            if(p1[i%p1.length] == answers[i]) {
                cnt[0]++;
            } if(p2[i%p2.length] == answers[i]) {
                cnt[1]++;
            } if(p3[i%p3.length] == answers[i]) {
                cnt[2]++;
            }
        }
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i=0; i<3;i++) {
            if(max == cnt[i]) {
                lst.add(i+1);
            }
        }
   
        
        return lst.stream().mapToInt(i->i).toArray();
    }
}