package ssafy_1st.algo_w2_0807_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 준홍이카드7102 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= T; tc++) {
			
			String NM = sc.nextLine();
			int N = Integer.parseInt(NM.split(" ")[0]);
			int M = Integer.parseInt(NM.split(" ")[1]);
			
			int[] max = new int[M+N+1];
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					max[i+j]++;
				}
			}
			
			int high = 0;
			
			Queue<Integer> maxes = new LinkedList<>();
			for (int i = 0; i < max.length; i++) {
				if (max[i] > high) {
					high = max[i];
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < max.length; i++) {
				if (max[i] == high) {
					maxes.add(i);
				}
				if (!maxes.isEmpty()) {
					System.out.print(maxes.poll() + " ");
				}
			}
			System.out.println();
		}
		
	}

}
