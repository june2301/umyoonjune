package uyyh;

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
				if (o.get(i).dir == 1) { // 상
					map[o.get(i).r][o.get(i).c]--;
					o.get(i).r--;
					map[o.get(i).r][o.get(i).c]++;
					
				}else if (o.get(i).dir == 2) { // 하
					map[o.get(i).r][o.get(i).c]--;
					o.get(i).r++;
					map[o.get(i).r][o.get(i).c]++;
					
				}else if (o.get(i).dir == 3) { // 좌
					map[o.get(i).r][o.get(i).c]--;
					o.get(i).c--;
					map[o.get(i).r][o.get(i).c]++;
					
				}else if (o.get(i).dir == 4) { // 우
					map[o.get(i).r][o.get(i).c]--;
					o.get(i).c++;
					map[o.get(i).r][o.get(i).c]++;
				}
			}
			// 사이드 도착 - 방향 변경, 미생물 반토막
			for (int i = 0; i < o.size(); i++) { 
				if (o.get(i).r == 0 || o.get(i).r == N-1) {
					if (o.get(i).dir == 1) {
						o.get(i).dir = 2;
					}
					else if (o.get(i).dir == 2) {
						o.get(i).dir = 1;
					}
					o.get(i).cell = o.get(i).cell/2;
				}
				if (o.get(i).c == 0 || o.get(i).c == N-1) {
					if (o.get(i).dir == 3) {
						o.get(i).dir = 4;
					}
					else if (o.get(i).dir == 4) {
						o.get(i).dir = 3;
					}
					o.get(i).cell = o.get(i).cell/2;
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
			for (int i = 0; i < o.size(); i++) {
				System.out.println(M+"번 실행");
				System.out.println(i+"번째 organ");
				System.out.println("r : " + o.get(i).r);
				System.out.println("c : " + o.get(i).c);
				System.out.println("cell : " + o.get(i).cell);
				System.out.println("dir : " + o.get(i).dir);
				System.out.println();
			}
		}
		int ans = 0;
		for (int i = 0; i < o.size(); i++) {
			ans += o.get(i).cell;
		}
		
		System.out.println(ans);
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
				}
				save.add(o.get(i));
			}
		}
		System.out.println("savesize: " + save.size());
		for (int i = 0; i < save.size(); i++) {
			if (save.get(i).cell == max) {
				king = save.get(i);
			}
			sum += save.get(i).cell;
		}
		king.cell = sum;
		
		for (int i = 0; i < o.size(); i++) {
			if (o.get(i).r == r && o.get(i).c == c) {
				o.remove(i);
			}
		}
		o.add(king);
		
	}

}
