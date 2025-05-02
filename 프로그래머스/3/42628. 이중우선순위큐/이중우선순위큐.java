import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> b - a); // 최대 우선순위 큐
        PriorityQueue<Integer> minQ = new PriorityQueue<>(); // 최소 우선순위 큐
        Map<Integer, Integer> map = new HashMap<>(); // 값의 빈도 관리

        for (String op : operations) {
            String[] arr = op.split(" ");
            int n = Integer.parseInt(arr[1]);
            switch (arr[0]) {
                case "I": // Insert
                    maxQ.add(n);
                    minQ.add(n);
                    map.put(n, map.getOrDefault(n, 0) + 1);
                    break;

                case "D": // Delete
                    if (n == 1) { // 최대값 삭제
                        while (!maxQ.isEmpty() && map.getOrDefault(maxQ.peek(), 0) == 0) {
                            maxQ.poll(); // 큐에서 유효하지 않은 값은 제거
                        }
                        if (!maxQ.isEmpty()) {
                            int max = maxQ.poll();
                            map.put(max, map.get(max) - 1);
                        }
                    } else if (n == -1) { // 최소값 삭제
                        while (!minQ.isEmpty() && map.getOrDefault(minQ.peek(), 0) == 0) {
                            minQ.poll(); // 큐에서 유효하지 않은 값은 제거
                        }
                        if (!minQ.isEmpty()) {
                            int min = minQ.poll();
                            map.put(min, map.get(min) - 1);
                        }
                    }
                    break;
            }
        }

        // 마지막에 유효한 값이 없으면 [0, 0] 반환
        while (!maxQ.isEmpty() && map.getOrDefault(maxQ.peek(), 0) == 0) {
            maxQ.poll(); // 큐에서 유효하지 않은 값은 제거
        }
        while (!minQ.isEmpty() && map.getOrDefault(minQ.peek(), 0) == 0) {
            minQ.poll(); // 큐에서 유효하지 않은 값은 제거
        }

        if (maxQ.isEmpty() || minQ.isEmpty()) {
            return new int[] {0, 0};
        }

        int max = maxQ.peek();
        int min = minQ.peek();
        return new int[] {max, min};
    }
}
