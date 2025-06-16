package ssafy_1st.practice_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 인접리스트 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		List<Integer>[] alist = new ArrayList[V];
		
		for (int i = 0; i < V; i++) {
			alist[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			alist[A].add(B);
//			alist[B].add(A);
		}
		
		for (int i = 0; i < V; i++) {
			System.out.println(i+" : " + alist[i]);
		}
		
		
	}
/*
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
}
