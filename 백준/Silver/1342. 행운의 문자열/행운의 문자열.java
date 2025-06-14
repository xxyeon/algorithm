import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	private static int[] alphabet = new int[27];
	private static char[] n;
	private static int count;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = br.readLine().toCharArray();
        //이전 문자랑 다르면 됨

		for(int i=0; i<n.length;i++) {
			int idx = n[i] - 'a';
			alphabet[idx]++;
		}
		dfs("", ' ');
		System.out.print(count);
	}

	private static void dfs(String s, char prev) {
		if (s.length() == n.length) {
			count++;
		}
		for(int i=0; i<27;i++) { //알파벳을 기준으로 돌려야함.
			if(alphabet[i] == 0) continue;
			char next = (char)(i+'a');
			if(prev != next){
				//이전 문자와 같지 않으면
				alphabet[i]--;
				dfs(s + next, next);
				alphabet[i]++;
			}

		}
	}



}