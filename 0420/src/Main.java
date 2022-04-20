import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int end = sc.nextInt();
		int cnt = 0;
		int ansI = -1;
		int ansJ = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(cnt++==end) {
					ansI = i;
					ansJ = j;
				}
			}
		}
		System.out.println(ansI+" "+ansJ);
	}

}
