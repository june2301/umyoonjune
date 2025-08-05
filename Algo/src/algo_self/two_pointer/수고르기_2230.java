package algo_self.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수고르기_2230 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int l = 0;
		int r = 0;
		long ans = Integer.MAX_VALUE;
		while (r < N) {
			if (l == r) {
				r++;
				continue;
			}
			
			long sum = arr[r] - arr[l];
			
			if (sum >= M) {
				ans = Math.min(ans, sum);
				l++;
			} else {
				r++;
			}
			
		}
		
		System.out.println(ans);
		
	}

}

/**
 * [문제]
 * 절대값이 10억 이하인 정수로 구성된 수열이 주어지고
 * 수열의 두 수의 차이가 M이하인 경우에 대해서 가장 작은 차이값을 구하는 문제
 * 
 * 투 포인터
 * 
 * 입력받은 수열을 정렬한 후
 * l과 r을 상황에 따라 한 칸씩 이동시키며 값을 비교
 * 
 * M이하의 차이값 중 최소값을 구해야 하기 때문에 Math.min 사용
 * 
 * continue조건
 * -> l과 r이 0으로 시작하기 때문에 처음 1회는 arr의 같은 값을 비교
 * 이 때 M이 0이면 l이 역전되기 때문에 l==r 비교해서 r++ 필요
 * -> 수열에 같은 수가 주어질 경우 sum이 0이 될 수 있음
 * 이 때도 l이 ++되어 역전될 수 있기 때문에 continue조건문 사용
 * 
 */

