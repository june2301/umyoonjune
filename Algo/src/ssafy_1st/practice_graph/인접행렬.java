package ssafy_1st.practice_graph;

import java.util.Iterator;
import java.util.Scanner;

public class 인접행렬 {

	public static void main(String[] args) {
		
/*
// 무향
0 1
1 0
0 2
2 0
0 5
5 0
0 6
6 0
5 3
3 5
5 4
4 5
3 4
4 3
6 4
4 6

// 유향
7 8
0 1 1
0 2 2
0 5 3
0 6 4
5 3 5
5 4 6
4 3 7
6 4 8
// 유향
7 8
0 1 
0 2 
0 5 
0 6 
5 3 
5 4 
4 3 
6 4 
 */
		
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점
		int E = sc.nextInt(); // 간선
		
		int[][] map = new int[V][V];
		
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
//			int W = sc.nextInt();
			map[A][B] = 1;
		}
		
		for (int r = 0; r < V; r++) {
			for (int c = 0; c < V; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		
		
		
		
		
	}

}
