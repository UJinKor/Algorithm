import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] circle = new int[n];//1~n까지 순서대로 들어있는 배열
		int[] ans = new int[n];//요세푸스 순열
		for (int i = 0; i < circle.length; i++) { //1~n 삽입
			circle[i] = i+1;
		}
		int currentIndex = -1;//현재 인덱스
		int j = 0; //ans 배열의 인덱스
		int cnt = 0;
		while(true){ //돌려가며 숫자 제거
			currentIndex++;
			if(currentIndex == n) {//배열 끝 도달시 0으로 초기화
				currentIndex = 0;
			}
			if(circle[currentIndex] != 0) { // 0은 이미 꺼내진 숫자
				cnt++;
				if(cnt==k) {//k번 돌았을때
					ans[j] = circle[currentIndex];
					circle[currentIndex] = 0;
					cnt = 0;
					j++;
				}
			}
			if(j==n) {
				break;
			}
			
		}
		print(ans);
	}

	public static void print(int arr[]) {
		System.out.print("<");
		for (int i = 0; i < arr.length; i++) {
			
			if(i==arr.length-1) System.out.print(arr[i]);
			else System.out.print(arr[i]+", ");
		}
		System.out.print(">");
	}
}

