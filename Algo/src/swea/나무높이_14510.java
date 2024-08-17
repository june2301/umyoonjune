package swea;

import java.util.Arrays;
import java.util.Scanner;

public class 나무높이_14510 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] tree = new int[N];
		for (int i = 0; i < N; i++) {
			tree[i] = sc.nextInt();
		}
		
		Arrays.sort(tree);
		
		// 제일 큰 수 에서 뺀 모든 수들의 차를 더한 후
		// 1,2 번갈아가면서 cnt
		// 2인 경우만 체크
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += tree[N-1] - tree[i];
		}
		int water = 1;
		int cnt = 0;
		while (sum != 0) {
			if (sum == 2) {
				cnt += 2;
				break;
			}
			sum -= water;
			cnt++;
			water = 2;
		}
		
		System.out.println(cnt);
		
		
		
		
		
		
	}

}
