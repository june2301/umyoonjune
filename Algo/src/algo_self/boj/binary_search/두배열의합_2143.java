package algo_self.boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 두배열의합_2143 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		String[] inputA = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(inputA[i]);
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] B = new int[m];
		String[] inputB = br.readLine().split(" ");
		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(inputB[i]);
		}
		
		List<Integer> Asum = new ArrayList<Integer>();
		List<Integer> Bsum = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += A[j];
				Asum.add(sum);
			}
		}
		for (int i = 0; i < m; i++) {
			int sum = 0;
			for (int j = i; j < m; j++) {
				sum += B[j];
				Bsum.add(sum);
			}
		}
		
		Collections.sort(Asum);
		Collections.sort(Bsum);
		
		long ans = 0;
		for (Integer a : Asum) {
			
			int target = T - a;
			int lower = lowerBound(Bsum, target);
			int upper = upperBound(Bsum, target);
			ans += upper - lower;
		}
		
		System.out.println(ans);
		
	}
	
	static int lowerBound(List<Integer> list, int target) {
		int l = 0;
		int r = list.size();
		
		while (l < r) {
			int mid = (l + r) / 2;
			if (list.get(mid) < target) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		
		return l;
	}

	static int upperBound(List<Integer> list, int target) {
		int l = 0;
		int r = list.size();
		
		while (l < r) {
			int mid = (l + r) / 2;
			if (list.get(mid) <= target) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		
		return l;
	}
	
}

/**
 * 이분탐색
 * 
 * A, B배열에서 가능한 부 배열합들을 모두 구한 후
 * 구해둔 Asum, Bsum 리스트를 이용해 이분탐색 수행
 * 
 * (만약 Asum, Bsum을 비교하며 합했을 때, T가 나오는 경우를 계산하면 시간초과(시간복잡도 : O(n^2 * m^2))
 * 
 * 이분탐색 시간복잡도 : O(n^2 log m^2)
 * 
 * lowerBound와 upperBound로 나누어서 
 * target과 같은 값이 나오는 "시작 위치"와 "초과 위치"를 찾아내어 계산
 * 
 * >> 이분탐색에서 자주 사용하는 구간 표현 방식
 * 1. [left, right) : 왼쪽 포함, 오른쪽 미포함
 * -> right = mid || left = mid + 1 로 처리
 * 
 * 2. [left, right] : 양쪽 모두 포함
 * -> right = mid - 1 || left = mid + 1 로 처리
 */

