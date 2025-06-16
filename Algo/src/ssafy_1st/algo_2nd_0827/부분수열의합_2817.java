package ssafy_1st.algo_2nd_0827;

import java.util.Arrays;
import java.util.Scanner;

public class 부분수열의합_2817 {

	static int N, K;
	static int[] arr;
	static int[] save;
	static int cnt;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			cnt = 0;
			N = sc.nextInt();
			K = sc.nextInt();
			
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			for (int i = 1; i <= N; i++) {
				save = new int[i];
				comb(0, 0, i);
			}
			System.out.println("#" + tc + " " + cnt);
		}
		
	}
	
	public static void comb(int idx, int sidx, int R) {
		
		if (sidx == R) {
			int sum = 0;
			for (int i = 0; i < R; i++) {
				sum += save[i];
			}
			if (sum == K) {
//				System.out.println(Arrays.toString(save));
				cnt++;
			}
			return;
		}
		
		for (int i = idx; i <= N-R+sidx; i++) {
			save[sidx] = arr[i];
			comb(i+1, sidx+1, R);
		}
		
	}

}
