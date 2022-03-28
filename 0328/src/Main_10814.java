import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10814 {
	static class Member implements Comparable<Member>{
		int index,age;
		String name;
		
		public Member(int index, int age, String name) {
			this.index = index;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Member o) {
			if(this.age==o.age) return this.index-o.index;
			return this.age-o.age;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		Member[] members = new Member[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			members[i] = new Member(i,Integer.parseInt(st.nextToken()),st.nextToken());
		}
		Arrays.sort(members);
		StringBuilder sb = new StringBuilder();
		for (Member member : members) {
			sb.append(member.age+" "+member.name).append("\n");
		}
		System.out.println(sb);
	}

}
