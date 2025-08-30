package algo_self.boj.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분합_1806 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NS = br.readLine().split(" ");
		
		int N = Integer.parseInt(NS[0]);
		int S = Integer.parseInt(NS[1]);
		
		String[] input = br.readLine().split(" ");
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		int l = 0;
		int r = 0;
		
		int sum = 0;
		int ans = 100000000;
		while (true) {
			if (sum >= S) {
				ans = Math.min(ans, r - l);
				sum -= arr[l];
				l++;
			} else if (r == N) {
				break;
			} else {
				sum += arr[r];
				r++;
			}
		}
		
		System.out.println(ans == 100000000 ? 0 : ans);
		
	}

}

/**
 * 투 포인터
 * 
 * l과 r을 통해 한 칸씩 윈도우를 이동시키며 최소 길이 구하기
 * 
 * 조건문
 * 1. sum이 S보다 크거나 같으면 -> ans에 길이 기록 & arr[l]값 빼주고 & l 한 칸 이동
 * 2. 만약 r이 N과 같으면 종료
 * 3. sum이 S보다 작거나 r이 N과 다르면 -> arr[r] 더하고 & r 한 칸 이동
 * 
 * 만약 arr[N-1]이 S보다 크거나 같은 수라 길이가 1이 최소 정답인 경우,
 * r==N인 상태로, 조건1이 계속 걸리면서 l==r이 될 때까지 조건1만 실행(ans에는 1까지 기록 후 넘어감)
 * 이후 조건2에 걸리면서 while문 종료
 * 
 * 만약 ans값이 갱신되지 않아 100,000,000이라면 불가능하므로 0 출력
 */

