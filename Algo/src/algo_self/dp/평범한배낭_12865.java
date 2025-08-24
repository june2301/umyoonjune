package algo_self.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 평범한배낭_12865 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NK = br.readLine().split(" ");
		
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		
		int[][] item = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			String[] input = br.readLine().split(" ");
			item[i][0] = Integer.parseInt(input[0]);
			item[i][1] = Integer.parseInt(input[1]);
		}
		
		int[] dp = new int[K+1];
		for (int i = 1; i <= N; i++) {
			for (int j = K; j >= item[i][0]; j--) {
				dp[j] = Math.max(dp[j], dp[j-item[i][0]] + item[i][1]);
			}
		}
		
		System.out.println(dp[K]);
		
	}

}

/**
 * DP
 * [문제]
 * 물건수N과 들 수 있는 무게K가 주어지고,
 * N개의 물건의 무게와 가치가 주어진다.
 * 이 때 최대 무게에서 가질 수 있는 최대 가치를 출력.
 * 
 * 0/1 배낭 문제
 * -> 물건을 한번만 사용할 수 있음
 * 1~N개(++)의 물건에 대해
 * K~물건무게(--)까지 각 dp칸을 조회하며 최대 가치를 갱신
 */

