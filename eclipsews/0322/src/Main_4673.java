
public class Main_4673 {

	public static void main(String[] args) {
		boolean[] notSelf = new boolean[10001];
		for (int i = 1; i <= 10000; i++) {
			int num = d(i);
			if(num<=10000) {
				notSelf[num] = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10000; i++) {
			if(!notSelf[i]) sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int d(int n) {
		int sum = n;
		while(n>0) {
			sum+=n%10; 
			n/=10;
		}
		return sum;
	}

}
