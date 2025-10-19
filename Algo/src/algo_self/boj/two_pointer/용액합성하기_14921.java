package algo_self.boj.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 용액합성하기_14921 {

	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(input[i]);
		}
		
		int l = 0;
		int r = N-1;
		int ans = Integer.MAX_VALUE;
		while(l < r) {
			int sum = Math.abs(nums[l] + nums[r]);
			if (sum == 0) {
				ans = 0;
				break;
			}
			
			ans = Math.abs(nums[l] + nums[r]) < Math.abs(ans) 
					? nums[l] + nums[r] : ans;
			int L = Math.abs(nums[l]);
			int R = Math.abs(nums[r]);
			if (L > R) l++;
			else r--;
			
		}
		System.out.println(ans);
	}

}

/**
 * 투포인터
 * [문제]
 * N개의 용액에 대해 -1억 ~ 1억 사이의 용액의 특성값이 정렬된 상태로 주어진다.
 * 이 때 두 개의 용액을 선택해서 더했을 때 0에 가장 가까운 값을 구하시오.
 * 
 * [아이디어]
 * 투포인터에 절댓값 계산을 추가한 방식
 * 단순히 l과 r을 이동시키며 합을 비교했을 때
 * 작으면 l++, 크면 r--가 아닌 절댓값을 비교해서 l과 r을 이동시켜야 함.
 * 
 * l과 r에 해당하는 값의 합의 절댓값 sum 선언 및 초기화
 * 만약 0이면 바로 종료
 * 
 * 여기서 절댓값을 비교해 ans 기록보다 작은 경우 갱신
 * 
 * 이후 l과 r에 해당하는 값의 절대값을 비교해서 l과 r 위치 이동
 * 
 * [더 좋은 방법]
 * 절댓값이 아닌 num[l] + num[r]이 0보다 작으면 l++ / 0보다 크면 r--
 */

