package algo_self.boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 아기상어_16236 {

	static int N, sr, sc, fish;
	static int[][] map;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			String[] input = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(input[c]);
				if (map[r][c] == 9) {
					sr = r;
					sc = c;
				} else if (1 <= map[r][c] && map[r][c] <= 6) {
					fish += 1;
				}
			}
		}
		
		int size = 2;
		int cnt = 0;
		int ans = 0;
		while (true) {
			if (fish == 0) break;
			
			int tem = bfs(size);
			if (tem == 0) {
				break;
			} else {
				fish -= 1;
				ans += tem;
				cnt += 1;
			}
			
			if (cnt == size) {
				size += 1;
				cnt = 0;
			}
			
		}
		
		System.out.println(ans);
		
	}
	
	static int bfs(int size) {
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new LinkedList<int[]>();
		
		visited[sr][sc] = true;
		q.add(new int[] {sr, sc, 0});
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
			if (a[2] != b[2]) return a[2] - b[2];
			if (a[0] != b[0]) return a[0] - b[0];
			return a[1] - b[1];
		});
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				int time = now[2];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] > size) continue;
				if (map[nr][nc] > 0 && map[nr][nc] < size) {
					pq.add(new int[] {nr, nc, time + 1});
				}
				if (map[nr][nc] <= size) {
					q.add(new int[] {nr, nc, time + 1});
					visited[nr][nc] = true;
				}
			}
		}
		
		if (!pq.isEmpty()) {
			int[] eat = pq.poll();
			int nr = eat[0];
			int nc = eat[1];
			int time = eat[2];
			
			map[sr][sc] = 0;
			map[nr][nc] = 9;
			sr = nr;
			sc = nc;
			return time;
		}
		
		return 0;
		
	}

}

/**
 * 구현 문제
 * 
 * 상어의 크기가 2로 시작하며,
 * 상어보다 작은 숫자의 물고기를 가까운 순서로 먹고,
 * 상어 크기만큼 물고기를 먹으면 상어의 크기 성장
 * 
 * 물고기의 위치를 bfs로 찾으며,
 * 거리가 같은 물고기가 여러 마리일 경우,
 * 가장 위, 가장 왼쪽의 물고기를 선택해야 하므로 pq에 담아서 비교
 * 
 * 어차피 같은 거리 내에서 상하좌우로 dr, dc를 지정해두면 해결될 것이라 생각하였으나
 * 같은 거리의 물고기를 비교하는 과정 반드시 필요!
 */

