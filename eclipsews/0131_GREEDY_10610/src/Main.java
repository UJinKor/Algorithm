import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		boolean hasZero = false;
		List<Integer> ans = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '0') {
				hasZero = true;
			}
			sum += s.charAt(i)-'0';
		}
		
		
		if(sum%3==0&&hasZero) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			for (int i = c.length-1; i >=0 ; i--) {
				ans.add(c[i]-'0');
			}
		} else {
			ans.add(-1);
		}
		
		for (Integer integer : ans) {
			System.out.print(integer);
		}
	}

}
