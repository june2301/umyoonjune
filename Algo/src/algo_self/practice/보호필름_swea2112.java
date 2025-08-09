package algo_self.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 보호필름_swea2112 {
	
	static int D, W, K, answer;
	static int[][] film;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			String[] DWK = br.readLine().split(" ");
			
			D = Integer.parseInt(DWK[0]);
			W = Integer.parseInt(DWK[1]);
			K = Integer.parseInt(DWK[2]);
			
			film = new int[D][W];
			for (int r = 0; r < D; r++) {
				String[] input = br.readLine().split(" ");
				for (int c = 0; c < W; c++) {
					film[r][c] = Integer.parseInt(input[c]);
				}
			}
			
			if (test()) {
				sb.append("#" + tc + " " + 0 + "\n");
				continue;
			}
			
			answer = D;
			drug(0, 0);
			sb.append("#" + tc + " " + answer + "\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	static void drug(int idx, int cnt) {
		if (cnt >= answer) return;
		if (idx == D) {
			if (test()) {
				answer = Math.min(answer, cnt);
			}
			return;
		}
		
		drug(idx + 1, cnt);
		
		int[] save = film[idx].clone();
		
		Arrays.fill(film[idx], 0);
		drug(idx + 1, cnt + 1);
		
		Arrays.fill(film[idx], 1);
		drug(idx + 1, cnt + 1);
		
		film[idx] = save;
		
	}
	
	static boolean test() {
		for (int c = 0; c < W; c++) {
			boolean check = false;
			int cnt = 1;
			for (int r = 0; r < D - 1; r++) {
				if (film[r][c] == film[r + 1][c]) {
					cnt++;
				} else {
					cnt = 1;
				}
				if (cnt >= K) {
					check = true;
					break;
				}
			}
			if (!check) {
				return false;
			}
		}
		
		return true;
	}

}

/**
 * 백트래킹(dfs)
 * [문제]
 * 두께 D, 너비 W 인 필름과 합격기준 K가 주어지고,
 * 필름을 테스트하여 각 줄마다 K개의 숫자가 연속하면 통과, 모든 줄 통과 시 합격
 * 이 때, 약품 처리를 하여 하나의 줄을 0(A) 또는 1(B)로 바꿀 수 있음
 * 
 * [해설]
 * 우선 test()함수를 통해 현재 필름 상태에서 합격 가능한지 체크
 * (약품 처리할 때 AorB 필름이 추가되는 줄 알고 List<int[]>를 사용했지만, 한 층이 바뀌므로 필요없음)
 * 
 * 약품 처리를 위한 drug()함수 만들기
 * - idx를 증가시키며 모든 층에 대해서 *행동을 하고 idx가 D만큼 되면 test() 실행
 * *행동 
 * 1. 그대로 두기
 * 2. 해당 층 A(0)로 변경
 * 3. 해당 층 B(1)로 변경
 * 이후 변경된 층 원상복구하며 진행
 * 
 */

