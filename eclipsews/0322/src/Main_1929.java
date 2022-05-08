import java.util.Scanner;

public class Main_1929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = start; i <= end; i++) {
			if(isPrime(i)) sb.append(i+"\n");
		}
		System.out.println(sb);
	}
	
	public static boolean isPrime(int n) {
		if(n==1) return false;
		int num = (int)Math.sqrt(n);
		while(num>1) {
			if(n%num--==0) return false;
		}
		return true;
	}

}
