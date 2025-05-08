import java.io.*;
import java.util.Arrays;
public class Main {
	private final static int[][] move = {{1,0}, {-1,0}, {0, 1}, {0,-1}, {-1, 1}, {-1,-1}, {1,1}, {1,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		char[] left = {'q','w','e','r','t','a','s','d','f','g','z','x','c','v','0'};
		char[] right = {'0','y','u','i','o','p','0','h','j','k','l','0', 'b','n','m','0','0','0'};

		char[] arr = bf.readLine().toCharArray();
		char[] s = bf.readLine().toCharArray();
		int rx = 0;
		int ry= 0;

		int lx = 0;
		int ly= 0;

		for (char ch : arr) {
			for (int i = 0; i < left.length; i++) {
				if (left[i] == ch) {
					lx = i / 5;
					ly = i % 5;
				}
			}
			for (int i = 0; i < right.length; i++) {
				if (right[i] == ch) {
					rx = i/6;
					ry = i%6;
				}
			}
		}

		int answer = 0;
		for (char ch : s) {
			for (int i = 0; i < left.length; i++) {
			
				if (left[i] == ch) {
					answer += getLeftDistance(lx, ly, i);
					lx = i/5;
					ly = i%5;
					break;
				} else if (right[i] == ch) {
					answer += getRightDistance(rx, ry, i);
					rx = i/6;
					ry = i%6;
					break;
				}
			}
		}

		System.out.print(answer + s.length);
	}
	static private int getLeftDistance(int currentX, int currentY, int idx) {
		int targetX  = idx / 5;
		int targetY = idx % 5;
		return Math.abs(currentX - targetX) + Math.abs(currentY - targetY);
	}

	static private int getRightDistance(int currentX, int currentY, int idx) {
		int targetX  = idx / 6;
		int targetY = idx % 6;
		return Math.abs(currentX - targetX) + Math.abs(currentY - targetY);
	}

}

