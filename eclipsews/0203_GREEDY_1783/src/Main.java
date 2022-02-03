import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ans;
		if(n==1) ans =1;
		else if(n==2) {
			ans = (m-1)/2+1;
			if(ans>=4) ans = 4;
		} else {
			if(m<=4) ans = m;
			else if(m==5) ans = 4;
			else ans = m-2;
		}
		
		System.out.println(ans);
	}

}
