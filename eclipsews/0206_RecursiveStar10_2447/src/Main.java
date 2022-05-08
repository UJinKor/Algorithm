import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[][] arr = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = ' ';
			}
		}
		printStar(arr,0,0,n);
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
		sc.close();
	}
	
	public static void printStar(char arr[][],int startX, int startY, int n) {
		if(n==1) {
			arr[startX][startY] = '*';
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(!(i==1&&j==1)) {
					printStar(arr,((n/3)*j)+startX,((n/3)*i)+startY,n/3);
				}
			}
		}
		
	}
}
