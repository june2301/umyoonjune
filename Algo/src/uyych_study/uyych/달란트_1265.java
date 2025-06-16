package uyych_study.uyych;

import java.util.Scanner;

public class 달란트_1265 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int P = sc.nextInt();
			
			int ave = N / P;
			long ans = 1;
			int rest = N % P;
			if (rest == 0) {
				for (int i = 0; i < P; i++) {
					ans *= ave;
				}
			}else {
				for (int i = 0; i < P-rest; i++) {
					ans *= ave;
				}
				for (int i = 0; i < rest; i++) {
					ans *= (ave+1);
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
		
	}

}
