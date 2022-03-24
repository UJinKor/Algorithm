import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution3 {
	static class Trans { // 거래의 단위
		double date; // 1월 1일 = 0 기준 얼마나 뒤의 날짜인지
		double rate; // 금리
		double amount; // 잔액
		
		public Trans(double date, double rate, double amount) {
			this.date = date;
			this.rate = rate;
			this.amount = amount;
		}
	}
	final static int[] MONTH_DAY = {0,31,31+28,31+28+31,31+28+31+30,31+28+31+30+31,31+28+31+30+31+30,
			31+28+31+30+31+30+31,31+28+31+30+31+30+31+31,31+28+31+30+31+30+31+31+30,
			31+28+31+30+31+30+31+31+30+31,31+28+31+30+31+30+31+31+30+31+30,31+28+31+30+31+30+31+31+30+31+30+31};
	public static void main(String[] args) {
		String[] lodgers = {"04/01 1 40000","05/01 5 20000","08/31 4 10000","11/11 0 -45000"};
		
		int answer = 0;
		ArrayList<Trans> tList = new ArrayList<>();
		for (String lodger : lodgers) {
			StringTokenizer st = new StringTokenizer(lodger," ");
			StringTokenizer st2 = new StringTokenizer(st.nextToken(),"/");
			int month = Integer.parseInt(st2.nextToken());
			int day = Integer.parseInt(st2.nextToken());
			double date = MONTH_DAY[month-1]+day;
			double rate = Double.parseDouble(st.nextToken());
			double amount = Double.parseDouble(st.nextToken());
			if(amount>0)
				tList.add(new Trans(date,rate/100,amount));
			else {
				amount = -amount;
				while(amount>0) {
					Trans t = tList.get(tList.size()-1);
					if(amount<t.amount) {
						t.amount -= amount;
						answer += (int)(amount*(t.rate)*((date-t.date)/365)); //이자 계산
						amount = 0;
					} else {
						amount -= t.amount;
						answer += (int)(t.amount*(t.rate)*((date-t.date)/365)); //이자 계산
						tList.remove(t);
					}
				}
			}
		}
		for (int i = 0; i < tList.size(); i++) {
			Trans t = tList.get(i);
			answer += (int)(t.amount*t.rate*((MONTH_DAY[12]-t.date)/365)); //이자 계산
		}
		System.out.println(answer);
		
	}

}
