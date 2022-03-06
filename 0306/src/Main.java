import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Point{
		double x,y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			int S = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			Point[] outposts = new Point[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				outposts[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			boolean visited[] = new boolean[N];
			double minDist[] = new double[N];
			Arrays.fill(minDist, Double.MAX_VALUE);
			minDist[0] = 0;
			for (int c = 0; c < N; c++) {
				double min = Double.MAX_VALUE;
				int current = -1;
				for (int i = 0; i < N; i++) {
					if(!visited[i]&&min>minDist[i]) {
						min = minDist[i];
						current = i;
					}
				}
				
				visited[current] = true;
				
				for (int i = 0; i < N; i++) {
					if(!visited[i]&&minDist[i]>dist(outposts[current],outposts[i])) {
						minDist[i] = dist(outposts[current],outposts[i]);
					}
				}
			}
			for (int i = 0; i < S-1; i++) {//위성 개수-1만큼 최소간선 집합 중 최대 거리를 빼준다.
				double max = -1;
				int maxI = -1;
				for (int j = 0; j < N; j++) {
					if(max<minDist[j]) {
						max = minDist[j];
						maxI = j;
					}
				}
				minDist[maxI] = 0;//최대 값은 위성으로 대체되므로 0의 거리를 준다.
			}
			double result = -1;
			for (int i = 0; i < N; i++) {
				result=Math.max(result, minDist[i]);
			}
			System.out.printf("%.2f\n",result);//아니 이거 왜 \n붙여 줘야 통과댐?....... 매우중요
		}//eotc
	}//eom
	public static double dist(Point p1,Point p2) {
		return Math.sqrt(((p1.x-p2.x)*(p1.x-p2.x))+((p1.y-p2.y)*(p1.y-p2.y)));
	}
}