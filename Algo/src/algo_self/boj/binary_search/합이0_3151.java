package algo_self.boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 합이0_3151 {
	
	static int[] nums;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(nums);
		
		long ans = 0;
		for (int i = 0; i < N-2; i++) {
			int A = nums[i];
			for (int j = i+1; j < N-1; j++) {
				int B = nums[j];
				int target = -(A+B);
				
				int st = j+1;
				int en = N;
				
				if (target < nums[st] || target > nums[N-1]) continue;
				
				int left = lowerBound(st, en, target);
				int right = upperBound(st, en, target);
				
				ans += right - left;
			}
		}
		
		System.out.println(ans);
	}
	
	static int lowerBound(int st, int en, int tar) {
		int l = st;
		int r = en;
		while (l < r) {
			int mid = (l + r) / 2;
			if (nums[mid] >= tar) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}
	
	static int upperBound(int st, int en, int tar) {
		int l = st;
		int r = en;
		while (l < r) {
			int mid = (l + r) / 2;
			if (nums[mid] > tar) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

}

/**
 * 이분탐색
 * [문제]
 * N과 N개 만큼의 정수(중복가능, 음수/0/양수)가 주어진다.
 * 이 때 3개의 수를 합했을 때 0이 나오는 모든 경우의 수를 구하시오.
 * 
 * 두 개의 숫자를 2번의 반복문으로 i와 j로 지정을 한 후
 * 이분탐색을 통해 하나의 숫자를 찾는 구조
 * 
 * 이 때 중복된 숫자들에 대해 처리하기 위해 
 * lowerBound -> target숫자가 시작하는 인덱스
 * upperBound -> 연속된 숫자가 끊기는 인덱스
 * 를 구한 후 두 값의 차를 ans에 더하는 방식으로 진행
 */

