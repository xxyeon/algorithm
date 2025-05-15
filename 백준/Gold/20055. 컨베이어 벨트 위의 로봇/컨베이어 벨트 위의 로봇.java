import java.io.*;
import java.util.Arrays;

public class Main {
	private static int[] conveyor;
	private static int[] robot;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = bf.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		conveyor = new int[2*n+1];
		for(int i=0; i < 2*n; i++) {
			conveyor[i+1] = arr[i];
		}
		robot = new int[2*n +1];
		int temp = k;
		//1->2->3
		int cycle = 0;

		while(k>0) {
			k = temp;
			rotate(n);

			if(robot[n] == 1) robot[n] = 0;
			move(n);

			if(robot[n] == 1) robot[n] = 0;
			put();
			cycle++;

			for(int i=1; i < 2*n+1; i++) {
				if(conveyor[i]==0)k--;
			}
		}
		System.out.print(cycle);

	}

	private static void rotate(int n) {
		int temp = conveyor[2*n];
		int tempRobot = robot[2 * n];
		for(int i=2*n-1; i>0; i--) {
			conveyor[i+1] = conveyor[i];
			robot[i+1] = robot[i]; //로봇도 같이 돌아야함.
		}
		conveyor[1] = temp;
		robot[1] = tempRobot;
	}

	private static void move(int n) {
		int temp = robot[2*n];
		for(int i=2*n-1; i>0; i--) {
			if (conveyor[i+1] > 0 && (robot[i+1] == 0 && robot[i] == 1)) {
				robot[i+1] = robot[i];
				robot[i] = 0;
				conveyor[i+1]--;
			}

		}
		if (conveyor[1] > 0 && (robot[1] == 0 && temp == 1)) {
			conveyor[1]--;
			robot[1] = temp;
		}
	}

	private static void put() {
		if(conveyor[1] >0 && robot[1] == 0) {
			conveyor[1]--;
			robot[1] = 1;
		}
	}
}

