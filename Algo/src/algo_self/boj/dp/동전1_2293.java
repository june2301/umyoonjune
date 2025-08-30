package algo_self.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동전1_2293 {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
		
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
        int[] dp = new int[k+1];
        dp[0] = 1;
        for (int j = 0; j < n; j++) {
        	for (int i = 1; i <= k; i++) {
				if (i - arr[j] >= 0) {
					dp[i] += dp[i-arr[j]];
				}
			}
        	
		}
        
//      // 더 좋은 방식의 이중반복문 코드
//		for (int coin : arr) {
//			for (int i = coin; i <= k; i++) {
//				dp[i] += dp[i - coin];
//			}
//		}
		
		System.out.println(dp[k]);
	}

}

/**
 * DP
 * 
 * 반복문 2개를 활용하여 각 동전을 통해 만들 수 있는 금액의 경우의 수를 더해가면서 계산
 * -> 주어진 각 동전을 for문을 통해 사용
 * -> 각 동전을 통해 해당 금액를 만들 수 있는 경우 더하기(금액N = (N-동전) + 1)
 * 
 * >> 금액보다 동전을 먼저 반복문으로 조회하는 이유
 * = "중복 가능한 조합"으로 계산하기 위함.
 * 금액 for문 안에 동전 for문을 만들게 되면
 * 순열로 계산되어 중복을 각각 다르게 처리하게 됨
 * (1+1+2)를 (112 / 121 / 211) 모두 계산 -> 동전은 중복허용
 * 
 */

