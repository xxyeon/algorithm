import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        List<Ball> lst = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String[] temp = bf.readLine().split(" ");
            // for (String s: temp) {
            //     System.out.print(s + " ");
            // }
            // System.out.println();
            lst.add(new Ball(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
        }
        int[] answer = new int[N];
        for (Ball ball : lst) {
            for (int i = ball.getStart()-1; i<ball.getEnd(); i++) {
                answer[i] = ball.getBallNumber();
            }
        }
        for (int number : answer) {
            System.out.print(number + " ");
        }
    }

}

class Ball {
    int start;
    int end;
    int ballNumber;

    Ball(int start, int end, int ballNumber) {
        this.start = start;
        this.end = end;
        this.ballNumber = ballNumber;
    }

    int getStart() {
        return start;
    }
    int getEnd() {
        return end;
    }
    int getBallNumber() {
        return ballNumber;
    }
}