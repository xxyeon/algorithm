import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Problem implements Comparable<Problem>{
    int number, level, algo;
    Problem(int number, int level, int algo) {
        this.number = number;
        this.level = level;
        this.algo = algo;
    }

    @Override
    public int compareTo(Problem p) {
        if (level == p.level) return number - p.number;
        return level - p.level;
    }
}

public class Main {
    static Map<Integer, Problem> recommendLst = new HashMap<>();
    static TreeSet<Problem> set = new TreeSet<>();
    static Map<Integer, TreeSet<Problem>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            int algo = Integer.parseInt(st.nextToken());

            Problem p = new Problem(number, level, algo);
            recommendLst.put(number, p);

            set.add(p);
            TreeSet<Problem> value = map.get(algo) == null ? new TreeSet<>() : map.get(algo);
            value.add(p);
            map.put(algo, value);
        }

        int Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if (op.equals("recommend")) {
                int g = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) { // 가장 어려운 문제
                    int number = map.get(g).last().number;
                    sb.append(number).append('\n');
                } else { // 가장 쉬운 문제
                    int number = map.get(g).first().number;
                    sb.append(number).append('\n');
                }
            }

            else if (op.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) { // 가장 어려운 문제
                    int number = set.last().number;
                    sb.append(number).append('\n');
                } else { // 가장 쉬운 문제
                    int number = set.first().number;
                    sb.append(number).append('\n');
                }
            }

            else if (op.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                int number = -1;
                Problem problem = new Problem(number, level, -1);
                if (x == 1) { // 크거나 같은 난이도 중 가장 쉬운 문제
                    Problem p = set.ceiling(problem);
                    if (p != null) {
                        number = p.number;
                    }
                } else { // 작거나 같은 난이도 중 가장 어려운 문제
                    Problem p = set.floor(problem);
                    if (p != null) {
                        number = p.number;
                    }
                }
                sb.append(number).append('\n');
            }

            else if (op.equals("add")) {
                int number = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                int algo = Integer.parseInt(st.nextToken());

                Problem p = new Problem(number, level, algo);
                recommendLst.put(number, p);

                set.add(p);
                TreeSet<Problem> value = map.get(algo) == null ? new TreeSet<>() : map.get(algo);
                value.add(p);
                map.put(algo, value);
            }

            else if (op.equals("solved")) {
                int number = Integer.parseInt(st.nextToken());
                Problem p = recommendLst.remove(number);

                // treeAsc 제거
                TreeSet<Problem> set1 = map.get(p.algo);
                set1.remove(p);
                if(set1.isEmpty()) {
                    map.remove(p.algo);
                }
                // mapAsc 제거
                set.remove(p);
            }
        }

        System.out.print(sb);
    }
}
