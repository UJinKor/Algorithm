import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		HashMap<String,String> hmap = new HashMap<>();
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		
		for (int i = 0; i < enroll.length; i++) {
			hmap.put(enroll[i],referral[i]);
		}
		
		
		
	}

}
