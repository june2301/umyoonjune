package algo_self.boj.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Z_1074 {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] NRC = br.readLine().split(" ");
        int N = Integer.parseInt(NRC[0]);
        int R = Integer.parseInt(NRC[1]);
        int C = Integer.parseInt(NRC[2]);
		
        int size = (int) Math.pow(2, N);
        
        int ans = dfs(size, R, C);
		
		System.out.println(ans);
	}
	
	static int dfs(int size, int r, int c) {
		if (size == 1) {
			return 0;
		}
		
		int half = size / 2;
		int area = half * half;
		
		if (r < half && c < half) { // 1사분면
			return dfs(half, r, c);
			
		} else if (r < half && c >= half) { // 2사분면
			return area + dfs(half, r, c-half);
			
		} else if (r >= half && c < half) { // 3사분면
			return 2*area + dfs(half, r-half, c);
			
		} else { // 4사분면
			return 3*area + dfs(half, r-half, c-half);
		}
	}

}

/**
 * 재귀
 * [문제]
 * 2^N x 2^N인 2차원 배열을 Z모양으로 탐색하며 번호가 0부터 부여된다.
 * 이 때 R, C에 해당하는 좌표는 몇 번째로 탐색하는지 구하시오.
 * 
 * 핵심 아이디어 : 4분면으로 계속 나누는 방식의 재귀 적용
 * 
 * 주어진 N에 따른 전체 배열의 사이즈를 구한 후 R과 C를 함께 파라미터로 포함
 * size를 절반으로 줄이고,
 * 절반의 제곱 = 하나의 사분면에 채워질 번호들의 수
 * 
 * 이후 r,c를 바탕으로 현재 기준 어느 사분면에 위치하는지 파악 후
 * 해당 사분면만큼 area를 곱해서 숫자를 계속 더해나감.
 * -> 계속 사분면을 나누고 사분면에 해당하는 숫자만큼 더해가면서 진행
 * 
 * 마지막에 size가 1이 될때까지 쪼개면 r,c좌표에 도착
 * 여태 더한 숫자들을 합하면 => r,c 좌표의 숫자
 */

