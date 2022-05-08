import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11723_집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int S = 0;
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String command = st.nextToken();
			int x;
			int y;
			switch(command) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				S |= 1<<x;
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				y = 0;
				if((S&1<<x)>0) y = 1;
				sb.append(y).append("\n");
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
//				y = S&1<<x;
//				if(y>0) S-=y;
				S &= ~(1<<x);
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
//				y = S&1<<x;
//				if(y>0) S-=1<<x;
//				else S += 1<<x;
				S ^= 1<<x;
				break;
			case "all":
				S = -1;
				break;
			case "empty":
				S = 0;
				break;	
			}
		}
		System.out.println(sb);
	}
	

}
