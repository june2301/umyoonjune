package algo_self.boj.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 합이0_3151 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(nums);
		
		long ans = 0;
		for (int i = 0; i < N-2; i++) {
			int curr = nums[i];
			int l = i+1;
			int r = N-1;
			while (l < r) {
				int sum = curr + nums[l] + nums[r];
				if (sum == 0) {
					if (nums[l] == nums[r]) {
						int n = r - l + 1;
						ans += (long)n*(n-1)/2;
						break;
					} else {
						int Rcnt = 1;
						for (int j = r-1; j > l; j--) {
							if (nums[r] == nums[j]) {
								Rcnt++;
							} else {
								break;
							}
						}
						
						int Lcnt = 1;
						for (int j = l+1; j < r; j++) {
							if (nums[l] == nums[j]) {
								Lcnt++;
							} else {
								break;
							}
						}
						ans += (long)Lcnt * Rcnt;
						l += Lcnt;
						r -= Rcnt;
					}
				} else if (sum < 0) {
					l++;
				} else {
					r--;
				}
				
				if (l == r) break;
			}
		}
		
		System.out.println(ans);
	}

}

/**
 * 투포인터
 * [문제]
 * N과 N개 만큼의 정수(중복가능, 음수/0/양수)가 주어진다.
 * 이 때 3개의 수를 합했을 때 0이 나오는 모든 경우의 수를 구하시오.
 * 
 * 일반적인 투포인터를 구현한 후,
 * 중복이 가능하기 때문에 중복된 숫자들에 대한 처리 추가
 * 
 * 중복 예시
 * 5
 * -10 5 5 5 5
 * 
 * 6
 * -5 2 2 3 3 3
 * 
 * nums[l]과 nums[r]을 비교해 두 값이 같은 경우와 다른 경우로 분류
 * 다른 경우 -> 왼쪽의 개수와 오른쪽의 개수를 구한 후 곱한 뒤 ans에 더하기
 *           이후, 왼쪽은 Lcnt만큼 오른쪽은 Rcnt만큼 당긴 후 계속 진행
 * 같은 경우 -> 총 개수는 r-l+1 이므로 nC2 를 구해 ans에 더하기
 */

