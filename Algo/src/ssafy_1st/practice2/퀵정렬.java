package ssafy_1st.practice2;

import java.util.Arrays;

public class 퀵정렬 {
	
	static int[] arr = {7, 5, 13, 2, 79, 12, 35, 42};
	static int N = arr.length;

	public static void main(String[] args) {
		
		quickSort(0, N-1);
		System.out.println(Arrays.toString(arr));
		
	}
	
	static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}
	
	static int partition(int left, int right) {
		int pivot = arr[left];
		int L = left + 1;
		int R = right;
		
		while (L <= R) { // pivot보다 큰 값과 작은 값들을 계속 바꿔줌
			while (L <= R && arr[L] <= pivot) // pivot보다 큰 값 찾을 때까지 이동
				L++;
			while (pivot < arr[R]) // pivot보다 작은 값 찾을 때까지 이동
				R--;
			
			if (L < R) { // 찾으면 서로 바꿔줌
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		
		// 작은값과 큰값의 경계로 pivot 이동
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		// R의 위치가 pivot이 가야 할 위치
		return R;
	}

}
