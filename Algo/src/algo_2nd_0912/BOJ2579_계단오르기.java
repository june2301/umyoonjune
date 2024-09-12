package algo_2nd_0912;

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
		if (N <= 1) {
			System.out.println(dp[1]);
		}else {
			dp[2] = dp[1] + stair[2];
			for (int i = 3; i <= N; i++) {
				dp[i] = Math.max(dp[i-2] + stair[i], dp[i-3] + stair[i-1] + stair[i]);
			}
			
			System.out.println(dp[N]);
		}
		
	}

}
