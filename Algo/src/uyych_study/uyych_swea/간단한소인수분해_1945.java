package uyych_study.uyych_swea;

import java.util.Scanner;

public class 간단한소인수분해_1945 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			
			int[] cnt = new int[5];
			
			
			while (N%2 == 0) {
				N = N / 2;
				cnt[0]++;
			}
			while (N%3 == 0) {
				N = N / 3;
				cnt[1]++;
			}
			while (N%5 == 0) {
				N = N / 5;
				cnt[2]++;
			}
			while (N%7 == 0) {
				N = N / 7;
				cnt[3]++;
			}
			while (N%11 == 0) {
				N = N / 11;
				cnt[4]++;
			}
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < cnt.length; i++) {
				System.out.print(cnt[i] + " ");
			}
			System.out.println();
		}
		
	}

}
