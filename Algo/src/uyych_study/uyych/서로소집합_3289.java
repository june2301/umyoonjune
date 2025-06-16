package uyych_study.uyych;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 서로소집합_3289 {
	
	static int[] p; // root저장
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 정점
			int M = sc.nextInt(); // 연산
			
			p = new int[N+1];
			for (int i = 1; i < N+1; i++) {
				p[i] = i;
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < M; i++) {
				List<Integer> input = new ArrayList<Integer>();
				int check = sc.nextInt();
				
				if (check == 0) { // 0일 경우 합치기
					int a = sc.nextInt();
					int b = sc.nextInt();
					if (find(a) != find(b)) {
						union(find(a), find(b));
					}
				}
				if (check == 1) { // 1일 경우 root 같은지 확인
					int a = sc.nextInt();
					int b = sc.nextInt();
					if (find(a) == find(b)) {
						System.out.print("1");
					}else {
						System.out.print("0");
					}
				}
			}
			System.out.println();
		}
	}
	
	static int find(int x) {
		if (x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
	
	static void union(int x, int y) {
		p[y] = p[x];
	}
	
}
