package uyyh;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class 격자판2819 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int[][] map = new int[4][4];
			for (int r = 0; r < 4; r++) {
				for (int c = 0; c < 4; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			// 상 우 하 좌
			int[] dr = {-1, 0, 1, 0};
			int[] dc = {0, 1, 0, -1};
			
			Set<String> set = new HashSet<>();
			for (int r = 0; r < 4; r++) {
				for (int c = 0; c < 4; c++) {
					Queue<String> q = new LinkedList<>();
					q.add(map[r][c] + " " + r + " " + c); // 좌표 함께 저장
					
					while (!q.isEmpty()) {
						String[] info = q.poll().split(" ");
						String nums = info[0];
						int rr = Integer.parseInt(info[1]);
						int cc = Integer.parseInt(info[2]);
						
						if (nums.length() == 7) { // 7개 쌓이면 저장 & 초기화
							set.add(nums);
							nums = "";
							continue;
						}
						for (int d = 0; d < 4; d++) {
							int nr = rr + dr[d];
							int nc = cc + dc[d];
							if (nr < 4 && nc < 4 && nr >= 0 && nc >= 0) {
								// 값 누적 &마지막 좌표 함께 저장
								q.add(nums + map[nr][nc] + " " + nr + " " + nc); 
							}
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + set.size());
		}
		
	}

}
