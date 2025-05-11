import java.io.*;
import java.util.Arrays;

public class Main {
	private static int min = Integer.MAX_VALUE;
	private static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String n = bf.readLine();
		dfs(n, 0);
		sb.append(min).append(" ").append(max);
		System.out.print(sb.toString());
	}

	private static void dfs(String numStr, int currentOddCount) {
		//새로운 수에 대해 홀수 세어주기
		int thisOddCount = getOddCount(numStr); //홀수 세기
		// System.out.println(thisOddCount);
		//numStr에  홀수 개수 더하기
		currentOddCount += thisOddCount;
		// System.out.println("currentOddCount: "+ currentOddCount);
		if (numStr.length() == 1) {
			// System.out.println("MIN: " + min + " " + currentOddCount);
			// System.out.println("MAX: " + max + " " + currentOddCount);
			min = Math.min(min, currentOddCount); //min과 max는 재귀함수에 영향을 받으면 안됨.
			max = Math.max(max, currentOddCount);
		} else if(numStr.length() == 2) {
			int num1 = Integer.parseInt(numStr.substring(0,1));
			int num2 = Integer.parseInt(numStr.substring(1));
			int newInt = num1 + num2;
			// System.out.println("newInt: " + newInt);
			// thisOddCount = getOddCount(String.valueOf(newInt)); // 홀수 개수 TODO: 홀수 개수 구하는 메서드
			dfs(String.valueOf(newInt), currentOddCount);
		} else {
			//3자리
			for(int i = 1; i < numStr.length()-1; i++) {
				for (int k = i+1; k < numStr.length(); k++) {
					 int num1 = Integer.parseInt(numStr.substring(0,i));
					 int num2 = Integer.parseInt(numStr.substring(i,k));
					 int num3 = Integer.parseInt(numStr.substring(k));
					 int newInt  = num1 + num2 + num3;
					// thisOddCount = getOddCount(String.valueOf(newInt));
					dfs(String.valueOf(newInt), currentOddCount);
				}
			}
		}
	}

	private static int getOddCount(String numStr) {
		int oddCnt = 0;
		for(int i = 0; i < numStr.length(); i++) {
			int num = numStr.charAt(i) - '0';
			if(num % 2 == 1) {
				//홀수
				oddCnt++;
			}
		}
		return oddCnt;
	}


}

