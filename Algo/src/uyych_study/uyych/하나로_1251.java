package uyych_study.uyych;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 하나로_1251 {
	
	static class Edge implements Comparable<Edge>{
		int Form;
		int To;
		double W;
		
		public Edge(int from, int to, double w) {
			super();
			Form = from;
			To = to;
			W = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.W, o.W);
		}
	}
	
	static int[] p; // root 저장

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			Edge[] edges = new Edge[N>2 ? N + ((N*(N-3))/2) : N-1];
			
			p = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}
			
			int[] xs = new int[N];
			int[] ys = new int[N];
			for (int i = 0; i < N; i++) {
				xs[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				ys[i] = sc.nextInt();
			}
			
			double E = sc.nextDouble(); // 배율
			
			// 가중치W 저장과정
			// list를 통해 입력 및 계산 후 배열로 옮기기
			List<Edge> saveE = new ArrayList<>();
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) { // 모든 간선 경우의 수 계산
					double w = Math.sqrt(Math.pow(xs[i]-xs[j], 2) + Math.pow(ys[i]-ys[j], 2));
					saveE.add(new Edge(i, j, w));
				}
			}
			for (int i = 0; i < N + ((N*(N-3))/2); i++) {
				edges[i] = saveE.get(i);
			}
			// 가중치 기준 정렬
			Arrays.sort(edges);
			
			double sum = 0;
			// 크루스칼 알고리즘
			for (int i = 0; i < edges.length; i++) {
				int x = find(edges[i].Form);
				int y = find(edges[i].To);
				// 두 간선의 root가 다르다면
				if (x != y) {
					union(x, y);
					sum += Math.pow(edges[i].W, 2);
				}
			}
			System.out.println("#" + tc + " " + Math.round(E*sum));
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
