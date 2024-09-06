package algo_2nd_0906;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 미생물격리_2382 {
	
	static class Organ {
		int r;
		int c;
		int cell;
		int dir;
		
		public Organ(int r, int c, int cell, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.cell = cell;
			this.dir = dir;
		}
	}
	
	static int N, M, K;
	static int[][] map;
	static List<Organ> o;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N][N];
			
			o = new ArrayList<>();
			
			for (int i = 0; i < K; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				int cell = sc.nextInt();
				int dir = sc.nextInt();
				map[r][c] = 1;
				o.add(new Organ(r, c, cell, dir));
			}
			// dir : 1234 : 상하좌우
			while (M > 0) {
				for (int i = 0; i < o.size(); i++) {
					Organ check = o.get(i);
					map[check.r][check.c]--;
					if (check.dir == 1) { // 상
						check.r--;
					}else if (check.dir == 2) { // 하
						check.r++;
					}else if (check.dir == 3) { // 좌
						check.c--;
					}else if (check.dir == 4) { // 우
						check.c++;
					}
					
					map[check.r][check.c]++;
				}
				
				// 사이드 도착 - 방향 변경, 미생물 반토막
				for (int i = 0; i < o.size(); i++) { 
					Organ check = o.get(i);
					if (check.r == 0 || check.r == N-1) {
						if (check.dir == 1) {
							check.dir = 2;
						}else if (check.dir == 2) {
							check.dir = 1;
						}
						check.cell /= 2;
					}
					if (check.c == 0 || check.c == N-1) {
						if (check.dir == 3) {
							check.dir = 4;
						}else if (check.dir == 4) {
							check.dir = 3;
						}
						check.cell /= 2;
					}
				}
				
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (map[r][c] > 1) {
							merge(r, c);
							map[r][c] = 1;
						}
					}
				}
				M--;
			}
			int ans = 0;
			for (int i = 0; i < o.size(); i++) {
				ans += o.get(i).cell;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void merge(int r, int c) {
		int max = 0;
		int sum = 0;
		Organ king = null;
		List<Organ> save = new ArrayList<>();
		for (int i = 0; i < o.size(); i++) {
			if (o.get(i).r == r && o.get(i).c == c) {
				if (o.get(i).cell > max) {
					max = o.get(i).cell;
					king = o.get(i);
				}
				sum += o.get(i).cell;
				save.add(o.get(i));
			}
		}
		if (king != null) {
			king.cell = sum;
		}
		// 겹치는거 다 제거 후 king만 더하기
		o.removeAll(save);
		o.add(king);
	}

}
