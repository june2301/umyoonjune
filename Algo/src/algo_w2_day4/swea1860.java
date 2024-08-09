package algo_w2_day4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea1860 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt(); // 사람수
			int M = sc.nextInt(); // 붕어빵 시간
			int K = sc.nextInt(); // 붕어빵 개수
			
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				q.add(sc.nextInt());
			}
			
			int time = 0;
			int b = 0;
			boolean ans = true;
			int make = 0;
			for (int i = 1; i <= N; i++) {
				make += M;
				time += q.poll();
				if ((make-time) > 0) {
					b += K;
				}
				if (time < M) {
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
