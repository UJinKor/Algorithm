
public class Solution2 {
	public static void main(String[] args) {
		int[] a = {1, 50};
		int[] b = {51, 100};
		
		int duration = 100;
		int distance = 100;
		
		int result = -1;
		
		for (int aDist = 0; aDist <= distance; aDist++) { // aDist = a가 이동하는 거리
			int bDist = distance-aDist; // bDist = b가 이동하는 거리
			int aStart = a[0]+aDist;
			int bStart = b[0]+bDist;
			
			//약속장소에 둘다 도착한 시간
			int meet = Math.max(aStart,bStart);
			//두명이 집에 각각 도착한 시간
			int aEnd = meet+aDist+duration;
			int bEnd = meet+bDist+duration;
			
			if(a[1]>=aEnd && b[1]>=bEnd) {
				if(result == -1 ) result = meet;
				result = Math.min(meet, result);
			}
			
		}
		System.out.println(result);
	}
}
