package algo_self.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 가장긴증가하는부분수열4_14002 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		
		int[] arr = new int [N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		List<Integer>[] dp = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			dp[i] = new ArrayList<Integer>();
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			dp[i].add(arr[i]);
			
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && dp[i].size() < dp[j].size() + 1) {
					dp[i] = new ArrayList<>(dp[j]);
					dp[i].add(arr[i]);
				}
			}
			
			if (dp[i].size() > dp[ans].size()) {
				ans = i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(dp[ans].size() + "\n");
		for (int num : dp[ans]) {
			sb.append(num + " ");
		}
		
		System.out.println(sb);
		
	}

}

/**
 * 동적 프로그래밍(Dynamic Programming)
 * 
 * 입력받는 배열 말고 dp용 배열 추가 생성
 * -> 이 문제에서는 가장 긴 수열의 크기 뿐만 아니라 숫자들도 출력해야함 => List사용
 * 
 * i번째와 그 이전 숫자들 비교 + 수열 크기 비교
 * 만약 i가 이전 숫자보다 크고 + 수열 크기가 작다면
 * -> 이전 수열에 i번째 숫자 추가
 */

