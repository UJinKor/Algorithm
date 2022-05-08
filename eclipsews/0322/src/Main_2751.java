import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_2751 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			A.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(A);
		StringBuilder sb = new StringBuilder();
		for (int i : A) {
			sb.append(i+"\n");
		}
		System.out.println(sb);
	}

}
