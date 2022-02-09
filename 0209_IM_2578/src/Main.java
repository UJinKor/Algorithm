import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board = new int[5][5];
	static boolean[][] checked = new boolean[5][5];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int ans = 0;
		
		for (int i = 0; i < 5; i++) {//배열 입력
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {//배열 입력
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 5; j++) {
				checkBingo(Integer.parseInt(st.nextToken()));
				if(i*5+j+1>=12&&ans==0) {//최소 12개 이상 체크되야 빙고 3개 가능성생김, ans값 들어오면 아예 체크하지않기
					if(isThreeBingo()) {
						ans = i*5+j+1;
					}
				}
			}
		}
		
		System.out.println(ans);
		
	}
	public static void print(boolean[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void checkBingo(int num) {//빙고판에 마크
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j]==num) {
					checked[i][j] = true;
				}
			}
		}
	}
	public static boolean isThreeBingo() {//3빙고인지 확인
		int bingo = 0;
		boolean isBingo=true;
		for (int i = 0; i < board.length; i++) {//가로
			isBingo = true;
			for (int j = 0; j < board.length; j++) {
				if(!checked[i][j]) {
					isBingo = false;
					continue;
				}
			}
			if(isBingo) {
				bingo++;
			}
		}
		
		for (int i = 0; i < board.length; i++) {//세로
			isBingo = true;
			for (int j = 0; j < board.length; j++) {
				if(!checked[j][i]) {
					isBingo = false;
					continue;
				}
			}
			if(isBingo) {
				bingo++;
			}
		}
		isBingo = true;
		for (int i = 0; i < board.length; i++) {//대각1
			if(!checked[i][i]) {
				isBingo = false;
				break;
			}
		}
		if(isBingo) {
			bingo++;
		}
		isBingo = true;
		for (int i = 0; i < board.length; i++) {//대각2
			if(!checked[i][board.length-i-1]) {
				isBingo = false;
				break;
			}
		}
		if(isBingo) {
			bingo++;
		}
		
		
		if(bingo>=3) return true;
		else return false;
	}
	
	

}
