import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int curTop=-1;
		int curBottomI=-1;
		int curTopI=-1;
		int max=0;
		int sum = 0;
		int nums[][] = new int[N][6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 6; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 6; i++) {
			sum = 0;
			for (int j = 0; j < N; j++) {
				if(j==0) {
					curTop = nums[j][i];//첫 번째 주사위 맨 위 인덱스가 i일때,
					curTopI = i;
					curBottomI = getTopIndex(curTopI);
				} else {
					curBottomI = searchIndex(curTop,nums[j]);
					curTopI = getTopIndex(curBottomI);
					curTop = nums[j][curTopI];//현재 top의 숫자
				}
				sum += getMaxSide(curBottomI,curTopI,nums[j]);
			}
			max= Math.max(sum, max);
		}
		System.out.println(max);
	}//eom
	public static int searchIndex(int n,int arr[]) {
		int idx=-1;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==n) {
				idx = i;
				break;
			}
		}
		return idx;
	}
	public static int getTopIndex(int bottomIndex) {
		int topIndex=-1;
		switch(bottomIndex) {
		case 0:
			topIndex = 5;
			break;
		case 1:
			topIndex = 3;
			break;
		case 2:
			topIndex = 4;
			break;
		case 3:
			topIndex = 1;
			break;
		case 4:
			topIndex = 2;
			break;
		case 5:
			topIndex = 0;
			break;
		}
		return topIndex;
	}
	public static int getMaxSide(int bottomIndex,int topIndex, int[] arr) {
		
		int max=-1;
		for (int i = 0; i < arr.length; i++) {
			if(i==topIndex||i==bottomIndex) continue;
			max = Math.max(max, arr[i]);
		}
		return max;
	}
	
}
