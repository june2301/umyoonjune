package ssafy_1st.algo_2nd_0906;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈주범검거_1953 {
	
	static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();
			
			map = new int[N][M];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			bfs();
			
			// true 개수 확인 -> bfs돌면서 확인해도 OK
			int ans = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (visited[r][c]) {
						ans++;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
		
	}
	
	static void bfs() {
		visited = new boolean[N][M];
		Node node = new Node(R, C);
		Queue<Node> q = new LinkedList<>();
		
		q.add(node);
		visited[R][C] = true;
		
		int hour = L-1; // 1 넣고 시작하므로
		while (hour > 0) {
			int size = q.size(); // q.size만큼 도는게 1시간
			for (int t = 0; t < size; t++) {
				Node curr = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nr = curr.r + dr[i];
					int nc = curr.c + dc[i];
					int save = map[curr.r][curr.c]; // 현재 터널구조
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) 
						continue;
					int after = map[nr][nc]; // 다음 터널 구조
					if (!visited[nr][nc]) {
						// 상
						if (i == 0 
								&& (save == 1 || save == 2 || save == 4 || save == 7) 
								&&(after == 1 || after == 2 || after == 5 || after == 6)) {
							visited[nr][nc] = true;
							q.add(new Node(nr, nc));
						}
						// 하
						if (i == 1 
								&& (save == 1 || save == 2 || save == 5 || save == 6) 
								&& (after == 1 || after == 2 || after == 4 || after == 7)) { 
							visited[nr][nc] = true;
							q.add(new Node(nr, nc));
						}
						// 좌
						if (i == 2 
								&& (save == 1 || save == 3 || save == 6 || save == 7) 
								&& (after == 1 || after == 3 || after == 4 || after == 5)) { 
							visited[nr][nc] = true;
							q.add(new Node(nr, nc));
						}
						// 우
						if (i == 3 
								&& (save == 1 || save == 3 || save == 4 || save == 5) 
								&& (after == 1 || after == 3 || after == 6 || after == 7)) { 
							visited[nr][nc] = true;
							q.add(new Node(nr, nc));
						}
					}
				}
			}
			hour--;
		}
		
	}
	
}
