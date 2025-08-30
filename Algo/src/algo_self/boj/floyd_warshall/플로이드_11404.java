package algo_self.boj.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 플로이드_11404 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] dist = new int[n + 1][n + 1];
		
		int INF = Integer.MAX_VALUE;
		
		for (int i = 1; i <= n; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
		
		for (int i = 0; i < m; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			if (c < dist[a][b]) {
				dist[a][b] = c;
			}
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (dist[i][k] == INF) continue;
				for (int j = 1; j <= n; j++) {
					if (dist[k][j] == INF) continue;
					int next = dist[i][k] + dist[k][j];
					if (next < dist[i][j]) {
						dist[i][j] = next;
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dist[i][j] == INF) {
					sb.append(0 + " ");
				} else {
					sb.append(dist[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}

}

/**
 * 플로이드-워셜
 * [문제]
 * 정점과 간선(비용)이 주어지고
 * 각 정점에서 다른 정점까지 이동 가능한 모든 경우의 최소 비용 계산
 * 이동 불가능한 경우 0 출력
 * 
 * 플로이드-워셜 알고리즘
 * : 모든 정점 쌍 사이 최단 경로 길이 구하기 위해 DP를 이용해 점진적으로 경유지를 확장해가며 최단 거리 갱신(가중치 음수 가능)
 * 
 * 주어진 간선 정보를 이차원 배열에 저장 
 * i->i 본인으로 이동은 최단경로 0으로 저장
 * 
 * 이후 거쳐갈 정점 k를 기준으로 i->k->j 경로 갱신
 * k반복문 안에 i와j반복문을 구성하여
 * i->k경로와 k->j경로가 존재하면(INK가 아니면)
 * i->k->j경로 거리와 i->j경로 거리 비교하여 갱신
 * 
 * DP : D(k)[i][j] = min(D(k-1)[i][j], D(k-1)[i][k] + D(k-1)[k][j])
 */

