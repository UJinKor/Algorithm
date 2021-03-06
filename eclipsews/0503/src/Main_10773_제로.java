import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773_제로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) stack.pop();
			else stack.push(n);
		}
		long sum = 0;
		while(!stack.isEmpty())
			sum+=stack.pop();
		System.out.println(sum);
	}

}
