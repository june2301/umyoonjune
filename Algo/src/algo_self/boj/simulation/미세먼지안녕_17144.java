package algo_self.boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미세먼지안녕_17144 {
	
	static int N, M;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int[][] map;
	static int[][] cleaner;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
		
        map = new int[N][M];
        cleaner = new int[2][2];
        for (int r = 0; r < N; r++) {
        	st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == -1 && cleaner[1][0] == 0) {
					cleaner[0][0] = r;
					cleaner[0][1] = c;
					cleaner[1][0] = r+1;
					cleaner[1][1] = c;
				}
			}
		}
        
        while (T-- > 0) {
			
        	Queue<int[]> q = new LinkedList<int[]>();
        	for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] < 5) continue;
					int w = map[r][c] / 5;
					int cnt = 0;
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == -1) continue;
						q.add(new int[] {nr, nc, w});
						cnt++;
					}
					map[r][c] -= cnt*w;
				}
			}
        	
        	while (!q.isEmpty()) {
				int[] curr = q.poll();
				int r = curr[0];
				int c = curr[1];
				int w = curr[2];
				map[r][c] += w;
			}
        	
        	top();
        	bottom();
        	
		}
        
        int ans = 0;
        for (int r = 0; r < N; r++) {
        	for (int c = 0; c < M; c++) {
        		if (map[r][c] > 0) ans += map[r][c];
        	}
        }
		
		System.out.println(ans);
		
	}
	
	static void top() {
		int cr = cleaner[0][0]; 
		int cc = cleaner[0][1]; 
		
		for (int r = cr-1; r > 0; r--) {
			map[r][0] = map[r-1][0];
		}
		for (int c = cc; c < M-1; c++) {
			map[0][c] = map[0][c+1];
		}
		for (int r = 0; r < cr; r++) {
			map[r][M-1] = map[r+1][M-1];
		}
		for (int c = M-1; c > cc+1; c--) {
			map[cr][c] = map[cr][c-1];
		}
		
		map[cr][cc+1] = 0;
	}
	
	static void bottom() {
		int cr = cleaner[1][0]; 
		int cc = cleaner[1][1]; 
		
		for (int r = cr+1; r < N-1; r++) {
			map[r][0] = map[r+1][0];
		}
		for (int c = cc; c < M-1; c++) {
			map[N-1][c] = map[N-1][c+1];
		}
		for (int r = N-1; r > cr; r--) {
			map[r][M-1] = map[r-1][M-1];
		}
		for (int c = M-1; c > cleaner[1][1]+1; c--) {
			map[cr][c] = map[cr][c-1];
		}
		
		map[cr][cc+1] = 0;
	}

}

/**
 * 시뮬레이션
 * [문제]
 * 미세먼지 양과 공청기(2칸차지)의 위치가 주어진 N,M크기의 격자판이 주어진다.
 * 공청기는 r=0인 곳에 붙어있으며 위 아래로 2칸이상 떨어져 있다.
 * 1초당 진행순서
 * 1. 미세먼지는 (미세먼지양/5)만큼 좌우 4칸으로 퍼지며, 퍼진만큼 감소 (단, 범위 벗어나거나 공청기자리로는 안퍼짐)
 * 2. 공청기가 공기를 순환시켜서 위는 반시계, 아래는 시계방향으로 공기를 한 칸씩 이동(직선 형태로 이동)
 * 이 때 T초 후 미세먼지 총 합을 구하시오.
 * 
 * 우선 입력을 받으며 공청기의 위치 2칸을 기록
 * 이후 진행 순서에 맞게 while문 작성
 * 
 * 1. 미세먼지 퍼짐
 * 미세먼지가 위치한 지역마다 q에 퍼질 먼지들의 위치와 양을 기록 후
 * 퍼진 횟수만큼 미세먼지 감소 + q를 다 비우면서 미세먼지 추가
 * 
 * 2. 공기 순환
 * 공청기 위와 아래를 분리하여 메서드로 만듦
 * 반드시 직선으로 격자판 끝까지 진행하기 때문에 0까지 혹은 N-1이나 M-1까지 진행시키며
 * 미세먼지를 1칸씩 이동
 * 
 * T번 실행 후 남은 미세먼지 총량 더한 후 출력
 */

