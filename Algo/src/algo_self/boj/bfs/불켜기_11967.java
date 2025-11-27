package algo_self.boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 불켜기_11967 {
	
	static int N, M;
	static int[][] map;
	static List<int[]>[][] graph;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		
		map = new int[N+1][N+1];
		
		graph = new ArrayList[N+1][N+1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				graph[r][c] = new ArrayList<int[]>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			int a = Integer.parseInt(input[2]);
			int b = Integer.parseInt(input[3]);
			
			graph[x][y].add(new int[] {a, b});
		}
		
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		map[1][1] = 1;
		int cnt = 1;
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {1, 1});
		
		boolean[][] visited = new boolean[N+1][N+1];
		visited[1][1] = true;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			
			for (int[] on : graph[r][c]) {
				int a = on[0];
				int b = on[1];
				if (map[a][b] == 0) {
					map[a][b] = 1;
					cnt++;
				}
				if (!visited[a][b]) {
					for (int i = 0; i < 4; i++) {
						int or = a + dr[i];
						int oc = b + dc[i];
						if (or < 1 || or > N || oc < 1 || oc > N) continue;
						if (map[or][oc] == 1 && visited[or][oc]) {
							q.add(new int[] {a, b});
							visited[a][b] = true;
							break;
						}
					}
				}
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 1 || nr > N || nc < 1 || nc > N || visited[nr][nc]) continue;
				if (map[nr][nc] == 1) {
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		
		return cnt;
	}
	
}

/**
 * bfs + 그래프
 * [문제]
 * N*N크기의 헛간에 1,1에 불이 켜져있을 때, 오직 불이 켜진 방으로만 이동할 수 있다.
 * M개만큼의 방에서 불을 켤 수 있는 방에 대한 정보가 주어질 때, 불을 켤 수 있는 방의 최댓값을 구하시오.
 * 
 * 방마다 불을 켤 수 있는 방에 대한 정보를 List<int>[][]로 저장 후
 * bfs과정에서 호출하여 불을 켠 후 탐색 진행
 * 
 * bfs에서 1,1에서 시작 및 방문처리
 * 현재 위치에서 켤 수 있는 스위치를 모두 켜주면서 해당 위치의 상하좌우에 이미 방문한 좌표가 있다면(켠 위치로 이동할 수 있다면)
 * q에 추가 후 방문처리
 * 
 * 이후 4방 탐색을 통해 불이 켜져있는데 방문 안한 위치 탐색 진행
 * 
 * -> 불을 켜줄 때도 어차피 q에 들어가기 때문에 방문처리를 꼭 해주어야 무한 반복이 일어나지 않음!
 */

