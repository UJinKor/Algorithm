import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S2_4948_베르트랑_공준 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = -1;
		StringBuilder sb = new StringBuilder();
		while((n=Integer.parseInt(br.readLine())) != 0) {
			int cnt = 0;
			boolean che[] = new boolean[2*n+1];
			for (int i = 2; i < 2*n+1; i++) {
				if(!che[i]) {
					if(i>n && i<=2*n) cnt++;
					int index = 2*i;
					while(index<2*n+1) {
						che[index] = true;
						index += i;
					}
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}

}
