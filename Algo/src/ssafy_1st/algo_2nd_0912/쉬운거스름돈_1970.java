package ssafy_1st.algo_2nd_0912;

import java.util.Scanner;

public class 쉬운거스름돈_1970 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int money = sc.nextInt();
			
			int[] change = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			int[] dp = new int[8];
			
			for (int i = 0; i < 8; i++) {
				if (change[i] > money) {
					dp[i] = 0;
					continue;
				}
				int cnt = money / change[i];
				for (int j = 0; j < cnt; j++) {
					money -= change[i];
					dp[i]++;
				}
			}
			
			System.out.println("#" + tc + " ");
			for (int i = 0; i < dp.length; i++) {
				System.out.print(dp[i] + " ");
			}
			System.out.println();
		}
		
	}

}
