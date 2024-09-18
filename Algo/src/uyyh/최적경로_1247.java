package uyyh;

import java.util.Scanner;

public class 최적경로_1247 {

	static int N;
	static int[][] spot;
	static int[] home;
	static boolean[] visited;
	static int ans;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			spot = new int[N + 1][2];
			spot[0][0] = sc.nextInt();
			spot[0][1] = sc.nextInt();
			
			home = new int[2];
			home[0] = sc.nextInt();
			home[1] = sc.nextInt();

			for (int i = 1; i <= N; i++) {
				spot[i][0] = sc.nextInt();
				spot[i][1] = sc.nextInt();
			}
			
			visited = new boolean[N + 1];
			
			ans = Integer.MAX_VALUE;
			
			perm(0, 0, 0);
			
			System.out.println("#" + tc + " " + ans);
		}

	}

	public static void perm(int curr, int cnt, int dist) {
		if (cnt == N) {
			dist += Math.abs(spot[curr][0] - home[0]) + Math.abs(spot[curr][1] - home[1]);
			ans = Math.min(ans, dist);
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int diff = Math.abs(spot[curr][0] - spot[i][0]) + Math.abs(spot[curr][1] - spot[i][1]);
				perm(i, cnt + 1, dist + diff);
				visited[i] = false;
			}
		}
	}

}
