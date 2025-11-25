package algo_self.boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 구슬찾기_2617 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NKM = br.readLine().split(" ");
		
		int N = Integer.parseInt(NKM[0]);
		int M = Integer.parseInt(NKM[1]);
		
		int[][] graph = new int[N+1][N+1];
		
		
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			graph[A][B] = 1;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (graph[i][k] == 0) continue;
				for (int j = 1; j <= N; j++) {
					if (graph[k][j] == 0) continue;
					graph[i][j] = 1;
				}
			}
		}
		
		int[] light = new int[N+1];
		int[] heavy = new int[N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (graph[i][j] == 1) {
					heavy[j]++;
					light[i]++;
				}
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (light[i] > N/2) ans++;
			if (heavy[i] > N/2) ans++;
		}
		
		System.out.println(ans);
		
	}

}

/**
 * 그래프 + 플로이드-워셜
 * [문제]
 * 홀수개의 구슬 N개에 대해 2개씩 무게를 비교한 정보가 M번 주어진다.
 * 이 때, 절대 중간이 될 수 없는 구슬의 개수를 구하시오.
 * (ex: 5개의 구슬 중 1보다 가벼운게 3개인 경우 1은 불가능)
 * 
 * 비슷한 문제 : 프로그래머스 - LV3순위
 * 
 * 서로 비교를 통한 방향성 존재 -> 그래프
 * A가 B보다 무겁고 B가 C보다 무거우면 A가 C보다 무거움 -> 플로이드-워셜
 * 
 * 그래프를 인접행렬로 입력받아 i가 j보다 무거운 경우 1로 저장
 * 이후 플로이드-워셜을 통해 서로 무거운 관계인 경우 1로 갱신
 * 
 * 저장된 무게관계를 바탕으로 배열 2개를 만들어서
 * 해당 구슬보다 무거운/가벼운 구슬의 개수 카운트
 * 
 * 구슬 i에 대해 무겁거나 가벼운 구슬이 2/N개보다 크면 중간 불가능
 */

