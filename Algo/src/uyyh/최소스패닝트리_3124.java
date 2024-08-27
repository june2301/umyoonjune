package uyyh;

import java.util.Scanner;

public class 최소스패닝트리_3124 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int[][] node = new int[E][E];
		for (int i = 0; i < E; i++) {
			for (int j = 0; j < E; j++) {
				node[i][j] = sc.nextInt();
			}
		}
		
		// 노드 파고
		// 입력 받은거 노드에 넣고
		// pq에 첫번째 넣고
		// pq에서 빼고 가중치 비교하면서 더하기
		
		
	}

}
