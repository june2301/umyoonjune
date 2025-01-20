package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 트리의부모찾기_11725 {
	
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		p = new int[N+1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		System.out.println(Arrays.toString(p));
		for (int i = 0; i < N-1; i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			union(a, b);
			System.out.println(i + " : " + Arrays.toString(p));
		}
		
		for (int i = 2; i <= N; i++) {
			System.out.println(p[i]);
		}
		
	}
	
	static int find(int x) {
		if(x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
	
	static void union(int x, int y) {
		int rx = find(x);
		int ry = find(y);
		if (rx != ry) {
			p[ry] = rx;
		}
	}

}
