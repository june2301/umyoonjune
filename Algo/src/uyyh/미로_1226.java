package uyyh;

import java.util.Iterator;
import java.util.Scanner;

public class 미로_1226 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
//		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			
			int[][] map = new int[16][16];
			
			for (int r = 0; r < map.length; r++) {
				String[] input = sc.next().split("");
				for (int c = 0; c < map.length; c++) {
					map[r][c] = Integer.parseInt(input[c]);
				}
			}
			// 하 우 상 좌
			int[] dr = {1, 0, -1, 0};
			int[] dc = {0, 1, 0, -1};
			int cnt = 0;
			// 막힌 부분 제거
			for (int i = 0; i < 16*16; i++) {
				for (int r = 1; r < map.length-1; r++) {
					for (int c = 1; c < map.length-1; c++) {
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if (map[r][c] == 0 && map[nr][nc] == 1) {
								cnt++;
								if (cnt == 3) {
									map[r][c] = 1;
								}
							}
						}
						cnt = 0;
					}
				}
			}
			
			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map.length; c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			}
			
			
			int r = 1;
			int c = 1;
			int ans = 0;
			cnt = 0;
			// 연결되어있는지 확인 -> 2출발 3도착시 ans = 1;
			// 끊겨있을 경우를 확인하는 방향으로...
			while (map[r][c] != 3) {
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (map[nr][nc] == 0 || map[nr][nc] == 3) {
						map[r][c] = 1;
						r = nr;
						c = nc;
					}
					if (map[nr][nc] == 1) {
						cnt++;
					}
					System.out.println("r " + r + "c " + c);
				}
				if (map[r][c] == 3) {
					ans = 1;
					System.out.println("r " + r + "c " + c);
					break;
				}
				if (cnt == 4) {
					ans = 0;
					System.out.println("r `" + r + "c " + c);
					break;
				}
				cnt = 0;
			}
			
			System.out.println("#" + T + " " + ans);
			
//		}
		
		
	}

}
