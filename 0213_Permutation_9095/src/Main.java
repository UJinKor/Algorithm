import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int input[];
	static int n;
	static int ans;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			ans=0;
			n = Integer.parseInt(br.readLine());
			input = new int[3];
			for (int j = 1; j <= 3; j++) {
				input[j-1] = j;
			}
			permutation(0,0);
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	public static void permutation(int cnt,int sum) {
		if(sum>=n) {
			if(sum==n) ans+=1;
			return;
		}
		for (int i = 0; i < 3; i++) {
			permutation(cnt+1,sum+input[i]);
		}
	}

}
