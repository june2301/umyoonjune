package ssafy_1st.algo_2nd_0905;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Contact1238 {

public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			
			int start = sc.nextInt();
			
			int[][] graph = new int[101][101];
			for (int i = 0; i < N/2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				graph[from][to] = 1;
				// r:from c:to 기록
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			int[] visit = new int[101];
			
			// 시작 지점 queue에 삽입 / 방문했으니 1
			q.add(start);
			visit[start] = 1;
			
			int index = 0;
			int ans = 0;
			while (!q.isEmpty()) {
				int max = 0;
				for (int i = 0; i < q.size(); i++) { // q에 들어있는만큼만 꺼내기
					index = q.poll();
					for (int j = 0; j < 101; j++) {
						if (graph[index][j] == 1 && visit[j] == 0) { // 기록되어있고, 방문안했고
							q.add(j);
							visit[j] = 1;
							if (j > max) { // 같은 순번 중 가장 큰 값
								max = j;
							}
						}
					}
					if (max > 0) { // 마지막 순번으로 업데이트
						ans = max;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
			
		}
		
	}

}
