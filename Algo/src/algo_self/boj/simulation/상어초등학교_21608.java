package algo_self.boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 상어초등학교_21608 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] room = new int[N][N];
		
		List<Integer>[] list = new ArrayList[N*N+1];
		for (int i = 1; i <= N*N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < N*N; i++) {
			String[] input = br.readLine().split(" ");
			int who = Integer.parseInt(input[0]);
			
			for (int j = 1; j < 5; j++) {
				list[who].add(Integer.parseInt(input[j]));
			}
			
			int[] high = {-1, -1, N, N};
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int cnt1 = 0;
					int cnt2 = 0;
					if (room[r][c] != 0) continue;
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (nr < 0 || nc < 0 || nr >= N || nc >= N ) continue;
						if (list[who].contains(room[nr][nc])) {
							cnt1++;
						} else if (room[nr][nc] == 0) {
							cnt2++;
						}
					}
					if (cnt1 > high[0]) {
						high[0] = cnt1;
						high[1] = cnt2;
						high[2] = r;
						high[3] = c;
					} else if (cnt1 == high[0] && cnt2 > high[1]) {
						high[1] = cnt2;
						high[2] = r;
						high[3] = c;
					} else if (cnt1 == high[0] && cnt2 == high[1]) {
						if (r < high[2] || (r == high[2] && c < high[3])) {
							high[2] = r;
							high[3] = c;
						}
					}
				}
			}
			
			room[high[2]][high[3]] = who;
			
		}
		
		int ans = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N ) continue;
					if (list[room[r][c]].contains(room[nr][nc])) {
						cnt++;
					}
				}
				ans += cnt == 0 ? 0 : Math.pow(10, cnt-1);
			}
		}
		
		System.out.println(ans);
		
	}

}

/**
 * 시뮬레이션(구현)
 * [문제]
 * N*N교실에 학생이 N*N명이 있고, 선생님이 학생의 순서를 정하고 좋아하는 학생 4명을 조사했다.
 * 이 때 아래 조건에 맞게 학생들을 입력받는 순서대로 자리를 배치해라.
 * 조건
 * 1. 좋아하는 학생이 가장 많이 인접한 칸
 * 2. 1조건이 여러 개면 주위에 비어있는 칸이 가장 많은 칸
 * 3. 2조건이 여러 개면 r이 가장 작고, 그 다음 c가 가장 작은 칸
 * 여기서 좋아하는 학생이 인접한 칸에 있는 수에 따라 0, 1, 10, 100, 1000를 더해 학생 만족도의 총 합을 구하시오.
 * 
 * 학생 위치를 입력하기 위해 N*N배열을 만들고,
 * 학생마다 좋아하는 친구를 입력해두기 위해 List<Integer>[] 생성
 * 
 * 학생을 한 명 입력받을 때마다 room[r][c]에 학생이 없는 칸을 찾으며 N*N에서 위치 찾기
 * high[4]배열을 만들어 각 자리마다 [0] = 주변좋아하는친구수 / [1] = 주변빈자리수 / [2] = r / [3] = c 저장하며 비교
 * if문들의 조건
 * 1. [0]이 가장 큰 경우 해당 자리 배치
 * 2. [0]이 같은데 [1]이 큰 경우 해당 자리 배치
 * 3. [0],[1]이 같으면 이전 r과 비교하여 더 낮은 r, 이전 c와 비교하여 더 낮은 c
 * 
 * 여기서 high배열을 선언할 때 {-1, -1, N, N}으로 초기화하는 이유
 * : 0, 0, 0, 0 으로 시작하면 r,c가 0,0인 것으로 취급되어 문제들 발생
 * ex) [0] = 0, [1] = 0일 경우 이미 0,0에 배치된 것으로 취급되어 배치되지 않는 상황 발생
 * 
 * 이후 구해둔 room[][]을 통해서 학생 만족도 총합 계산
 * 10의 제곱으로 커지므로 제곱식 구현
 */

