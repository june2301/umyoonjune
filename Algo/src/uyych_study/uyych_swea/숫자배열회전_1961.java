package uyych_study.uyych_swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자배열회전_1961 {

	private static int[][] asd; // 실행시마다 최기화

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			asd = new int[N][N];
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine()); // 띄어쓰기 구분
				for (int k = 0; k < N; k++) {
					asd[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#" + tc);
			for (int j = 0; j < N; j++) {
				sb = new StringBuilder(); // sb로 한줄씩 출력
				for (int k = 0; k < N; k++) {
					sb.append(asd[N-1 - k][j]);
				}
				sb.append(" ");
				for (int k = 0; k < N; k++) {
					sb.append(asd[N-1 - j][N-1 - k]);
				}
				sb.append(" ");
				for (int k = 0; k < N; k++) {
					sb.append(asd[k][N-1 - j]);
				}
				System.out.println(sb);
			}
		}
	}
}