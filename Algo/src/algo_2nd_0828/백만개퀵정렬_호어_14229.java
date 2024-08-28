package algo_2nd_0828;

import java.util.Scanner;

public class 백만개퀵정렬_호어_14229 {

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
		quickSort(0, N-1);
		System.out.println(arr[500000]);
	}
	
	static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}

	private static int partition(int left, int right) {
		int pivot = arr[left]; // 왼쪽 첫 칸을 피봇으로 설정
		
		int L = left+1;
		int R = right;
		
		while (L <= R) {
			while (L <= R && arr[L] <= pivot) {
				L++;
			}
			while (arr[R] > pivot) {
				R--;
			}
			if (L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		
		return R;
	}
	
	

}
