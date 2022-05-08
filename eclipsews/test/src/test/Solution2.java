package test;

import java.util.Arrays;

public class Solution2 {
	final static int SIZE = 6;
	static class Per implements Comparable<Per>{
		double price;
		int index;
		
		public Per(double price, int index) {
			this.price = price;
			this.index = index;
		}

		@Override
		public int compareTo(Per o) {
			if(this.price>o.price) {
				return 1;
			} else if(this.price==o.price) {
				return 0;
			} else {
				return -1;
			}
		}
	}
	public static void main(String[] args) {
		int money;
		int answer = 0;
		money = 1999;
		int[] costs = {2,11,20,100,200,600};
		//-----------------------
		
		int[] won = {1,5,10,50,100,500};
		Per[] pers = new Per[SIZE];
		for (int i = 0; i < SIZE; i++) {
			pers[i] = new Per((double)costs[i]/(double)won[i],i);
		}
		
		Arrays.sort(pers);
		for (Per per : pers) {
			int current = won[per.index];
			int counts = money/current;//동전 개수
			int cost = counts*costs[per.index];
			int value = counts*won[per.index];
			money -= value;
			answer += cost;
			if(money<0) {
				answer += money*per.price;
				break;
			}
		}
		System.out.println(answer);
	}

}
