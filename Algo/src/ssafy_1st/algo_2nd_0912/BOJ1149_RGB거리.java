package ssafy_1st.algo_2nd_0912;

import java.util.Scanner;

public class BOJ1149_RGB거리 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] map = new int[N][3];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < 3; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		int[][] dp = new int[N][3];
		
		for (int c = 0; c < 3; c++) {
			dp[0][c] = map[0][c];
		}
		
		for (int r = 1; r < N; r++) {
			dp[r][0] = Math.min(dp[r-1][1] + map[r][0], dp[r-1][2] + map[r][0]);
			dp[r][1] = Math.min(dp[r-1][0] + map[r][1], dp[r-1][2] + map[r][1]);
			dp[r][2] = Math.min(dp[r-1][1] + map[r][2], dp[r-1][0] + map[r][2]);
		}
		
		int ans = Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
		System.out.println(ans);
	}

}
