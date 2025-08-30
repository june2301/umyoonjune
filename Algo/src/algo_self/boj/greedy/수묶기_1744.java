package algo_self.boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수묶기_1744 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		int ans = 0;
		int zero = 0;
		int minus = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			ans += arr[i];
			if (arr[i] == 0) {
				zero++;
			}
			if (arr[i] < 0) {
				minus++;
			}
		}
		
		Arrays.sort(arr);
		
		if (N > 1) {
			for (int i = N-1; i > 0; i--) {
				if (arr[i] > 1 && arr[i-1] > 1) {
					ans -= arr[i] + arr[i-1];
					ans += arr[i] * arr[i-1];
					i -= 1;
				}
			}
			if (minus > 1) {
				for (int i = 0; i < N-1; i++) {
					if (arr[i] < 0 && arr[i+1] < 0) {
						ans -= arr[i] + arr[i+1];
						ans += arr[i] * arr[i+1];
						i += 1;
					}
				}
			}
		}
		
		if (zero > 0 && minus % 2 == 1) {
			for (int i = 0; i < N; i++) {
				if (arr[i] == 0) {
					ans += -arr[i-1];
				}
			}
		}
		
		System.out.println(ans);
		
	}

}

/**
 * 그리디 알고리즘
 * 모든 경우에 대해서 다 생각해봐야 함
 * 
 * 정렬을 우선 진행한 후,
 * 1. 가장 큰 수끼리 곱해가며 합이 최대가 되도록 실행
 * 2. 음수가 1개 초과일 경우, 곱해가며 합이 최대가 되도록 실행
 * 3. 0이 있고, 음수가 홀수개라면, 가장 작은 음수 제거하도록 실행
 * 
 * 예제에 없는 반례들을 잘 생각하면서 진행해볼 것
 * 음수가 여러 개 / 0이 홀수or짝수개 등등
 */
