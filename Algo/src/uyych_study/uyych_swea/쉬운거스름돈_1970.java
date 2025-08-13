package uyych_study.uyych_swea;

import java.util.Scanner;

public class 쉬운거스름돈_1970 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int money = sc.nextInt();
			
			int[] cnt = new int[8];
			
			while (true) {
				
				if (money / 50000 > 0) {
					cnt[0] += money / 50000;
					money -= cnt[0] * 50000;
				} else if (money / 10000 > 0) {
					cnt[1] += money / 10000;
					money -= cnt[1] * 10000;
				} else if (money / 5000 > 0) {
					cnt[2] += money / 5000;
					money -= cnt[2] * 5000;
				} else if (money / 1000 > 0) {
					cnt[3] += money / 1000;
					money -= cnt[3] * 1000;
				} else if (money / 500 > 0) {
					cnt[4] += money / 500;
					money -= cnt[4] * 500;
				} else if (money / 100 > 0) {
					cnt[5] += money / 100;
					money -= cnt[5] * 100;
				} else if (money / 50 > 0) {
					cnt[6] += money / 50;
					money -= cnt[6] * 50;
				} else if (money / 10 > 0) {
					cnt[7] += money / 10;
					money -= cnt[7] * 10;
				} else {
					break;
				}
				
			}
			
			System.out.println("#" + tc);
			for (int i = 0; i < cnt.length; i++) {
				System.out.print(cnt[i] + " ");
			}
			System.out.println();
			
		}
		
	}

}
