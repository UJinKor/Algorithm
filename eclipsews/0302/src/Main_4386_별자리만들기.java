import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_4386_별자리만들기 {
	static class Star{
		double x,y;

		public Star(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		Star[] stars = new Star[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			stars[i] = new Star(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
		}
		
		int start = 0;
		double minDist[] = new double[N];
		boolean[] visited = new boolean[N];
		Arrays.fill(minDist, Double.MAX_VALUE);
		minDist[start] = 0;
		double result = 0;
		for (int c = 0; c < N; c++) {
			double min = Double.MAX_VALUE;
			int current = -1;
			for (int i = 0; i < N; i++) {
				if(!visited[i]&&min>minDist[i]) {
					min = minDist[i];
					current = i;
				}
			}
			
			result += min;
			visited[current] = true;
			
			for (int i = 0; i < N; i++) {
				if(!visited[i]&&minDist[i]>dist(stars[current],stars[i])) {
					minDist[i] = dist(stars[current],stars[i]);
				}
			}
		}
		System.out.println(result);
	}
 	public static double dist(Star s1, Star s2) {
		return Math.sqrt(((s1.x-s2.x)*(s1.x-s2.x))+((s1.y-s2.y)*(s1.y-s2.y)));
	}
}
