package algo_self.boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 백조의호수_3197 {
	
	static int R, C;
	static char[][] map;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	static List<int[]> L;
	
	static int[][] mDay;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NK = br.readLine().split(" ");
		
		R = Integer.parseInt(NK[0]);
		C = Integer.parseInt(NK[1]);
		
		map = new char[R][C];
		L = new ArrayList<int[]>();
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			map[i] = input.toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'L') {
					L.add(new int[] {i, j});
				}
			}
		}
		
		mDay = new int[R][C];
		
		meltDay();
		
		int ans = dijkstra();
		
		System.out.println(ans);
		
	}
	
	static void meltDay() {
		for (int i = 0; i < R; i++) {
			Arrays.fill(mDay[i], -1);
		}
		
		Queue<int[]> q = new LinkedList<>();
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] != 'X') {
					mDay[r][c] = 0;
					q.add(new int[] {r, c});
				}
			}
		}
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if (mDay[nr][nc] != -1) continue;
				if (map[nr][nc] == 'X') {
					mDay[nr][nc] = mDay[r][c] + 1;
				}
				q.add(new int[] {nr, nc});
			}
		}
		
	}
	
	static int dijkstra() {
		int[] L1 = L.get(0);
		int[] L2 = L.get(1);
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {return a[2] - b[2];});
		pq.add(new int[] {L1[0], L1[1], 0});
		
		int[][] dist = new int[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(dist[i], 1500);
		}
		dist[L1[0]][L1[1]] = 0;
		
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int r = curr[0];
			int c = curr[1];
			int cost = curr[2];
			
			if (cost > dist[r][c]) continue;
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				
				if (nr == L2[0] && nc == L2[1]) {
					return cost;
				}
				int nCost = Math.max(cost, mDay[nr][nc]);
				
				if (nCost < dist[nr][nc]) {
					dist[nr][nc] = nCost;
					pq.add(new int[] {nr, nc, nCost});
				}
			}
		}
		
		return mDay[L2[0]][L2[1]];
	}

}

/**
 * 다익스트라
 * [문제]
 * R*C크기의 호수에 백조L 2마리가 있고, .물과 X얼음이 주어진다.
 * X주변(가로세로 1칸)에 .이 있으면 하루 뒤 녹고, 백조도 가로세로로만 이동 가능할 때,
 * 백조 2마리가 만나는데 필요한 날의 수를 구하시오.
 * 
 * int[][] mDay를 만들어서 각 얼음이 녹는데 필요한 날 수를 구하기
 * 모든 .과 L을 q에 넣은 후 nr,nc가 X일 경우 mDay[nr][nc] + 1 진행
 * -> mDay배열에 모든 얼음이 녹는데 필요한 시간 기록
 * 
 * 이후 다익스트라를 활용하여 L1에서 출발하여 L2에 도달하는 최단 일수 계산
 * dist[][]배열 선언 후 높은 값으로 초기화(문제의 R,C범위가 1500)
 * 탐색을 진행하며 해당 위치까지 가는데 녹여야 하는 최소 얼음 일수 계산
 * 
 * --보다 정석적인 풀이--
 * 이중 큐 BFS
 * 백조 큐 + 물 큐 를 이용하여 다음날 물이 되는 위치들만 이용하여 탐색 진행
 * 백조 큐 - 다음날 물이되는 큐 담은 후 해당 위치부터 탐색
 * 물 큐 - 다음날 물이 되는 큐 담은 후 한 칸씩 확장
 */

