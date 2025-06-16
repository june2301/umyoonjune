package ssafy_1st.algo_2nd_0828;

import java.util.Scanner;

public class 백만개퀵정렬_로무토_14229 {

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
	
	// 퀵 정렬 로무토
	static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}

	private static int partition(int left, int right) {
		int pivot = arr[right];
		int i = left-1;
		
		// pivot보다 작은 값이 나올때까지 확인 후
		// 작은 값이 나오면 이전에 처음 나온 큰 값과 위치 바꿔줌
		for (int j = left; j < right; j++) {
			if (arr[j] <= pivot) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		
		// right끝까지 다 돌았다면
		// i+1의 값과 끝값 바꿔주기 
		// (여기서 i는 위의 for문에서 마지막으로 나온 작은 값의 다음 값 = arr[right]보다 큰 값)
		int tmp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] = tmp;
		
		// i+1 위치 반환
		return i+1;
	}
	
	

}
