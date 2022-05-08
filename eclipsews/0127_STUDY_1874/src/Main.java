import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> list = new ArrayList<>();
		int num;
		int m = 0;//오름차순으로 넣을 수
		boolean valid = true;
		for (int i = 0; i < n; i++) {
			num = Integer.parseInt(br.readLine());
			while(true) {
				if(m>n) {
					valid = false;
					break;
				}
				if(stack.isEmpty()||stack.peek()<num) {
					stack.push(++m);
					list.add(1);
				}
				else if(stack.peek()>num) {
					stack.pop();
					list.add(0);
				}
				else {
					stack.pop();
					list.add(0);
					break;
				}
			}
		}
		if(valid) {
			for (Integer integer : list) {
				if(integer.equals(1)) {
					System.out.println('+');
				} else {
					System.out.println('-');
				}
			}
			
		} else {
			System.out.println("NO");
		}
		
	}

}
