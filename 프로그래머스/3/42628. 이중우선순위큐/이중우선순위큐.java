import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
class Solution {
    public int[] solution(String[] operations) {
        
        //최대우선순위와 최소우선순위 두고 나중에 집합 연산 (uion)
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> b-a);
        PriorityQueue<Integer> minQ = new PriorityQueue<>((a, b) -> a-b);
        Map<Integer, Integer> map = new HashMap<>();
        
        
        for(String op : operations) {
            String[] arr = op.split(" ");
            int n = Integer.parseInt(arr[1]);
            switch (arr[0]) {
                case "I":
                    maxQ.add(n);
                    minQ.add(n);
                    if (!map.containsKey(n)) {
                        map.put(n, 1);
                    } else {
                        map.put(n, map.get(n) + 1);
                    }
                    
                    break;

                case "D":
                    if (n == 1) {
                        //0이아닌 값이 나올 때 까지 while돌려야함
                        while (!maxQ.isEmpty() && map.get(maxQ.peek()) == 0) {
                            maxQ.poll();
                        }
                        if (!maxQ.isEmpty()) {
		                    map.put(maxQ.peek(), map.get(maxQ.peek()) - 1);
                            maxQ.poll();
                       
                        }
                    }
                    else if (n == -1) {
                        while (!minQ.isEmpty() && map.get(minQ.peek()) == 0) {
                            minQ.poll();
                        }
                        if (!minQ.isEmpty()) {
		                    map.put(minQ.peek(), map.get(minQ.peek()) - 1);
                            minQ.poll();
                       
                        }
				            
                    }
                    break;
                }
        }
  
        int sum = 0;
        for (Integer n : map.values()) {
            sum += n;
        }
        if (sum == 0) {
            int[] answer = {0,0};
            return answer;
        }
        
        int max = 0;
        int min = maxQ.peek();
        
        for (Integer n : map.keySet()) {
            if (map.get(n) >= 1) {
                max = Math.max(max, n);
                min = Math.min(min, n);
            }
        }
        int[] answer = {max, min};
        return answer;
    }
}