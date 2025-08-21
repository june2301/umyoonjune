package algo_self.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 서강그라운드_14938 {
	
	static int INF = 100_000;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nmr = br.readLine().split(" ");
		int n = Integer.parseInt(nmr[0]);
		int m = Integer.parseInt(nmr[1]);
		int r = Integer.parseInt(nmr[2]);
		
		int[] item = new int[n+1];
		String[] nInput = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			item[i+1] = Integer.parseInt(nInput[i]);
		}
		
		int[][] map = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0;
		}
		
		for (int i = 0; i < r; i++) {
			String[] road = br.readLine().split(" ");
			int a = Integer.parseInt(road[0]);
			int b = Integer.parseInt(road[1]);
			int l = Integer.parseInt(road[2]);
			
			map[a][b] = map[b][a] = l;
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (map[i][k] == INF) continue;
				for (int j = 1; j <= n; j++) {
					if (map[k][j] == INF) continue;
					int next = map[i][k] + map[k][j];
					if (next < map[i][j]) {
						map[i][j] = next;
					}
				}
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				if (map[i][j] <= m) {
					sum += item[j];
				}
			}
			ans = Math.max(ans, sum);
		}
		
		System.out.println(ans);
	}

}

/**
 * 플로이드-워셜
 * [문제]
 * 지역수n 수색범위m 길의수r이 주어지고,
 * 각 지역마다 얻을 수 있는 아이템의 수가 주어지고,
 * 지역번호 a, b 와 길의 길이 l이 주어진다.
 * 여기서 한 지역에서 수색범위m 내로 얻을 수 있는 아이템의 최대 개수를 구하시오.
 * 
 * 다익스트라도 가능하지만 플로이드-워셜로 풀이
 * 
 * 플로이드-워셜 풀이를 위해 인접 행렬로 구현
 * map[][] 생성 후 최대값으로 초기화(본인은 0)
 * 길이 양방향이므로 양쪽에 추가
 * 
 * 플로이드-워셜 알고리즘으로 각 지점별 최단거리 갱신
 * (i->k 가 있고, k->j가 있을 때 => i->k->j가 i->j보다 짧으면 갱신)
 * 
 * 각 n지점에서 다른 지점까지 거리가 m보다 짧으면 item획득(본인 포함)
 * 최대값 구하여 답 출력
 */

