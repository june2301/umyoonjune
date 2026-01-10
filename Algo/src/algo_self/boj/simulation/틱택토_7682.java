package algo_self.boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 틱택토_7682 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String input = br.readLine();
			if (input.equals("end")) break;
			
			char[][] map = new char[3][3];
			int idx = 0;
			int Ocnt = 0;
			int Xcnt = 0;
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					char curr = input.charAt(idx++);
					if (curr == 'O') Ocnt++;
					else if (curr == 'X') Xcnt++;
					map[r][c] = curr;
				}
			}
			
			if (!(Ocnt == Xcnt || Ocnt + 1 == Xcnt)) {
				sb.append("invalid" + '\n');
				continue;
			}
			
			int Obin = count(map, 'O');
			int Xbin = count(map, 'X');
			
			
			if (Xbin > 0 && Obin > 0) {
				sb.append("invalid" + '\n');
				continue;
			}
			if (Xbin > 0 && !(Xcnt == Ocnt+1)) {
				sb.append("invalid" + '\n');
				continue;
			}
			if (Obin > 0 && !(Xcnt == Ocnt)) {
				sb.append("invalid" + '\n');
				continue;
			}
			if (Obin + Xbin < 1 && Ocnt + Xcnt != 9) {
				sb.append("invalid" + '\n');
				continue;
			}
			
			
			sb.append("valid" + '\n');
			
		}
		
		System.out.println(sb);
		
	}
	
	static int count(char[][] c, char A) {
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			if (c[i][0] == A && c[i][0] == c[i][1] && c[i][1] == c[i][2]) {
				cnt++;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (c[0][i] == A && c[0][i] == c[1][i] && c[1][i] == c[2][i]) {
				cnt++;
			}
		}
		if (c[0][0] == A && c[0][0] == c[1][1] && c[1][1] == c[2][2]) {
			cnt++;
		}
		if (c[0][2] == A && c[0][2] == c[1][1] && c[1][1] == c[2][0]) {
			cnt++;
		}
		return cnt;
	}

}

/**
 * 시뮬레이션
 * [문제]
 * 틱택토 : 반드시 X 먼저 시작해서 어느 라인이든 3개를 완성하면 이기며 게임 종료
 * 게임판의 상태를 보고 최종 상태로 가능한 경우면 valid / 불가능하면 invalid를 출력하시오.
 * 
 * 9개의 정보를 char[][] map으로 기록하며 O와 X 개수 카운트
 * 가로/세로/대각선에 대하여 O와 X의 빙고 개수 카운트
 * 이 정보를 바탕으로 불가능한 경우 제외
 * 
 * 불가능한 경우
 * > X가 먼저 두기 때문에 X개수=O개수 or X개수=O개수+1 가 아닌 경우
 * > X도 빙고가 1개 이상 O도 빙고가 1개 이상인 경우
 * > X가 빙고인데 X돌의 개수가 O보다 1개만 많지 않은 경우(1개만 많아야 됨 - 즉시 종료)
 * > O가 빙고인데 O돌 개수 = X돌 개수 가 아닌 경우
 * > 둘 다 빙고가 없는데 아직 돌을 다 안 둔 경우
 */

