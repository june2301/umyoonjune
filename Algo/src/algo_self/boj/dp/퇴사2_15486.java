package algo_self.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 퇴사2_15486 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] time = new int[N];
		int[] cost = new int[N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			time[i] = Integer.parseInt(input[0]);
			cost[i] = Integer.parseInt(input[1]);
		}
		
		long[] dp = new long[N+1];
		long max = 0;
		for (int i = 0; i <= N; i++) {
			if (dp[i] > max) max = dp[i];
			
			if (i == N) break;
			
			int end = i + time[i];
			if (end <= N) {
				long sum = max + cost[i];
				if (dp[end] < sum) dp[end] = sum;
			}
		}
		
		System.out.println(max);
		
	}

}

/**
 * dp
 * [문제]
 * 퇴사까지 남은 날짜 N이 주어지고,
 * N일 만큼의 상담 약속에 대한 정보로 T 기간과 P 비용이 주어진다.
 * 퇴사 날짜까지 상담을 통해 최대 수익을 구하시오.
 * 
 * 각 날짜마다 잡히는 상담에 대한 날짜 정보와 비용 정보를 각각의 배열로 저장
 * 
 * 0일부터 시작하여 해당 날짜에 선택한 상담에 대해 진행
 * 최대 비용을 매일 갱신
 * 
 * 해당 상담이 끝나는 날이 N이하일 때
 * 최대 비용 + 해당 상담 비용이 dp에 저장된 값보다 크면 갱신
 */

