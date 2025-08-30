package algo_self.boj.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 소수의연속합_1644 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[N+1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for (int i = 2; i*i <= N; i++) {
			if (prime[i]) {
				for (int j = i*i; j <= N; j += i) {
					prime[j] = false;
				}
			}
		}
		List<Integer> pn = new ArrayList<Integer>();
		for (int i = 2; i <= N; i++) {
			if (prime[i]) {
				pn.add(i);
			}
		}
		
		int l = 0;
		int r = 0;
		int cnt = 0;
		int sum = 0;
		while (true) {
			if (sum > N) {
				sum -= pn.get(l++);
			} else if (r == pn.size()) {
				break;
			} else {
				sum += pn.get(r++);
			}
			
			if (sum == N) {
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
		
	}

}

/**
 * 투 포인터 + 에라토스테네스의 체
 * 
 * [에라토스테네스의 체]
 * 2~N까지의 소수를 찾는 알고리즘
 * 1. boolean배열에 모든 수를 소수(true)라고 가정하고 시작
 * 2. i는 2부터 i의 배수들을 false처리 -> N까지 반복
 * 
 * 에라토스테네스의 체로 얻은 소수 리스트를 통해 투 포인터 진행
 * l, r을 통해 연결된 소수의 합 경우의 수 탐색
 * r이 범위 끝에 도달하면 종료
 * 
 */

