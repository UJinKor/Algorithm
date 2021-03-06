import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt=0;
		String s;
		boolean isGroup;
		char c='!';//알파벳아닌거 아무거나, 이전단어
		for (int i = 0; i < n; i++) {
			boolean[] arr = new boolean[26];
			isGroup = true;
			s = br.readLine();
			char[] chars = s.toCharArray();
			for (int j = 0; j < chars.length; j++) {
				if(arr[chars[j]-'a']) {//이미 나왔던 알파벳
					if(c!=chars[j]) {//연속아니면
						isGroup = false;
						break;
					}
				} else {
					arr[chars[j]-'a'] = true;
					c = chars[j];
				}
			}
			if(isGroup) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}

