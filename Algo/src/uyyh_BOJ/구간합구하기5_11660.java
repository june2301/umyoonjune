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
        int[][] dp = new int[N+1][N+1];
        
        for (int r = 1; r <= N; r++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				dp[r][c] = dp[r][c-1] + map[r][c];
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
        	for (int i = 0; i <= range[2]-range[0]; i++) {
        		sum += dp[range[0] + i][range[3]] - dp[range[0] + i][range[1] - 1];
			}
        	
        	sb.append(sum + "\n");
		}
        
        System.out.println(sb);
		
	}

}
