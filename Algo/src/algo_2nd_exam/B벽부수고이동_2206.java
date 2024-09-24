package algo_2nd_exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B벽부수고이동_2206 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		int[][] map = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			char[] input = br.readLine().toCharArray();
			for (int c = 0; c < M; c++) {
				map[r][c] = input[c] - '0';
			}
		}
		
		
		
		
		
	}
	
	static void bfs() {
		
		
		
	}
	
	

}
