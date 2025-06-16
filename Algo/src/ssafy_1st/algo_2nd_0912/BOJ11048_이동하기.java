package ssafy_1st.algo_2nd_0912;

import java.util.Scanner;

public class BOJ11048_이동하기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt()+1;
		int M = sc.nextInt()+1;
		int[][] map = new int[N][M];
		for (int r = 1; r < N; r++) {
			for (int c = 1; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		int[][] dp = new int[N][M];
		for (int r = 1; r < N; r++) {
			for (int c = 1; c < M; c++) {
				dp[r][c] = map[r][c] + Math.max(Math.max(dp[r-1][c], dp[r][c-1]), dp[r-1][c-1]);
			}
		}
		
		System.out.println(dp[N-1][M-1]);
		
	}

}
