
public class Solution {

	public static void main(String[] args) {
		int k =2;
		int m = 3451;
		String[] names = {"abcd", "aBCd", "jsKIM", "rrr", "rrr"};
		int[] amounts = {950, 1000, 1400, 4000, 10000};
		int answer = 0;
		String prevName = "";
		int count = 0;
		for (int i = 0; i < amounts.length; i++) {
			if(!(names[i].toUpperCase()).equals(prevName.toUpperCase())) { //이전사람이랑 불일치
				if(amounts[i]>=m) {
					answer++;
				}
				prevName = names[i];
				count = 1;
			} else {//일치
				count++;
				if(count>=k) {
					answer++;
				}
				else if(amounts[i]>=m) {
					answer++;
				}
			}
			
		}
		System.out.println(answer);
	}

}
