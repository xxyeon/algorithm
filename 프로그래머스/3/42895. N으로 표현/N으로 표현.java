import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        boolean isFound = false;
        
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());
        dp.get(0).add(0);
       
        for (int i = 1; i < 9; i++) {
            dp.add(new HashSet<>());
            int base = Integer.parseInt(String.valueOf(N).repeat(i)); 
            dp.get(i).add(base);
        
            
            
            //i개 사용해서 만들수 있는 수
            for(int j = 0; j < i/2+1; j++){
                
                for (int n : dp.get(j)) {
                    for (int num : dp.get(i-j)) {
                        dp.get(i).add(n + num);
                        dp.get(i).add(n - num);
                        dp.get(i).add(num - n);
                        if (num != 0) dp.get(i).add((int)(n / num));
                        if (n != 0) dp.get(i).add((int)(num/n));
                        dp.get(i).add(n * num);
                    }
                    
                }
                
            }
            if (dp.get(i).contains(number)){
                isFound = true;
                answer = i;
                break;
            }
        

                
            }
        
        
        return isFound ? answer : -1;
    }
}