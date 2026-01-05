package algo_self.boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 세수의합_2295 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(nums);
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N-1; i++) {
			for (int j = i; j < N; j++) {
				list.add(nums[i] + nums[j]);
			}
		}
		Collections.sort(list);
		
		for (int i = N-1; i > 0; i--) {
			int A = nums[i];
			for (int j = 0; j < i; j++) {
				int B = nums[j];
				
				int target = A-B;
				int l = 0;
				int r = list.size();
				while (l < r) {
					int mid = (l+r)/2;
					int sum = list.get(mid);
					if (sum == target) {
						System.out.println(A);
						return;
					} else if (sum < target) {
						l = mid+1;
					} else {
						r = mid;
					}
				}
			}
		}
		
	}

}

/**
 * 이분탐색
 * [문제]
 * 5이상 1000이하의 N개의 중복없는 자연수로 이루어진 집합이 있다.
 * 이 때 집합에서 중복을 허용하여 3개의 수를 더한 값이 집합에 포함되어 있는 경우 중 가장 큰 값을 구하시오.
 * A+B+C = D
 * 
 * N이 1000까지이기 때문에 3개의 수를 단순히 찾게 되면 1000^3으로 시간 초과 위험
 * 
 * -> 2개의 수를 더한 값(A+B)들을 저장해둔 후
 *    D-C에 해당하는 값을 찾는 방식으로 진행
 * 
 * 집합에서 가장 큰 수는 다른 수와 더해봤자 그 이상을 못찾기 때문에 제외하여
 * list에 2개의 숫자로 만들 수 있는 합들을 저장
 * 
 * 이후 반복문 2개로 큰수부터 만들 수 있는 경우를 이분탐색 진행 - 숫자가 가능하면 바로 출력
 * D-C를 target으로 하여 sums에 포함된 숫자 중 가능한 경우를 이분탐색
 * 이 때 nums[0]은 어차피 불가능하기 때문에 탐색 범위에 포함X
 */

