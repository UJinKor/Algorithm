import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2304_창고_다각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		
		int[][] sticks = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			sticks[i][0] = Integer.parseInt(st.nextToken());
			sticks[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sticks, (o1,o2) -> o1[0]-o2[0]);//첫번째 인자로 정렬
		
		int maxH = 0;
		int maxI = 0;
		for (int i = 0; i < sticks.length; i++) {
			if(maxH<sticks[i][1]) {
				maxH = sticks[i][1];
				maxI = i;
			}
		}
		int index = 0;//앞에서부터
		int curH=sticks[0][1];//계산되어지는 높이
		int curI=sticks[0][0];//높이의 인덱스
		int sum=maxH;
		while(index<maxI) {
			index++;
			if(curH<=sticks[index][1]) {//기둥 길이가 maxH로 같을 경우 계산이 안되어지고 빠져나오는 경우가 생길 수 있으므로 <= 가 맞다.
				sum+=curH*(sticks[index][0]-curI);
				curH = sticks[index][1];
				curI = sticks[index][0]; 
			}
		}
		index = N-1;//뒤에서부터
		curH=sticks[N-1][1];
		curI=sticks[N-1][0];
		while(index>maxI) {
			index--;
			if(curH<=sticks[index][1]) {
				sum+=curH*(curI-sticks[index][0]);
				curH = sticks[index][1];
				curI = sticks[index][0]; 
			}
		}
		
		System.out.println(sum);
	}

}
