package test;

import java.util.Arrays;

public class Solution3 {
	public static void main(String[] args) {
		int n=9;
		boolean clockwise=false;
		//---------------------------------
		int[] r = new int[4];
		int[] c = new int[4];
		if(clockwise) {//우 하 좌 상
			r[0] = 0;
			c[0] = 1;
			
			r[1] = 1;
			c[1] = 0;
			
			r[2] = 0;
			c[2] = -1;
			
			r[3] = -1;
			c[3] = 0;
		} else {//하 우 상 좌
			r[0] = 1;
			c[0] = 0;
			
			r[1] = 0;
			c[1] = 1;
			
			r[2] = -1;
			c[2] = 0;
			
			r[3] = 0;
			c[3] = -1;
		}
		int[][] answer = new int[n][n];
		int startIndex = 1; //시작 count
		int turnCounts = 0; //방향전환 횟수
		int count = startIndex;
		int dir = 0;
		int curY = 0, curX = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				answer[curY][curX] = count++;
				int nr = curY+r[dir];
				int nc = curX+c[dir];
				if(nr<0||nc<0||nr>=n||nc>=n||answer[nr][nc]!=0) {
					turnCounts++;
					if(turnCounts>=4) {
						startIndex = count;
						count = startIndex;
						turnCounts=0;
					} else {
						count = startIndex;
						answer[curY][curX] = count++;
					}
					dir = ++dir%4;
					nr = curY+r[dir];
					nc = curX+c[dir];
				}
				curY = nr;
				curX = nc;
			}
		}
		
		
	}

}
