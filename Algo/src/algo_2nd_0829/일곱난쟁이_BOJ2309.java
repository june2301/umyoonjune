package algo_2nd_0829;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이_BOJ2309 {
	
	static int[] height;
	static int[] result;
	static int[] answer;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		height = new int[9];
		for (int i = 0; i < 9; i++) {
			height[i] = sc.nextInt();
		}
		
		result = new int[7];
		answer = new int[7];
		
		Arrays.sort(height);
		comb(0, 0);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	
	static void comb(int idx, int sidx) {
		
		if (sidx == 7) {
			int ans = 0;
			for (int i = 0; i < 7; i++) {
				ans += result[i];
			}
			if (ans == 100) {
				for (int i = 0; i < 7; i++) {
					answer[i] = result[i];
				}
			}
			return;
		}
		
		for (int i = idx; i <= 9-7+sidx; i++) {
			result[sidx] = height[i];
			comb(i+1, sidx+1);
		}
		
	}

}
