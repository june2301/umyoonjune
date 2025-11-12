package algo_self.boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 확장게임_16920 {

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NMP = br.readLine().split(" ");
		int N = Integer.parseInt(NMP[0]);
		int M = Integer.parseInt(NMP[1]);
		int P = Integer.parseInt(NMP[2]);

		int[] S = new int[P+1];
		String[] SInput = br.readLine().split(" ");
		for (int i = 0; i < P; i++) {
			S[i+1] = Integer.parseInt(SInput[i]);
		}

		Queue<int[]>[] q = new LinkedList[P+1];
		for (int i = 1; i <= P; i++) {
			q[i] = new LinkedList<>();
		}

		int[] ans = new int[P+1];
		int[][] map = new int[N][M];

		for (int r = 0; r < N; r++) {
			char[] ch = br.readLine().toCharArray();
			for (int c = 0; c < M; c++) {
				if (ch[c] == '#') {
					map[r][c] = -1;
				} else if (ch[c] == '.') {
					map[r][c] = 0;
				} else {
					int num = ch[c] - '0';
					map[r][c] = num;
					q[num].add(new int[] {r, c});
					ans[num]++;
				}
			}
		}

		while (true) {
			boolean moved = false;

			for (int i = 1; i <= P; i++) {
				if (q[i].isEmpty()) continue;

				Queue<int[]> curr = q[i];
				Queue<int[]> next = new LinkedList<>();

				for (int j = 0; j < S[i]; j++) {
					int size = curr.size();
					if (size == 0) break;

					for (int k = 0; k < size; k++) {
						int[] now = curr.poll();
						int r = now[0];
						int c = now[1];
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
							if (map[nr][nc] != 0) continue;
							map[nr][nc] = i;
							ans[i]++;
							next.add(new int[] {nr, nc});
							moved = true;
						}
					}
					curr = next;
					next = new LinkedList<>();
				}
				q[i] = curr;
			}
			
			if (!moved) break;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= P; i++) {
			sb.append(ans[i] + " ");
		}
		
		System.out.println(sb);
		
	}
	
}

/**
 * BFS+구현
 * [문제]
 * N*M크기의 격자판에 P명이서 성 확장 게임을 한다.
 * P명이 각각 성을 이동시킬 수 있는 거리 S가 주어지고, N*M격자판에 각 숫자별 성의 위치, 빈공간(.), 벽(#)이 주어진다.
 * 각 라운드마다 순서대로 플레이어들의 성을 이동시킬 수 있는 모든 위치에 성을 확장시키면서 진행할 때
 * 더 이상 확장할 수 없는 상태일 때 각 플레이어들의 성의 수를 구하시오.
 * 
 * 각 플레이어들의 성 위치를 q[i]에 저장
 * while문으로 bfs를 진행하며 확장된 성이 있을 경우 계속 진행
 * 
 * 1번부터 순서대로 라운드를 진행하며
 * curr에 해당 번호 성 위치를 담은 후 S[i] 거리만큼 탐색 진행
 * 진행 후 다시 q[i]에 저장된 위치들 담은 후 다음 번호 진행
 * 확장된 성이 없을 경우 종료
 * 
 * 탐색 과정에서 성이 확장될 때마다 ans배열에 카운트 증가
 * 이후 정답 출력
 */

