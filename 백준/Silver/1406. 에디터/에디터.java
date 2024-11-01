import java.io.*;
import java.util.*;
public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static int  n;
    static int m;
    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //초기 커서는 맨뒤에 위치
        char[] str = br.readLine().toCharArray();

        LinkedList<String> lst = new LinkedList<>();
        for (int i = 0; i < str.length; i++) {
            lst.add(String.valueOf(str[i]));
        }
        ListIterator<String> iter = lst.listIterator();

        while(iter.hasNext()) {
            iter.next();
        }

        int pointer = lst.size();
        String node = lst.get(pointer-1);
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i<num; i++) {
            String[] instruction = br.readLine().split(" ");
            String ins = instruction[0];

            if (ins.equals("P")) {
                String input = instruction[1];
                //position 왼쪽에 추가
                iter.add(input);
            } else if (ins.equals("L")) {
                if(iter.hasPrevious()) {
                    iter.previous();
                }
            } else if (ins.equals("D")){
                if(iter.hasNext()) {
                    iter.next();
                }
            } else if (ins.equals("B")) {
               if (iter.hasPrevious()) {
                   iter.previous();
                   iter.remove();
               }
            }
            }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String i : lst) {
            bw.write(i);
        }
        bw.close();
        }
}
