import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main_10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		String s;
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			switch(s) {
				case("push"):
					int n = Integer.parseInt(st.nextToken());
					stack.push(n);
					break;
				case("pop"):
					if(stack.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(stack.pop()).append("\n");
					}
					break;
				case("size"):
					sb.append(stack.size()).append("\n");
					break;
				case("empty"):
					if(stack.isEmpty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
				case("top"):
					if(stack.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(stack.peek()).append("\n");
					}
					break;
			}
		}
		System.out.println(sb);
	}

}
