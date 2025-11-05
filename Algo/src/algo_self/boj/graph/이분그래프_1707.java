package algo_self.boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 이분그래프_1707 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int k = 0; k < K; k++) {
			String[] VE = br.readLine().split(" ");
			int V = Integer.parseInt(VE[0]);
			int E = Integer.parseInt(VE[1]);

			List<Integer>[] graph = new ArrayList[V+1];
			for (int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				String[] AB = br.readLine().split(" ");
				int A = Integer.parseInt(AB[0]);
				int B = Integer.parseInt(AB[1]);
				graph[A].add(B);
				graph[B].add(A);
			}

			int[] color = new int[V + 1];
			boolean check = true; 

			for (int i = 1; i <= V; i++) {
				if (color[i] == 0) { 
					if (!bfs(i, graph, color)) {
						check = false;
						break;
					}
				}
			}

			sb.append(check ? "YES" + "\n" : "NO"+ "\n");
		}

		System.out.println(sb);
	}

	static boolean bfs(int start, List<Integer>[] graph, int[] color) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		color[start] = 1;

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int next : graph[curr]) {
				if (color[next] == 0) {
					color[next] = 3 - color[curr];
					q.offer(next);
				} else if (color[next] == color[curr]) {
					return false;
				}
			}
		}
		return true;
	}
}

/**
 * 그래프 + bfs
 * [문제]
 * K개만큼의 테스트 케이스에서 V개의 정점과 E개의 간선을 지닌 그래프가 주어진다.
 * 이 그래프의 정점을 두 개의 집합으로 나눴을 때, 각 집합 안에서 연결된 정점이 없으면 이분 그래프라고 부른다.
 * 이분 그래프가 가능하면 YES 불가능하면 NO를 출력하시오.
 * 
 * 인접리스트를 만들고 양방향으로 간선 정보를 저장한다
 * 이후 아직 방문하지 않은(color == 0) 정점들에 대해서 bfs로 탐색 진행
 * 
 * bfs탐색을 진행하면서 아직 방문하지 않은 정점은 반대색으로 채우기
 * 이 때, 만약 같은 색깔이 걸리는 경우 이분 그래프 불가능
 */

