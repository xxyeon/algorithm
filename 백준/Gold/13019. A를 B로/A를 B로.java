import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        Stack<Integer> target = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        char[] t = br.readLine().toCharArray();

        //arr에 있는 알파벳 종류가 t와 동일해야함
        HashMap<Integer, Integer> kind = new HashMap<>();
        HashMap<Integer, Integer> kindT = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            int num = arr[i] - '0';
            if(kind.containsKey(num)) {
                kind.replace(num, kind.get(num)+1);
            } else {
                kind.put(num, 1);
            }
            deque.add(num);
            
            int n = t[i]-'0';
            target.add(n);
            if(kindT.containsKey(n)) {
                kindT.replace(n, kindT.get(n)+1);
            } else {
                kindT.put(n, 1);
            }
        }
        for(int num : target) {
            if(kind.get(num) == null || kindT.get(num) != kind.get(num)) {
                System.out.print(-1);
                return;
            }
        }
        int cnt=0;
        int aIdx=arr.length-1;
        int tIdx=t.length-1;
        while(aIdx>=0) {
            if(t[tIdx] == arr[aIdx]) {
                cnt++;
                tIdx--;
            }
            aIdx--;
        }
        System.out.print(arr.length - cnt);
//        while(!target.isEmpty()) {
//            if(deque.peekLast() != target.peek()) {
//                deque.addFirst(deque.pollLast());
//                cnt++;
//            } else {
//                if(cnt > 0) {
//                    break;
//                }
//                deque.pollLast();
//                target.pop();
//            }
//        }
//        System.out.print(cnt);
    }
}