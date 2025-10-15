package algo_self.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 동전_9084 {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int T = 1; T <= TC; T++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	int[] types = new int[N];
        	String[] input = br.readLine().split(" ");
        	for (int i = 0; i < N; i++) {
        		types[i] = Integer.parseInt(input[i]);
        	}
        	int M = Integer.parseInt(br.readLine());
        	Arrays.sort(types);
        	
        	int[] dp = new int[M+1];
        	for (int i = 0; i < N; i++) {
        		for (int j = types[i]; j <= M; j++) {
        			if (j - types[i] < 0) continue;
        			if (j == types[i]) {
        				dp[j] += 1;
        			} 
        			dp[j] += dp[j-types[i]];
        		}
        	}
        	
        	sb.append(dp[M] + "\n");
		}
		System.out.println(sb);
	}

}

/**
 * DP
 * [문제]
 * 실행한 테스트케이스 수 T가 주어지고,
 * 동전 개수 N과 N개만큼 동전 금액이 주어지고 최종금액 M이 주어진다.
 * 같은 동전이 여러 번 주어지지 않으며, 동전들을 활용해 금액 M을 만드는 모든 경우의 수를 구하시오.
 * 
 * [잘못된 풀이]
 * DP 배열을 M+1 크기로 생성 후 반복문 2개로 M금액에 해당하는 경우의 수 찾기
 * 금액 반복문(i <= M) 안에 동전타입 반복문(j < N) 생성 후
 * dp[i] += dp[i-types[j]] 식으로 이전 금액을 만든 경우를 가져오는 방식으로 진행
 * -> 순열 방식으로 중복이 포함됨 
 * (ex: 1, 2로 3 만들기 = 1(1)에 2더하는 경우 1가지 + 2(1+1, 2)에 1을 더하는 경우 2 = 3가지?
 *      => 1+2 / 1+1+1 / 2+1 로 중복 발생)
 * 
 * [정답 풀이]
 * 동전 반복문(i < N) 안에 금액 반복문(j <= M) 생성
 * 해당 동전 하나를 이용해서 금액을 만드는 경우를 카운트
 * -> 하나의 동전만 따져서 dp[j-types[i]]에 값이 있었으면 해당 경우만큼 만들 수 있으니
 * dp[j] += dp[j-types[i]] 점화식 성립
 * 
 */


