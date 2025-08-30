package algo_self.boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 좋다_1253 {
	
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(arr);

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int target = arr[i];
			boolean check = false;

			for (int j = 0; j < N; j++) {
				if (i == j) continue;

				int need = target - arr[j];

				int idx = binarySearch(need, 0, N - 1, i, j);

				if (idx != -1) {
					check = true;
					break;
				}
			}

			if (check) {
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
	}

	static int binarySearch(int target, int start, int end, int same1, int same2) {
		while (start <= end) {
			int mid = (start + end) / 2;

			if (mid == same1 || mid == same2) {
				if (mid < target) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
				continue;
			}

			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return -1;
	}
	
}

/**
 * 이분 탐색(Binary Search)
 * 정렬된 배열에서 반씩 나눠가며 원하는 값 탐색
 * 시간복잡도 : O(logN)
 * 
 * 1. start와 end를 기준으로 mid값을 target과 비교
 * 2. mid값이 target보다 작으면 start = mid+1 | 크면 end = mid-1
 * 3. start > end 될 때까지 반복
 * 
 */

