import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[] isChk;
	static int numbers[];
	static int input[];
	static int n;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		n = Integer.parseInt(br.readLine());
		input = new int[n];
		numbers = new int[n];
		isChk = new boolean[n];
		for (int i = 1; i <= n; i++) {
			input[i-1] = i;
		}
		permutation(0);
		System.out.println(sb);
	}
	public static void permutation(int cnt) {
		if(cnt==n) {
			for (int i = 0; i < n; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < n; i++) {
			if(isChk[i]) continue;
			numbers[cnt] = input[i];
			isChk[i] = true;
			permutation(cnt+1);
			isChk[i] = false;
		}
	}

}
