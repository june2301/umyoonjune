package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class 모든스택수열_23284 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] nums = new int[N][N];
		
		for (int i = 1; i <= N ; i++) {
			for (int j = 1; j <= N ; j++) {
				nums[i][j] = j;
			}
		}
		
		Stack<Integer> st = new Stack<>();
		
		for (int i = N; i >= 1; i--) {
			st.add(i);
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(st.pop() + " ");
		}
		
		
	}

}
