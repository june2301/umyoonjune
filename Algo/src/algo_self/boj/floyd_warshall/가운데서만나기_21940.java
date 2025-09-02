package algo_self.boj.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가운데서만나기_21940 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		int INF = Integer.MAX_VALUE;
		
		int[][] map = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0;
		}
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);
			map[r][c] = w;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (map[i][k] == INF) continue;
				for (int j = 1; j <= N; j++) {
					if (map[k][j] == INF) continue;
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		int[] max = new int[N+1];
		Arrays.fill(max, -1);
		boolean[] can = new boolean[N+1];
		Arrays.fill(can, true);
		
		int K = Integer.parseInt(br.readLine());
		String[] friends = br.readLine().split(" ");
		for (int i = 0; i < K; i++) {
			int city = Integer.parseInt(friends[i]);
			for (int j = 1; j <= N; j++) {
				if (map[city][j] == INF || map[j][city] == INF) {
					can[j] = false;
					continue;
				}
				if (max[j] < map[city][j] + map[j][city]) {
					max[j] = map[city][j] + map[j][city];
				}
			}
		}
		
		int min = INF;
		for (int i = 1; i <= N; i++) {
			if (!can[i]) continue;
			min = Math.min(max[i], min);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (!can[i]) continue;
			if (max[i] == min) {
				sb.append(i + " ");
			}
		}
		
		System.out.println(sb);	
		
	}

}

/**
 * 플로이드-워셜
 * [문제]
 * 도시의 수 N과 간선의 수 M이 주어지고, M개만큼 A->B로 이동 비용 C가 주어지고,
 * 친구의 수 K와 각 친구들의 도시가 주어진다.
 * 이 때, 친구들이 갈 수 있는 도시들 중 왕복시간(A->B + B->A)이 가장 짧은 도시(여러 개 가능)를 구하시오.
 * 
 * 플로이드 워셜을 통해 모든 도시별 최단 이동거리를 구한다.
 * **플로이드 워셜은 3개의 for문을 바탕으로 거리를 갱신하기 때문에 인접행렬로 입력받는 것이 좋다**
 * -> dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
 * 
 * 각 도시별로 몇 인원이 이동 불가능한 도시가 있을 수 있으므로,
 * can배열을 생성하여 boolean값으로 이동 가능한지 체크
 * max배열에는 친구들 도시에서 출발하여 각 도시별 최대 왕복거리를 저장
 * 
 * min을 선언 후 can으로 갈 수 있는 도시 중 max로 저장된 최댓값들 중 최솟값 저장
 * 갈 수 있는 도시들 중 max[i]가 min인 도시들 출력
 */

