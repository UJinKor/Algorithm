import java.util.HashMap;

public class Solution {
	public static void main(String[] args) {
		
		
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		HashMap<String,String> parent = new HashMap<>();
		HashMap<String,Integer> person = new HashMap<>();
		
		int[] answer = new int[enroll.length];
		for (int i = 0; i < enroll.length; i++) {
			parent.put(enroll[i],referral[i]);
			person.put(enroll[i], 0);
		}
		person.put("-", 0);
		for (int i = 0; i < seller.length; i++) {
			String s = seller[i];
			int money = amount[i]*100;
			
			while(money>0) {
				person.put(s, (int)(person.get(s)+money-(int)(money*0.1)));
				if(s.equals("-")) break;
				s = parent.get(s);
				money = (int)(money*0.1);
			}
		}
		for (int j = 0; j < enroll.length; j++) {
			if(person.containsKey(enroll[j])) {
				answer[j] = person.get(enroll[j]);
			} else {
				answer[j] = 0;
			}
		}
		
	}

}
