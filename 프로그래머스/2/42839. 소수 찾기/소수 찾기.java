import java.util.*;
class Solution {
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        
        dfs("", numbers, visited);
        return set.size();
       
    }
    private void dfs(String number, String numbers, boolean[] visited) {
        if (!number.isEmpty()) {
            int num = Integer.parseInt(number);
            if (isPrime(num)) {
                set.add(num);
            }
        } 
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(number + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
        
    }
    
    private boolean isPrime(Integer n) {
        
        if (n == 0 || n == 1) return false;
    
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}