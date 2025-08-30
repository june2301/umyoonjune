package algo_self.boj.bellman_ford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 타임머신_11657 {
	
	static class Edge{
		int from;
		int to;
		int cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	static long INF = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		List<Edge> edges = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			int C = Integer.parseInt(input[2]);
			
			edges.add(new Edge(A, B, C));
		}
		
		long[] dist = new long[N+1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		
		for (int i = 1; i <= N-1; i++) {
			boolean check = false;
			for (Edge e : edges) {
				if (dist[e.from] == INF) continue;
				if (dist[e.to] > dist[e.from] + e.cost) {
					dist[e.to] = dist[e.from] + e.cost;
					check = true;
				}
			}
			if (!check) break;
		}
		
		boolean neg = false;
		for (Edge e : edges) {
			if (dist[e.from] == INF) continue;
			if (dist[e.to] > dist[e.from] + e.cost) {
				neg = true;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if (neg) {
			sb.append("-1");
		} else {
			
			for (int i = 2; i <= N; i++) {
				if (dist[i] == INF) {
					sb.append(-1 + "\n");
				} else {
					sb.append(dist[i] + "\n");
				}
			}
		}
		System.out.println(sb);
		
	}

}

/**
 * 벨만-포드
 * [문제]
 * N개의 도시에 M개의 버스가 주어지고
 * A시작 B도착 C시간이 걸린다.
 * 무한히 돌아갈 수 있으면 첫째줄에 -1 출력
 * 그렇지 않다면, 2번 도시부터 가장 빠른 시간 순서대로 출력
 * 
 * 벨만 포드 알고리즘
 * dist에 최단경로를 저장하기 위해 생성 후 최댓값으로 초기화
 * N-1번 반복을 하면서 dist 갱신
 * -> N-1번 반복하는 이유 : 최단 경로에 간선이 최대 N-1개 들어갈 수 있으므로 반복
 *    모든 최단 거리 확정(ex: 1->2(2) 2->3(2) 일 때, 1번째 루프에서 [3]=4로 업데이트 할 수 없음)
 *    
 * N번째 반복을 했을 때 값이 갱신된다? -> 음수 사이클이 존재(무한 과거로 돌아가기 가능)
 * 
 * 음수 사이클 -1 출력 종료
 * 아닐 경우 2부터 최단거리들 출력
 */

