package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그래프트리분할_22954 {
	
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		p = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			union(x, y);
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.println(find(i));
		}
		
		
		
	}
	
	static int find(int x) {
		if (x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}

	static void union(int x, int y) {
		int rX = find(x);
        int rY = find(y);
        if (rX != rY) {
            p[rY] = rX;
        }
	}

}
