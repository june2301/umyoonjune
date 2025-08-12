package algo_self.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 플로이드2_11780 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] dist = new int[n + 1][n + 1];
		int[][] road = new int[n + 1][n + 1];
		
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
				road[a][b] = b;
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
						road[i][j] = road[i][k];
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
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j || road[i][j] == 0) {
					sb.append("0\n");
					continue;
				}
				List<Integer> path = new ArrayList<Integer>();
				int st = i;
				int en = j;
				while (st != en) {
					st = road[st][en];
					if (st == 0) {
						path.clear();
						break;
					}
					path.add(st);
				}
				sb.append(path.size()+1 + " " + i + " ");
				for (int p : path) {
					sb.append(p + " ");
				}
				sb.append("\n");
			}
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
 * +
 * i->j로 가는 모든 경우 대해 경로를 출력
 * (i와j를 포함한) 거치는 도시수 + " " + i부터 j까지 경로
 * 
 * 기본적인 최단 거리를 구하는 플로이드 워셜 알고리즘에 추가로 경로 저장을 더한 방식
 * 경로 저장을 위해 이차원 배열 road[][]을 생성하고,
 * 플로이드 워셜에서 최단 거리를 초기화하는 로직에 추가로 해당 도착지점을 road[][]에 저장
 * 
 * 이후 복원 로직을 통해 i->j로 이동하는 경로들을 다시 불러온 후 출력
 */

