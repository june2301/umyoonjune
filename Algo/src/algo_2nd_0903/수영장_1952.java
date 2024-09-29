package algo_2nd_0903;

import java.util.Scanner;

public class 수영장_1952 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int costd = sc.nextInt();
			int costm1 = sc.nextInt();
			int costm3 = sc.nextInt();
			int costy = sc.nextInt();
			
			int[] swim = new int[13];
			int sum = 0;
			for (int i = 1; i <= 12; i++) {
				swim[i] = sc.nextInt();
				sum += swim[i];
			}
			
			int[] dp = new int[13];
			dp[0] = 0;
			for (int i = 1; i <= 12; i++) {
				// 1달 vs 1일 가격 계속 저장해감
				dp[i] = dp[i-1] + Math.min(swim[i] * costd, costm1);
				if (i >= 3 && swim[i] > 0) { // 3달 이상부터
					// 현재까지 저장된거 vs 3달전꺼에서 3달가격 더한거
					dp[i] = Math.min(dp[i], dp[i-3]+costm3);
				}
			}
			System.out.println("#" + tc + " " + Math.min(dp[12], costy));
		}
		
	}

}
