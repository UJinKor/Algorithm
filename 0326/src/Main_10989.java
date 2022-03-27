import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] counter = new int[10001];
		for (int i = 0; i < N; i++) counter[Integer.parseInt(br.readLine())]++;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= 10000; i++) {
			for (int j = 0; j < counter[i]; j++) {
				sb.append(i+"\n");
			}
			if(sb.length()>0) {
				sb.setLength(sb.length()-1);
				System.out.println(sb);
				sb.setLength(0);
			}
		}
	}
}
