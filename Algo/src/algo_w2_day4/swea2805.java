package algo_w2_day4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea2805 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		
		int[][] land = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			char[] input = sc.nextLine().toCharArray();
			for (int c = 0; c < N; c++) {
				land[r][c] = (int)(input[c] - '0');
			}
		}
		
		Queue<Integer> que = new LinkedList<>();
		int sum = 0;
		for (int r = 0; r < N; r++) {
			for (int c = N/2-r; c < (r+1)*2-1; c++) {
				
				
			}
		}
		
		
	}

}
