package algo_2nd_0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 상호배틀필드_1873 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			String[] HW = br.readLine().split(" ");
			int H = Integer.parseInt(HW[0]);
			int W = Integer.parseInt(HW[1]);
			char[][] map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String input = br.readLine();
				map[i] = input.toCharArray();
			}
			int locR = 0;
			int locC = 0;
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					if(map[r][c] == '<' || map[r][c] == '>' || map[r][c] == '^' || map[r][c] == 'v') {
						locR = r;
						locC = c;
					}
				}
			}
			
			// 커멘트 Queue에 저장
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			char[] cmd = input.toCharArray();
			Queue<Character> q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				q.add(cmd[i]);
			}
			
			while (N > 0) {
				char save = q.poll();
				
				// 발사 커멘드
				if (save == 'S') {
					// 방향 확인 후 #로 막혀있는지 확인 후 * -> . 으로 바꾸기
					if (map[locR][locC] == '<') {
						for (int c = 1; c <= locC; c++) {
							if (map[locR][locC - c] == '#') {
								break;
							}else if (map[locR][locC - c] == '*') {
								map[locR][locC - c] = '.';
								break;
							}
						}
					}
					if (map[locR][locC] == '>') {
						for (int c = 1; c < W - locC; c++) {
							if (map[locR][locC + c] == '#') {
								break;
							}else if (map[locR][locC + c] == '*') {
								map[locR][locC + c] = '.';
								break;
							}
						}
					}
					if (map[locR][locC] == '^') {
						for (int r = 1; r <= locR; r++) {
							if (map[locR - r][locC] == '#') {
								break;
							}else if (map[locR - r][locC] == '*') {
								map[locR - r][locC] = '.';
								break;
							}
						}
					}
					if (map[locR][locC] == 'v') {
						for (int r = 1; r < H - locR; r++) {
							if (map[locR + r][locC] == '#') {
								break;
							}else if (map[locR + r][locC] == '*') {
								map[locR + r][locC] = '.';
								break;
							}
						}
					}
				}
				
				// 이동 커멘드
				// 방향 먼저 바꾸고
				// 이동 가능한지 확인 후 이동
				if (save == 'U') {
					map[locR][locC] = '^';
					if (locR-1 >= 0 && map[locR-1][locC] == '.') {
						char tmp = map[locR][locC];
						map[locR][locC] = map[locR-1][locC];
						map[locR-1][locC] = tmp;
						locR = locR-1;
					}
				}
				if (save == 'D') {
					map[locR][locC] = 'v';
					if (locR + 1 < H && map[locR+1][locC] == '.') {
						char tmp = map[locR][locC];
						map[locR][locC] = map[locR+1][locC];
						map[locR+1][locC] = tmp;
						locR = locR+1;
					}
					
				}
				if (save == 'R') {
					map[locR][locC] = '>';
					if (locC + 1 < W && map[locR][locC+1] == '.') {
						char tmp = map[locR][locC];
						map[locR][locC] = map[locR][locC+1];
						map[locR][locC+1] = tmp;
						locC = locC+1;
					}
					
				}
				if (save == 'L') {
					map[locR][locC] = '<';
					if (locC - 1 >= 0 && map[locR][locC-1] == '.') {
						char tmp = map[locR][locC];
						map[locR][locC] = map[locR][locC-1];
						map[locR][locC-1] = tmp;
						locC = locC-1;
					}
					
				}
				N--;
			}
			System.out.print("#" + tc + " ");
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			}
		}
	}		
}
