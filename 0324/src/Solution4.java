import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution4 {

	public static void main(String[] args) {
		String s = "2021:04:12:16:08:35";
		String[] times = {"01:06:30:00", "01:01:12:00", "00:00:09:25"};
		int[] answer = new int[2];
		//초단위로 생각
		StringTokenizer st = new StringTokenizer(s,":");
		//년
		BigInteger start = BigInteger.valueOf(Integer.parseInt(st.nextToken())).multiply(BigInteger.valueOf(60*60*24*30*12));
		//월
		start = start.add(BigInteger.valueOf(Integer.parseInt(st.nextToken())*60*60*24*30));
		//일
		start = start.add(BigInteger.valueOf(Integer.parseInt(st.nextToken())*60*60*24));	
		//시
		start = start.add(BigInteger.valueOf(Integer.parseInt(st.nextToken())*60*60));			
		//분
		start = start.add(BigInteger.valueOf(Integer.parseInt(st.nextToken())*60));		
		//초
		start = start.add(BigInteger.valueOf(Integer.parseInt(st.nextToken())));
		
		BigInteger[] times_sec = new BigInteger[times.length];
		for (int i = 0; i < times_sec.length; i++) {
			st = new StringTokenizer(times[i],":");
			times_sec[i] = new BigInteger("0");
			//일
			times_sec[i] = times_sec[i].add(BigInteger.valueOf(Integer.parseInt(st.nextToken())*60*60*24));	
			//시
			times_sec[i] = times_sec[i].add(BigInteger.valueOf(Integer.parseInt(st.nextToken())*60*60));			
			//분
			times_sec[i] = times_sec[i].add(BigInteger.valueOf(Integer.parseInt(st.nextToken())*60));		
			//초
			times_sec[i] = times_sec[i].add(BigInteger.valueOf(Integer.parseInt(st.nextToken())));
		}
		
		//60*60*24 1일
		BigInteger sum = start;
		BigInteger day = sum.divide(BigInteger.valueOf(60*60*24));
		BigInteger starts = day;
		int isValid = 1;
		for (int i = 0; i < times_sec.length; i++) {
			sum = sum.add(times_sec[i]);
			BigInteger temp = sum.divide(BigInteger.valueOf(60*60*24));
			if(day.add(new BigInteger("1")).compareTo(temp)==-1) {
				isValid = 0;
			}
			day = temp;
		}
		answer[0] = isValid;
		answer[1] = day.subtract(starts).intValue()+1;
		
		System.out.println(answer[0]+" "+answer[1]);
	}

}
