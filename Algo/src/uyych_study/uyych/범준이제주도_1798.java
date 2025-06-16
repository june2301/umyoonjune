package uyych_study.uyych;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 범준이제주도_1798 {
	
	static class Edge {
		int from;
		int to;
		int time;
		
		public Edge(int from, int to, int time) {
			this.from = from;
			this.to = to;
			this.time = time;
		}
	}
	
	static int N, M, ans;
	static List<Edge> edges;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 지점 개수
		M = sc.nextInt(); // 휴가 기간
		
		edges = new ArrayList<Edge>();
		for (int i = 1; i < N; i++) {
			for (int j = 1+i; j <= N ; j++) {
				int time = sc.nextInt();
				Edge newEdge1 = new Edge(i, j, time);
				Edge newEdge2 = new Edge(j, i, time);
				edges.add(newEdge1);
				edges.add(newEdge2);
			}
		}
		
		int[][] place = new int[N-3][N-3];
		
		
		
		
		
	}

}
