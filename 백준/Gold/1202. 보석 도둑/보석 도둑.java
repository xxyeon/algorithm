import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

    static class Jewel {
        int w, v;
        Jewel(int w, int v) { this.w = w; this.v = v; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(w, v);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(jewels, Comparator.comparingInt(j -> j.w)); // 보석 무게 오름차순
        Arrays.sort(bags); // 가방 무게 오름차순

        // 최대 힙 (가치 기준)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        long answer = 0;
        int idx = 0;
        for (int bag : bags) {
            // 현재 가방에 넣을 수 있는 보석을 모두 pq에 추가
            while (idx < N && jewels[idx].w <= bag) {
                pq.add(jewels[idx].v);
                idx++;
            }
            // 가장 가치 큰 보석 선택
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}
