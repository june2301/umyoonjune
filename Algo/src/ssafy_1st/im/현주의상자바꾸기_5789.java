package ssafy_1st.im;

import java.util.Scanner;

public class 현주의상자바꾸기_5789 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int Q = sc.nextInt();
			int[] box = new int[N + 1];
			for (int i = 1; i <= Q; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				for (int j = A; j <= B; j++) {
					box[j] = i;
				}
			}
			
			System.out.print("#" + tc + " ");
			for (int i = 1; i <= N; i++) {
				System.out.print(box[i] + " ");
			}
			System.out.println();
		}
	}
}
