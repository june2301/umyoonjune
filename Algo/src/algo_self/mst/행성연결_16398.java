package algo_self.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 행성연결_16398 {
	
	static class edge implements Comparable<edge> {
		int from;
		int to;
		int cost;
		
		public edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(edge o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<edge>[] edges = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			edges[i] = new ArrayList<edge>();
		}
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int cost = Integer.parseInt(input[j]);
				if (cost != 0) {
					edges[i+1].add(new edge(i+1, j+1, cost));
				}
			}
		}
		
		PriorityQueue<edge> pq = new PriorityQueue<edge>();
		pq.addAll(edges[1]);
		
		boolean[] visited = new boolean[N+1];
		visited[1] = true;
		
		int cnt = 1;
		long ans = 0;
		while (cnt < N) {
			edge curr = pq.poll();
			if (visited[curr.to]) continue;
			
			ans += curr.cost;
			cnt++;
			visited[curr.to] = true;
			pq.addAll(edges[curr.to]);
		}
		
		System.out.println(ans);
	}

}

/**
 * MST - 프림 알고리즘
 * [문제]
 * N과 N*N크기의 완전 그래프(모든 간선 존재)의 가중치가 주어지고
 * 모든 정점을 연결하는 최소 비용 구하기
 * 
 * 프림 알고리즘 - 정점 중심 확장
 * : 임의의 정점에서 시작해 연결된 가장 비용이 낮은 간선을 하나씩 선택하여 트리 확장
 * - 사이클 방지를 위해 visited[] 방문 처리
 * - 간선이 많은 경우 크루스칼보다 유리
 * - 인접행렬, 인접리스트에 좋음 (크루스칼-간선리스트)
 * 
 * edge 클래스를 만들어 모든 edges를 리스트로 저장
 * 1에서 시작하여 가장 비용이 작은 간선들만 선택하면서 진행
 * 방문처리를 통해 사이클 및 중복계산 방지
 * cnt를 통해 N개만큼 카운트한 경우 종료
 * 
 * 
 * MST여서 edge를 만들어서 (간선리스트로) 풀었지만, 
 * **인접행렬**로 구현하는 것이 더 시간도 빠르고 메모리도 아낄 수 있음.
 * 아래는 입력받는 인접행렬 그대로 푸는 방식
 */

//		int[][] map = new int[N+1][N+1];
//		for (int i = 0; i < N; i++) {
//			String[] input = br.readLine().split(" ");
//			for (int j = 0; j < N; j++) {
//				map[i+1][j+1] = Integer.parseInt(input[j]);
//			}
//		}
//		
//		boolean[] visited = new boolean[N+1];
//		int[] minDist = new int[N+1];
//		
//		int INF = Integer.MAX_VALUE;
//		Arrays.fill(minDist, INF);
//		minDist[1] = 0;
//		
//		long ans = 0;
//		
//		for (int i = 1; i <= N; i++) {
//			int u = -1;
//			int best = INF;
//			for (int v = 1; v <= N; v++) {
//				if (!visited[v] && minDist[v] < best) {
//					best = minDist[v];
//					u = v;
//				}
//			}
//			
//			visited[u] = true;
//			ans += best;
//			
//			for (int v = 1; v <= N; v++) {
//				if (!visited[v] && map[u][v] < minDist[v]) {
//					minDist[v] = map[u][v];
//				}
//			}
//		}
//		
//		System.out.println(ans);
