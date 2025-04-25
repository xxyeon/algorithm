import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //삭제, 추가가 빈번하므로 likedList 사용
        LinkedList<Integer> lst = new LinkedList<Integer>();
        int num = Integer.parseInt(bf.readLine());
        for (int i = 0; i < num; i++) {
            String[] inputs = bf.readLine().split(" ");
            String command = inputs[0];
            Integer n = null;
            if (inputs.length == 2) {
                n = Integer.valueOf(inputs[1]);
            }
            if ("push_back".equals(command)) {
                lst.add(n);
            } else if("push_front".equals(command)){
                lst.addFirst(n);
            } else if (("front").equals(command)) {
                Integer number = lst.peekFirst() != null ? lst.peekFirst() : -1;
                System.out.println(number);
            } else if (("back").equals(command)) {
                Integer number = lst.peekLast() != null ? lst.peekLast() : -1;
                System.out.println(number);
            } else if (("size").equals(command)) {
                System.out.println(lst.size());
            } else if (("empty").equals(command)) {
                Integer number = lst.isEmpty() ? 1 : 0;
                System.out.println(number);
            } else if("pop_front".equals(command)){
                Integer number = lst.pollFirst();
                if (null == number) {
                    System.out.println(-1);
                } else {
                    System.out.println(number);
                }
            } else if("pop_back".equals(command)){
                Integer number = lst.pollLast();
                if (null == number) {
                    System.out.println(-1);
                } else {
                    System.out.println(number);
                }
            }
        }

    }

}

// Scanner sc = new Scanner(new InputStreamReader(System.in));
// BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
