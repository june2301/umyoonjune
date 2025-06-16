package ssafy_1st.practice2;

import java.util.Arrays;

public class 병합정렬 {

	static int[] arr = {7, 5, 13, 2, 79, 12, 35, 42};
	static int N = arr.length;
	static int[] tmp = new int[N];
	
	public static void main(String[] args) {
		
		mergeSort(0, N-1);
		System.out.println(Arrays.toString(arr));
		
		
	}

	static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right)/2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}
	
	static void merge(int left, int mid, int right) {
		
		// 왼, 오 구역의 시작지점
		int L = left; 
		int R = mid +1;
		
		int idx = left;
		
		// tmp에 작은애들부터 담기
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				tmp[idx++] = arr[L++];
			}else {
				tmp[idx++] = arr[R++];
			}
		}
		
		// 무조건 남아있을 수 밖에 없음
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		}else {
			for (int i = R; i <= right; i++) {
				tmp[idx++] = arr[i];
			}
		}
		
		// 옮기기 *범위체크
		for (int i = left; i <= right; i++) {
			arr[i] = tmp[i];
		}
		
		
	}
	
}
