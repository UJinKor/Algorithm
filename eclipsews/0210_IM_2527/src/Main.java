import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int x1,y1,p1,q1;
		int x2,y2,p2,q2;
		char ans;
		for (int T = 0; T < 4; T++) {//Testcase
			st = new StringTokenizer(br.readLine()," ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			p1 = Integer.parseInt(st.nextToken());
			q1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			p2 = Integer.parseInt(st.nextToken());
			q2 = Integer.parseInt(st.nextToken());
			
			//꼭짓점
			if((x1==p2&&y1==q2)||(x1==p2&&q1==y2)||(p1==x2&&q1==y2)||(p1==x2&&y1==q2)) ans = 'c';
			//변
			else if((x1==p2&&y1<q2&&y2<q1)||(q1==y2&&x1<p2&&x2<p1)||(p1==x2&&y1<q2&&y2<q1)||(y1==q2&&x1<p2&&x2<p1)) ans = 'b';
			//직사각형
			else if((x1<x2&&p2<p1&&y1<y2&&q2<q1)||(x1<x2&&p2<p1&&y1<q2&&y2<q1)||(x1<p2&&x2<p1&&y1<q2&&y2<q1)||(x1<p2&&x2<p1&&y1<y2&&q2<q1)||
					(x2<x1&&p1<p2&&y2<y1&&q1<q2)||(x2<x1&&p1<p2&&y2<q1&&y1<q2)||(x2<p1&&x1<p2&&y2<q1&&y1<q2)||(x2<p1&&x1<p2&&y2<y1&&q1<q2)) 
				ans = 'a';
			//안곂침
			else ans = 'd';
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		
		
	}//endofmain
}
