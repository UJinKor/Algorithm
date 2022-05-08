package test;

import java.math.BigInteger;

public class Solution {
	public static void main(String[] args) {
		int[][] diagonals = {{17,19}};
		int width =51;
		int height = 37;
		BigInteger answer = new BigInteger("0");
		int[][] diagLoc = new int[diagonals.length*2][2];//대각선 타는 좌표
		for (int i = 0; i < diagonals.length; i++) {
			diagLoc[2*i][0] = diagonals[i][0]-1;
			diagLoc[2*i][1] = diagonals[i][1];
			diagLoc[2*i+1][0] = diagonals[i][0];
			diagLoc[2*i+1][1] = diagonals[i][1]-1;
		}
		
		for (int i = 0; i < diagLoc.length; i++) {
			BigInteger temp = new BigInteger("0");
			temp = temp.add(permuCount(diagLoc[i]));
			if(i%2==0) {
				temp = temp.multiply(permuCount(new int[] {width-diagLoc[i+1][0],height-diagLoc[i+1][1]}));
			} else {
				temp = temp.multiply(permuCount(new int[] {width-diagLoc[i-1][0],height-diagLoc[i-1][1]}));
			}
			answer = answer.add(temp);
		}
		
		answer = answer.remainder(BigInteger.valueOf(10000019));
		System.out.println(answer.intValueExact());
	}
	public static BigInteger permuCount(int[] location) {
		int y = location[1];
		int x = location[0];
		return factorial(y+x).divide(factorial(x).multiply(factorial(y)));
	}
	public static BigInteger factorial(int n) {
		BigInteger bign = BigInteger.valueOf((long)n);
		if(n==0) {
			return BigInteger.valueOf((long)1);
		}
		return bign.multiply(factorial(n-1));
	}
}
