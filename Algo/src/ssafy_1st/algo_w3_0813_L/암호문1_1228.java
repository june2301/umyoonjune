package ssafy_1st.algo_w3_0813_L;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 암호문1_1228 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			List<Integer> pw = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				pw.add(sc.nextInt());
			}
			int M = sc.nextInt();
			for (int i = 0; i < M; i++) {
				sc.next();
				int where = sc.nextInt();
				int cnt = sc.nextInt();
				for (int j = 0; j < cnt; j++) {
					int newNum = sc.nextInt();
					pw.add(where++, newNum);
				}
			}
			
			System.out.print("#" + tc);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + pw.get(i));
			}
			System.out.println();
		}
		
	}

}
