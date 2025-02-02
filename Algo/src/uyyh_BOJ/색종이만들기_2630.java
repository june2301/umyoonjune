package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 색종이만들기_2630 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] paper = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			String[] input = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				paper[r][c] = Integer.parseInt(input[c]);
			}
		}
		
		divide(paper, N);
		
		
	}
	
	static void divide(int[][] map, int n) {
		boolean check = false;
		for (int r = 0; r < n/2; r++) {
			for (int c = 0; c < n/2; c++) {
				
			}
		}
		
		
	}

}
