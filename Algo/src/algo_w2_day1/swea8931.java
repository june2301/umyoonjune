package algo_w2_day1;

import java.util.Scanner;
import java.util.Stack;

public class swea8931 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int K = sc.nextInt();
			Stack<Integer> bills = new Stack<>();
			for (int i = 0; i < K; i++) {
				int num = sc.nextInt();
				bills.add(num);
				if (num == 0) {
					bills.pop();
					bills.pop();
				}
			}
			int sum = 0;
			for (int i = 0; i < bills.size(); i++) {
				sum += bills.get(i);
			}
			System.out.println("#" + tc + " " + sum);
			
		}
		
	}

}
