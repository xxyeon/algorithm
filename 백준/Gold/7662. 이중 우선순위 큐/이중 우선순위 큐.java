
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<Integer, Integer> map = new HashMap<>(); //tree에 중복값이 저장안되므로 map 에 저장
            TreeSet<Integer> tree = new TreeSet<>(); //오름차순
            for(int j=0;j<n;j++) {
                String[] order = br.readLine().split(" ");
                String op = order[0];
                int num = Integer.parseInt(order[1]);
                if (op.equals("I")) {
                    tree.add(num);
                    if(map.get(num) == null) {
                        map.put(num, 1);

                    }
                    else map.replace(num, map.get(num) + 1);
                }else if(op.equals("D")) {
                    if(tree.isEmpty()) continue;
                    if(num == 1) {
                        int del = tree.last();

                        if (map.get(del) != 0) {
                            map.replace(del, map.get(del)-1);
                            if (map.get(del) == 0) {
                                //map에서 삭제후 0이면 트리에서 삭제
                                tree.pollLast(); //최댓값
                            }
                        }

                    } else {
                        int del = tree.first();

                        if(map.get(del) != 0) {
                            map.replace(del, map.get(del) - 1);
                            if(map.get(del) == 0) {
                                tree.pollFirst();
                            }
                        }
                    }
                }
            }

            if(tree.isEmpty()) {
                sb.append("EMPTY").append('\n');
            } else {
                int first = tree.first();
                int last = tree.last();
                sb.append(last).append(" ").append(first).append('\n');
            }

        }
        System.out.print(sb.toString());

    }
}

