package ssafy_1st.algo_2nd_0912;

import java.util.Scanner;

public class BOJ2579_계단오르기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] stair = new int[N+1];
		for (int i = 1; i <= N; i++) {
			stair[i] = sc.nextInt();
		}
		
		int[] dp = new int[N+1];
		
		dp[0] = 0;
		dp[1] = stair[1];
		if (N >= 2) {
			dp[2] = dp[1] + stair[2];
			for (int i = 3; i <= N; i++) {
				// i-1을 밟고 오는 경우 = dp[i-3] + 계단[i-1] + 계단[i]
				// i-2를 밟고 오는 경우 = dp[i-2] + 계단[i]
				// dp 는 항상 그 자리에서 최적값을 저장해간다고 생각.
				dp[i] = Math.max(dp[i-2] + stair[i], dp[i-3] + stair[i-1] + stair[i]);
			}
		}
		System.out.println(dp[N]);
		
	}

}
