package uyyh_BOJ_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_2579 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] st = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			st[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[N+1];
		dp[1] = st[1];
		if (N <= 1) {
			System.out.println(dp[N]);
			return;
		} else {
			dp[2] = st[1] + st[2];
			for (int i = 3; i <= N; i++) {
				dp[i] = Math.max(dp[i-2], dp[i-3] + st[i-1]) + st[i];
			}
		}
		System.out.println(dp[N]);
	}

}
