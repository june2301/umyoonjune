package algo_w2_day4;

import java.util.Arrays;
import java.util.Scanner;

public class swea1860 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt(); // 사람수
			int M = sc.nextInt(); // 붕어빵 시간
			int K = sc.nextInt(); // 붕어빵 개수
			
			int[] man = new int[N];
			for (int i = 0; i < N; i++) {
				man[i] = sc.nextInt();
			}
			Arrays.sort(man);
			
			boolean ans = true;
			for (int i = 0; i < N; i++) {
				int time = man[i];
				// time / M : 지금까지 붕어빵 만드는 사이클이 몇 번 돌았는가
				// (time / M) * K : 지금까지 만들어진 붕어빵 개수
				if ((time / M) * K < i + 1) {
					ans = false;
					break;
				}
			}
			
			if (ans) {
				System.out.println("#" + tc + " Possible");
			}else {
				System.out.println("#" + tc + " Impossible");
			}
		}
		
	}

}
