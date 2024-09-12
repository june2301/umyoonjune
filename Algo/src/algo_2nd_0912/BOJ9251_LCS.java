package algo_2nd_0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9251_LCS {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input1 = br.readLine();
		String input2 = br.readLine();
		
		int N = input1.length();
		int M = input2.length();
		
		char[] fir = new char[N + 1];
		char[] sec = new char[M + 1];
		
		for (int i = 1; i <= N; i++) {
			fir[i] = input1.charAt(i-1);
		}
		for (int i = 1; i <= M; i++) {
			sec[i] = input2.charAt(i-1);
		}
		
		int[][] dp = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (fir[i] == sec[j]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[N][M]);
		
	}

}
