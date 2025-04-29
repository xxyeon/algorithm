import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = bf.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        //맵에 key = 나온 수, 리스트에 수, 빈도수, 나타난 순서 를 필드로 가지는 객체저장하고 거기서 빈도순으로 정렬
        Map<Integer, Message> map = new HashMap<>();
        int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i=0; i < n; i++) {

            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new Message(1, i));
            } else {
                Message ms = map.get(arr[i]);
                ms.setFrequency(ms.getFrequency() + 1);
            }
        }

        //arr정렬
        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                if (map.get(n1).getFrequency() != map.get(n2).getFrequency()) {
                    //빈도 높은 순
                    return map.get(n2).getFrequency() - map.get(n1).getFrequency();
                }
                return map.get(n1).getOrder() - map.get(n2).getOrder();
            }
        });
        for (int num : keyList) {
            for (int i = 0; i < map.get(num).getFrequency(); i++) {
                sb.append(num).append(" ");
            }
        }
        System.out.print(sb.toString());

        bf.close();
    }
    private static class Message {
        int frequency;
        int order;

        Message(int frequency, int order) {
            this.frequency += frequency;
            this.order = order;
        }
        int getFrequency() {
            return frequency;
        }

        void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        int getOrder() {
            return order;
        }
    }

}
