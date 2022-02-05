import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		for(int i = 1 ; i <= n ; i++){
	        a %= b;
	        a *= 10;
	    }
		int ans = a/b;
		
		System.out.println(ans);
		
		sc.close();
	}

}
