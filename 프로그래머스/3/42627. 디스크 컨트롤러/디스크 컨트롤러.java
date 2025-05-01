import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0])); // 요청 시간 기준 정렬

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // 작업 시간 기준 정렬

        int time = 0, idx = 0, total = 0, count = 0;

        while (count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                q.add(jobs[idx]);
                idx++;
            }

            if (!q.isEmpty()) {
                int[] job = q.poll();
                time += job[1];
                total += time - job[0]; // 현재 시간 - 요청 시간
                count++;
            } else {
                time = jobs[idx][0]; // 다음 작업 시간으로 점프
            }
        }

        return total / jobs.length;
    }
}
