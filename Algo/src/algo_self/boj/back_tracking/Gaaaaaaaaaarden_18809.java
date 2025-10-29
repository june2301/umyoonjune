package algo_self.boj.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Gaaaaaaaaaarden_18809 {
	
	static int N, M, G, R;
	static int[][] gar;
	static List<int[]> able;
	static int ans;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] NMGR = br.readLine().split(" ");
        N = Integer.parseInt(NMGR[0]);
        M = Integer.parseInt(NMGR[1]);
        G = Integer.parseInt(NMGR[2]);
        R = Integer.parseInt(NMGR[3]);
        
        gar = new int[N][M];
        able = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			String[] input = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				gar[r][c] = Integer.parseInt(input[c]);
				if (gar[r][c] == 2) {
					able.add(new int[] {r, c});
				}
			}
		}
		
		ans = 0;
		boolean[] selected = new boolean[able.size()];
		boolean[] colorSelected = new boolean[able.size()];
		
		select(0, 0, 0, selected, colorSelected);
		
		System.out.println(ans);
		
	}
	
	static void select(int idx, int gCnt, int rCnt, boolean[] selected, boolean[] colorSelected) {
		if (gCnt > G || rCnt > R) return;
		
		if (idx == able.size()) {
			if (gCnt == G && rCnt == R) {
				List<int[]> list = new ArrayList<>();
				for (int i = 0; i < able.size(); i++) {
					if (selected[i]) {
						int[] curr = able.get(i);
						int color = colorSelected[i] ? 3 : 4;
						list.add(new int[] {curr[0], curr[1], color});
					}
				}
				ans = Math.max(ans, check(list));
			}
			return;
		}
		
		select(idx+1, gCnt, rCnt, selected, colorSelected);
		
		selected[idx] = true;
		colorSelected[idx] = true;
		select(idx+1, gCnt+1, rCnt, selected, colorSelected);
		
		colorSelected[idx] = false;
		select(idx+1, gCnt, rCnt+1, selected, colorSelected);
		
		selected[idx] = false;
	}
	
	static int check(List<int[]> list) {
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
		    map[i] = gar[i].clone();
		}
		int[][] time = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		
		for (int[] i : list) {
			int r = i[0];
			int c = i[1];
			int color = i[2];
			q.add(new int[] {r, c, color, 0});
			map[r][c] = color;
		}
		
		int cnt = 0;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int color = curr[2];
			int t = curr[3];
			if (map[r][c] == 5) continue;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (map[nr][nc] == 7 - color && time[nr][nc] == t+1) {
					map[nr][nc] = 5;
					cnt++;
				} else if (map[nr][nc] == 1 || map[nr][nc] == 2) {
					map[nr][nc] = color;
					time[nr][nc] = t+1;
					q.add(new int[] {nr, nc, color, t+1});
				}
			}
		}
		
		return cnt;
	}

}

/**
 * 백트래킹(조합) + bfs + 시뮬레이션
 * [문제]
 * N*M크기의 정원이 칸마다 0, 1, 2로 주어져 있다.
 * 이 때 R, G개의 빨간색, 초록색 배양액을 뿌리려고 한다.
 * 정원에 2인 칸에 배양액을 뿌릴 수 있으며 배양액은 0(호수)을 제외한 지역으로 매 초마다 퍼져나간다.
 * 이 때 빨간색 배양액과 초록색 배양액이 동시에 같은 땅에 도달하면 꽃이 피어난다.
 * N M G R과 정원의 정보가 주어질 때, 최대 몇 개의 꽃을 피울 수 있는지 구하시오.
 * 
 * [아이디어]
 * 정원의 2의 개수를 카운트한 후 R,G를 뿌리는 경우의 수를 구한 후
 * 해당 위치에 R, G를 뿌린 후 꽃이 몇 개 피는지 구하기.
 * 
 * select() 함수를 통해 조합 구현
 * 1. 배양액을 넣는 경우 / 2. 초록배양하는 경우 / 3. 빨간배양하는 경우
 * 위 경우에 따라 selected[]와 colorSelected를 체크하며
 * 모든 배양액을 배양한 경우에 각각의 위치를 list에 넣은 후 check함수에 전달.
 * 이 때 list에 어떤 위치에 어떤 색깔을 넣는지 전달
 * (초록 : 3 / 빨간 : 4)
 * 
 * check() 함수를 통해 꽃 개수 구하기
 * 매 경우마다 map에 시뮬레이션을 해야하기 때문에 gar.clone() 진행
 * + 같은 시간에 퍼졌는지 확인하기 위해 time[][] 배열에 퍼진 시간 기록
 * 
 * 전달받은 배양액 위치에 따라 map에 배양액을 뿌린 후, q에 초기 위치+시간 담기
 * bfs로 시뮬레이션 진행
 * 
 * 1. map[r][c] == 5 이면 이미 꽃인 땅이므로 스킵
 * 2. map[nr][nc] == 7 - color && time[nr][nc] == t+1
 * 퍼지려는 위치에 자신과 반대 색깔이 있고, 같은 시간에 도착했을 때 -> 꽃 핌
 * 3. map[nr][nc] == 2 || 1 퍼지는 위치이므로 배양액 퍼지고, q에 담기
 */

