package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기5_11660 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
		
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
		
        int[][] map = new int[N+1][N+1];
        
        for (int r = 1; r <= N; r++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
        
        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < M; m++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int[] range = new int[4];
        	for (int i = 0; i < 4; i++) {
				range[i] = Integer.parseInt(st.nextToken());
			}
        	
        	int sum = 0;
        	for (int r = range[0]; r <= range[2]; r++) {
				for (int c = range[1]; c <= range[3]; c++) {
					sum += map[r][c];
				}
			}
        	
        	sb.append(sum + "\n");
		}
        
        System.out.println(sb);
		
	}

}
