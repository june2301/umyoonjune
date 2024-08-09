package algo_day3;

import java.util.Scanner;

public class swea1954_강사님2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 1. 문제를 읽기
		// 2. 입력 받기
		// 3. 입력값 -> 출력값 생각해보기

		// 테스트케이스 수 입력받기
		int T = sc.nextInt();

		// 테스트케이스 수만큼 반복.
		for (int tc = 1; tc <= T; tc++) {
			// N 입력받기

			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			// 2차원 배열만들고
			// 왼쪽 위에서부터 숫자를 채워나가기
			// N*N번(1~N*N) 만큼 반복이 일어남.

			int cnt = 0; // 1 ~ N*N까지 반복
			int r = 0;
			int c = 0; // (0,0)부터 출발
			int d = 0; // 우(0),하(1),좌(2),상(3)

			// 델타배열 만들기.
			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };

			// cnt 증가, 좌표값 집어넣는것, 이동하는 것.

			while (cnt++ < N * N) { // for문, while문
				// 1. 현재 (r,c) 위치에 cnt 넣기
				arr[r][c] = cnt;

				// 2. 그 다음 좌표 만들기
				// 2-1. 일단 그 방향으로 좌표를 만든다.
				int nr = r + dr[d];
				int nc = c + dc[d];

				// 2-2. 만약에 경계조건을 벗어낫거나, 이미 그 자리에 0이 아닌 숫자가 있는 경우.
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || arr[nr][nc] != 0) {
					d = (d + 1) % 4; // 방향 전환
					// 새로운 방향으로 새좌표를 다시 만들어서 뒤집어 쓴다.
					nr = r + dr[d];
					nc = c + dc[d];
				}
				// if문을 나오고나면 (nr, nc)에 새로운 좌표가 들어있음.
				r = nr;
				c = nc;
			}

			System.out.println("#" + tc);
			for (r = 0; r < N; r++) {
				for (c = 0; c < N; c++) {
					System.out.print(arr[r][c] + " ");
				}
				System.out.println();
			}

		}

	}

}
