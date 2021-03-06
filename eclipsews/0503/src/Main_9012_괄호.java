import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_괄호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			boolean isVPS = true;
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if(c=='(') {
					stack.push(c);
				} else {
					if(stack.isEmpty()) {
						isVPS = false;
						break;
					}
					stack.pop();
				}
			}
			if(!stack.isEmpty())
				isVPS = false;
			if(isVPS) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}

}
