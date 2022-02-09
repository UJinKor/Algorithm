import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());//가로
		int m = Integer.parseInt(st.nextToken());//세로
		
		int shopCount = Integer.parseInt(br.readLine());
		int [][] shops = new int[shopCount][2]; //shop의 좌표 0:x, 1:y
		int dir;
		for (int i = 0; i < shopCount; i++) {
			st = new StringTokenizer(br.readLine()," ");
			dir = Integer.parseInt(st.nextToken());
			switch(dir) {
			case 1://북
				shops[i][0] = Integer.parseInt(st.nextToken());
				shops[i][1] = m;
				break;
			case 2://남
				shops[i][0] = Integer.parseInt(st.nextToken());
				shops[i][1] = 0;
				break;
			case 3://서
				shops[i][0] = 0;
				shops[i][1] = m-Integer.parseInt(st.nextToken());
				break;
			case 4://동
				shops[i][0] = n;
				shops[i][1] = m-Integer.parseInt(st.nextToken());
				break;
			}
		}
		int[] x = new int[2]; // 동근이
		st = new StringTokenizer(br.readLine()," ");
		dir = Integer.parseInt(st.nextToken());
		switch(dir) {
		case 1://북
			x[0] = Integer.parseInt(st.nextToken());
			x[1] = m;
			break;
		case 2://남
			x[0] = Integer.parseInt(st.nextToken());
			x[1] = 0;
			break;
		case 3://서
			x[0] = 0;
			x[1] = m-Integer.parseInt(st.nextToken());
			break;
		case 4://동
			x[0] = n;
			x[1] = m-Integer.parseInt(st.nextToken());
			break;
		}
		int dist;
		int sum = 0;
		for (int[] shop : shops) {
			if(dir==1&&shop[1]==0) {//북<->남 서<->동
				dist = shop[0]+x[0]+m;
			} else if(dir==2&&shop[1]==m){
				dist = shop[0]+x[0]+m;
			} else if(dir==3&&shop[0]==n){
				dist = shop[1]+x[1]+n;
			}
			else if(dir==4&&shop[0]==0){
				dist = shop[1]+x[1]+n;
			} else {
				dist = Math.abs(shop[0]-x[0])+Math.abs(shop[1]-x[1]);
			}
			
			if(dist>n+m) {
				dist = 2*(n+m) - dist;
			}
			sum += dist;
		}
		System.out.println(sum);
	}

}
