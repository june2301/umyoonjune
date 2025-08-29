package algo_self.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 물대기_1368 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dist = new int[N];
		for (int i = 0; i < N; i++) {
			dist[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		boolean[] visited = new boolean[N];
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int to = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					to = j;
				}
			}
			
			visited[to] = true;
			ans += min;
			
			for (int j = 0; j < N; j++) {
				if (!visited[j] && map[to][j] < dist[j]) {
					dist[j] = map[to][j];
				}
			}
			
		}
		
		System.out.println(ans);
	}

}

/**
 * 프림 알고리즘
 * [문제]
 * N개의 논이 주어지고 각 논에 우물을 파는 비용과 각각 논들을 연결하는 비용이 주어진다.
 * 논에 우물을 파거나 우물이 파진 논을 연결하여 모든 논에 물을 대는데 필요한 최소 비용을 구하시오.
 * 
 * 각각의 논에 우물을 파는게 비용이 더 적을 수 있으므로 dist배열에 우물 파는 비용을 기록
 * 프림 알고리즘 구현(한 정점에서 이동 비용이 가장 싼 정점 선택하며 MST 완성)
 * 
 * N번 반복하며 모든 정점을 확인하도록 구현
 * to(가려는 지점), min(가는데 최소 비용) 선언 및 초기화
 * j-1번 for문 : 방문 안한 정점들 중 이동 비용(우물 파는 비용 포함)이 제일 적은 정점 선택
 * j-2번 for문 : 이동할 정점(to)에서 갈 수 있는 정점들 중 dist에 있는 값보다 비용이 더 적은 경우 갱신
 * 
 * to를 통해 이동할 지점 방문처리 + 연결된 정점들 이동비용 바탕으로 dist값 갱신
 * min을 통해 ans에 최소 비용 누적
 */

