import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4949_균형잡힌_세상 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s="";
		StringBuilder sb = new StringBuilder();
		while(!(s = br.readLine()).equals(".")) {
			boolean isValid = true;
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(c=='('||c=='[') {
					stack.push(c);
				}
				if(c==')') {
					if(stack.isEmpty() || stack.pop() != '(') {
						isValid = false;
						break;
					}
				}
				if(c==']') {
					if(stack.isEmpty() || stack.pop() != '[') {
						isValid = false;
						break;
					}
				}
			}
			if(isValid && stack.isEmpty()) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
		}
		System.out.println(sb);
	}
}
