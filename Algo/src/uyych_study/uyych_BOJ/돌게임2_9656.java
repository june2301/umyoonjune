package uyych_study.uyych_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌게임2_9656 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			dp[i] = dp[i-1] == 1 ? 0 : 1;
		}
		
		if (dp[N] == 0) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
		
	}

}
