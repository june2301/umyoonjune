package algo_2nd_0828;

import java.util.Scanner;

public class 백만개병합정렬_14229 {

	static int[] arr, tmp;
	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		arr = new int[1000000];
		tmp = new int[1000000];
		N = arr.length;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		mergeSort(0, N-1);
		System.out.println(arr[500000]);
	}
	
	// 병합정렬
	static void mergeSort(int left, int right) {
		if (left < right) { // 무한히 쪼개기
			int mid = (left+right) / 2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}

	private static void merge(int left, int mid, int right) {
		
		int L = left;
		int R = mid+1;
		
		int idx = left; // tmp 인덱스
		
		// 왼쪽 구간 vs 오른쪽 구간 비교하며 작은 값 tmp에 넣기
		while(L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				tmp[idx++] = arr[L++];
			}else {
				tmp[idx++] = arr[R++];
			}
		}
		
		// 남은 구간 처리
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		}else {
			for (int i = R; i <= right; i++) {
				tmp[idx++] = arr[i];
			}
		}
		
		for (int i = left; i <= right; i++) {
			arr[i] = tmp[i];
		}
		
	}

}
