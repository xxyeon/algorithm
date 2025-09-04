import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 작은 값 저장
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 큰 값 저장

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            // 1. maxHeap에 우선 넣음
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            // 2. 균형 맞추기
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            // 3. 중앙값 출력
            sb.append(maxHeap.peek()).append('\n');
        }

        System.out.print(sb);
    }
}
