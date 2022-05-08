import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10158_개미 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int w,h,p,q,t;
		st = new StringTokenizer(br.readLine()," ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(br.readLine());
		
		int x = (p+t)/w;
		int y = (q+t)/h;
		
		if(x%2==0) {
			p=(p+t)%w;
		} else {
			p=w-(p+t)%w;
		}
		if(y%2==0) {
			q=(q+t)%h;
		} else {
			q=h-(q+t)%h;
		}
		
		System.out.println(p+" "+q);
	}//eom
}
