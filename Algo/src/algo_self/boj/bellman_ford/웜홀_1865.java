package algo_self.boj.bellman_ford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 웜홀_1865 {
	
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

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int T = 1; T <= TC; T++) {
			
			String[] NMW = br.readLine().split(" ");
			
			int N = Integer.parseInt(NMW[0]);
			int M = Integer.parseInt(NMW[1]);
			int W = Integer.parseInt(NMW[2]);
			
			List<Edge> edges = new ArrayList<>();
			
			for (int i = 0; i < M; i++) {
				String[] input = br.readLine().split(" ");
				int A = Integer.parseInt(input[0]);
				int B = Integer.parseInt(input[1]);
				int C = Integer.parseInt(input[2]);
				
				edges.add(new Edge(A, B, C));
				edges.add(new Edge(B, A, C));
			}
			
			for (int i = 0; i < W; i++) {
				String[] input = br.readLine().split(" ");
				int A = Integer.parseInt(input[0]);
				int B = Integer.parseInt(input[1]);
				int C = Integer.parseInt(input[2]);
				
				edges.add(new Edge(A, B, -C));
			}
			
			long[] dist = new long[N+1];
			
			for (int i = 1; i <= N-1; i++) {
				boolean check = false;
				for (Edge e : edges) {
					if (dist[e.to] > dist[e.from] + e.cost) {
						dist[e.to] = dist[e.from] + e.cost; 
						check = true;
					}
				}
				if (!check) break;
			}
			
			boolean neg = false;
			for (Edge e : edges) {
				if (dist[e.to] > dist[e.from] + e.cost) {
					neg = true;
					break;
				}
			}
			
			if (neg) {
				sb.append("YES" + "\n");
			} else {
				sb.append("NO" + "\n");
			}
			
		}
		
		System.out.println(sb);

	}

}

/**
 * 벨만-포드
 * [문제]
 * TC만큼 테스트케이스가 주어지고 그 다음부터
 * 지점수N 도로수M 웜홀수W가 주어진 후 도로정보(무방향)와 웜홀정보(방향 있음)가 주어진다.
 * 이 떄 한 지점에서 출발을 해서 시간여행 후 다시 출발 지점으로 돌아왔을 떄 
 * 출발했을 때보다 시간이 되돌아가는게 가능하면 YES / 불가능하면 NO 출력
 * 
 * [벨만-포드 알고리즘]
 * 방향이 없는 도로와 방향이 있는 웜홀이 주어지기에
 * 도로 정보는 양방향으로 넣어주고 웜홀 정보는 단방향으로 넣어준다.
 * 
 * 이후 벨만 포드 알고리즘을 구현
 * N개의 정점에 대하여 N-1번 M개의 간선들을 탐색한 후
 * 추가로 1번 간선들을 탐색했을 때 값이 변한다 => 음수 사이클 존재
 * - 여기서 check를 통해 해당 라운드에서 갱신이 없으면 스킵하며 최적화
 * 
 * 1. N-1번만 탐색을 진행한 후 다시 1번 탐색을 진행하는 이유
 *    : N개의 경로에 대해서 최대 간선 선택 수는 N-1개
 *      만약 최악의 경우 한 정점씩 확인하면서 전진하게 되기 때문에 N-1번 순환 필요
 *      ex) 간선 순서가 다음과 같이 입력 341/231/121 - 이 경우 한 사이클 당 정점 1개씩 전진
 *      그럼 정렬을 하는건? 
 *      -> 출발선에서 가까운 순으로 정렬할 수 있겠지만, 벨만 포드의 목적은 음수 간선을 다루기 위함
 *         간선 순서를 바꾼다고 시간복잡도가 줄어들지 않으며, 결국 최악의 경우를 대비해 N-1번 반복이 필요
 *         오히려 구현 난이도가 증가할 수 있음
 *      
 * 2. check 최적화
 *    : 음수 사이클이 있으면 거리 갱신이 계속 발생 - check 계속 true
 *      음수 사이클이 없으면 어느 순간 모든 최단 거리가 확정되고, 갱신이 발생하지 않음 - check 계속 false
 *      -> 이 경우 거리가 확정된 이후의 모든 탐색은 계속 같은 값만 확인
 *         따라서 check를 통해 시간 최적화
 */

