package algo_self.boj.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 계란으로계란치기_16987 {
	
	static int N, ans;
	static int[][] eggs;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		eggs = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			eggs[i][0] = Integer.parseInt(input[0]);
			eggs[i][1] = Integer.parseInt(input[1]);
		}
		
		ans = 0;
		dfs(0);
		System.out.println(ans);
		
	}
	
	static void dfs(int idx) {
		if (idx == N) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (eggs[i][0] <= 0) cnt++;
			}
			ans = Math.max(ans, cnt);
			return;
		}
		
		if (eggs[idx][0] <= 0) {
			dfs(idx+1);
			return;
		}
		
		boolean check = false;
		for (int i = 0; i < N; i++) {
			if (i == idx) continue;
			if (eggs[i][0] <= 0) continue;
			check = true;
			eggs[i][0] -= eggs[idx][1];
			eggs[idx][0] -= eggs[i][1];
			dfs(idx+1);
			eggs[i][0] += eggs[idx][1];
			eggs[idx][0] += eggs[i][1];
		}
		if (!check) {
			dfs(idx+1);
			return;
		}
		
	}

}

/**
 * 백트래킹
 * [문제]
 * N개의 계란에 대해 [내구도, 무게] 가 주어지고, 계란으로 계란을 치면 서로 무게만큼 내구도가 깎인다.
 * 왼쪽부터 깨지지 않은 계란 하나를 들어 아직 깨지지 않은 다른 계란을 쳤을 때,
 * 가장 많이 깨게 되는 계란의 수를 구하시오.
 * (왼 -> 오 한 칸씩 이동 / 현재 계란이 깨져있으면 이동 / 꺨 수 있는 계란이 없으면 이동)
 * 
 * 우선 dfs 진행 과정에서 계란이 서로 내구도가 깎이기 때문에
 * 현재 계란(idx)과 칠 계란(i)의 내구도를 둘 다 내린 후 dfs 후 다시 올리는 구조로 구현
 * 
 * idx가 N에 도달 = 모든 계란 탐색
 * 이 때 내구도가 0 이하인 계란의 수 카운트 후 정답 갱신
 * 
 * 만약 현재 계란이 깨져있다 -> 다음 계란 이동
 * 만약 모든 계란 중 깰 수 있는 계란이 없다 -> 다음 계란 이동
 * 이동 시에는 반드시 dfs()와 함께 return 작성.
 */

